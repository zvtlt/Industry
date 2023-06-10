package eve.wajifeng.industry.bpinfos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eve.wajifeng.industry.dbidname.Dbidname;
import eve.wajifeng.industry.dbidname.DbidnameService;
import eve.wajifeng.industry.industryactivityproducts.Industryactivityproducts;
import eve.wajifeng.industry.industryactivityproducts.IndustryactivityproductsService;
import eve.wajifeng.industry.json.Json;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class BpinfosController {

    public final DbidnameService dbidnameService;
    public final BpinfosService bpinfosService;
    public final IndustryactivityproductsService industryactivityproductsService;
    public String searched = "";
    public String name = "";
    public int id = 0;
    public String count = "";
    public double te = 0;
    public double me = 0;

    @Value("${dir.images}")
    public String imageDir;

    @Autowired
    public BpinfosController(DbidnameService dbidnameService,
                             BpinfosService bpinfosService,
                             IndustryactivityproductsService industryactivityproductsService) {
        this.dbidnameService = dbidnameService;
        this.bpinfosService = bpinfosService;
        this.industryactivityproductsService = industryactivityproductsService;
    }


    @RequestMapping(value = { "/" }, method= RequestMethod.GET)
    public String itemsget(
            @RequestParam(name="searched", defaultValue = "")String s,
            @RequestParam(name="name", defaultValue = "Please select a Blueprint")String d,
            @RequestParam(name="subComp", defaultValue = "off")String subComp,
            @RequestParam(name="te", defaultValue = "20")int bpte,
            @RequestParam(name="me", defaultValue = "10")int bpme,
            final Model model) {

        searched = s;
        name = d;
        id = 0;
        te = 1 - ((double)bpte / 100);
        me = 1 - ((double)bpme / 100);

        List<Dbidname> itList = dbidnameService.getItemsNames("%"+s+"%");

        List<Dbidname> itInfo = dbidnameService.getItem(name);
        for(Dbidname id : itInfo){
            this.id = id.getTypeID();
        }

        List<String> itName = new ArrayList<>();
        for(Dbidname name : itList){
            if(!itName.contains(name.getTypeName()))
                itName.add(name.getTypeName());
        }
        Collections.sort(itName);

        model.addAttribute("itemsName", itName);

        model.addAttribute("itemSearched", s);
        model.addAttribute("itemName", d);
        model.addAttribute("subComp", subComp);
        model.addAttribute("te", bpte);
        model.addAttribute("me", bpme);


        return "home";
    }

    @RequestMapping(value = { "/out" }, method=RequestMethod.POST)
    public String itemsFragment(Model model) throws IOException {

        //         LIST WITH INFO OF THE BLUEPRINT SELECTED
        List<Bpinfos> itInfo = bpinfosService.getInfo(id);

        //      MODIFY QUANTITY ACCORDING TO ME
        modifyQuantityFromME(itInfo);

        //         MODIFYING ICONFILE VALUES
        formatIconFile(itInfo);

        //        JSON LIST FOR MARKET PRICE + UPDATING PRICES
        jsonPriceUpdate(itInfo);

        //      UPDATE FLOAT TO 0.2F AND REMOVE EXPONENT FOR BASEPRICE AND MULTPRICE
        formatFloat(itInfo);

        //      GET TOTAL PRICE
        float total = 0;
        for(Bpinfos bp : itInfo){
            total += bp.getMultPrice();
        }

        //      UPDATE FLOAT TO 0.2F AND REMOVE EXPONENT FOR TOTALPRICE
        String totalPrice = formatFloat(total);

        //      ADD SPACES FOR PRICES
        for(Bpinfos bp : itInfo){
            bp.setBasePriceString(priceSpaces(bp.getBasePriceString()));
            bp.setMultPriceString(priceSpaces(bp.getMultPriceString()));
        }
        totalPrice = priceSpaces(totalPrice);

        //      ADDING ATTRIBUTES TO MODEL
        model.addAttribute("itInfo", itInfo);

        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("totalString", totalPrice);


        return "output :: output_frag";
    }

    @RequestMapping(value = { "/outsub" }, method=RequestMethod.POST)
    public String itemsSubFragment(Model model) throws IOException {
        count = "";

        //         LIST WITH INFO OF THE BLUEPRINT SELECTED
        List<Bpinfos> itInfo = bpinfosService.getInfo(id);

        //      MODIFY QUANTITY ACCORDING TO ME
        modifyQuantityFromME(itInfo);

        //         ADDING SUB-COMP + TOTAL PRICE
        itInfo = addSubComp(itInfo);

        //         MODIFYING ICONFILE VALUES
        formatIconFile(itInfo);

        //        JSON LIST FOR MARKET PRICE + UPDATING PRICES
        jsonPriceUpdateSubComp(itInfo);

        //      UPDATE FLOAT TO 0.2F AND REMOVE EXPONENT FOR BASEPRICE AND MULTPRICE
        formatFloat(itInfo);

        //      GET TOTAL PRICE
        float total = 0;
        for(Bpinfos bp : itInfo){
            total += bp.getMultPrice();
        }

        //      UPDATE FLOAT TO 0.2F AND REMOVE EXPONENT FOR TOTALPRICE
        String totalPrice = formatFloat(total);

        //      ADD SPACES FOR PRICES
        for(Bpinfos bp : itInfo){
            bp.setBasePriceString(priceSpaces(bp.getBasePriceString()));
            bp.setMultPriceString(priceSpaces(bp.getMultPriceString()));
        }
        totalPrice = priceSpaces(totalPrice);

        //      ADDING ATTRIBUTES TO MODEL
        model.addAttribute("itInfo", itInfo);

        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("totalString", totalPrice);


        return "outputSub :: outputSub_frag";
    }


    @RequestMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getPhoto(String iconFile) throws IOException {
        File f = new File(imageDir+iconFile);
        return IOUtils.toByteArray(new FileInputStream(f));
    }



    //      MODIFY QUANTITY ACCORDING TO ME
    public void modifyQuantityFromME(List<Bpinfos> list){
        for(Bpinfos bp : list){
            bp.setQuantity((int) Math.ceil(bp.getQuantity() * me));
        }
    }


    //       PUT SPACES IN PRICES
    public String priceSpaces(String s) throws IOException {
        String result ="";
        int size = s.length()-3;
        int rest = size%3;

        StringReader stringReader = new StringReader(s);
        stringReader.ready();

        for(int i=0; i<size; i++){
            result += Character.toString(stringReader.read());

            if(i<size-1) {
                if (i == rest - 1) {
                    result += " ";
                }
                if (i == rest + 2) {
                    result += " ";
                }
                if (i == rest + 5) {
                    result += " ";
                }
                if (i == rest + 8) {
                    result += " ";
                }
            }
        }

        stringReader.close();

        result += s.substring(size,s.length());

        return result;
    }


    //        Adding Sub-Comp
    public List<Bpinfos> addSubComp(List<Bpinfos> list) {
        List<Bpinfos> bpfinal = new ArrayList<>();
        List<Dbidname> invList;
        List<Bpinfos> subMat;
        List<Industryactivityproducts> qprod;
        String s = "";
        int i = 0;
        int quant = 0;

        for(Bpinfos bp : list){
            bpfinal.add(bp);
            count += "a";

            s = bp.getTypeName() + " Blueprint";
            invList = dbidnameService.getItem(s);
            if(!invList.isEmpty()){
                for(Dbidname inv : invList){
                    i = inv.getTypeID();

                    count = count.substring(0, count.length() - 1);
                    count += "e";
                }
                subMat = bpinfosService.getInfo(i);
                for(Bpinfos sub : subMat){

                    //      MODIFY SUB COMP QUANTITY ACCORDING TO THE QUANTITY PRODUCED FOR ONE RUN
                    qprod = industryactivityproductsService.getInfo(i);
                    for(Industryactivityproducts qprodit : qprod){
                        quant = qprodit.getQuantity();
                    }

                    sub.setQuantity((int) Math.ceil((float)bp.getQuantity() / quant) * sub.getQuantity());

                    //      MODIFY SUB COMP NAME FOR TABULATION IN VIEW
                    sub.setTypeName("|____"+ sub.getTypeName());

                    bpfinal.add(sub);
                    count += "b";
                }
            }
        }
        return bpfinal;
    }


    //         MODIFYING ICONFILE VALUES
    public void formatIconFile(List<Bpinfos> list){
        for(Bpinfos bp : list){
            String a = bp.getIconFile();
            String str = a.substring(a.indexOf('/') + 1);
            String str1 = str.substring(str.indexOf('/') + 1);
            String str2 = str1.substring(str1.indexOf('/') + 1);
            String str3 = str2.substring(str2.indexOf('/') + 1);
            bp.setIconFile(str3);
        }
    }


    //        JSON LIST FOR MARKET PRICE + UPDATING PRICES
    public void jsonPriceUpdate(List<Bpinfos> itInfo) throws IOException {
        //        JSON LIST FOR MARKET PRICE
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(
                "https://esi.evetech.net/latest/markets/prices/?datasource=tranquility", String.class);
        List<Json> list = new ObjectMapper().readValue(response, new TypeReference<List<Json>>(){});

        //        UPDATING BASEPRICE VALUE WITH JSON
        for(Bpinfos bp : itInfo){
            for(Json json : list){
                if(bp.getMaterialID() == json.type_id){
                    bp.setBasePrice(json.getAverage_price());
                }
            }
        }

        //       UPDATING MULTPRICE

        for(Bpinfos bp : itInfo){
            bp.setMultPrice(bp.getBasePrice()*bp.getQuantity());
        }
    }


    //        JSON LIST FOR MARKET PRICE + UPDATING PRICES FOR SUB-COMP
    public void jsonPriceUpdateSubComp(List<Bpinfos> itInfo) throws IOException {
        //        JSON LIST FOR MARKET PRICE
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(
                "https://esi.evetech.net/latest/markets/prices/?datasource=tranquility", String.class);
        List<Json> list = new ObjectMapper().readValue(response, new TypeReference<List<Json>>(){});

        //        UPDATING BASEPRICE VALUE WITH JSON
        for(Bpinfos bp : itInfo){
            for(Json json : list){
                if(bp.getMaterialID() == json.type_id){
                    bp.setBasePrice(json.getAverage_price());
                }
            }
        }

        StringReader stringReader = new StringReader(count);
        stringReader.ready();

        //       UPDATING MULTPRICE AND TOTAL PRICE


        for(Bpinfos bp : itInfo){
            bp.setMultPrice(bp.getBasePrice()*bp.getQuantity());

            String chr = Character.toString(stringReader.read());

            if(chr.equals("e")){
                bp.setMultPrice(0);
            }

        }

        stringReader.close();
    }


    //      UPDATE FLOAT TO 0.2F AND REMOVE EXPONENT FOR BASEPRICE AND MULTPRICE
    public void formatFloat(List<Bpinfos> itInfo){

        for(Bpinfos bp : itInfo){
            String str = "";

            try {
                str = String.format("%.2f", bp.getBasePrice()).replaceFirst(",", ".");
                bp.setBasePriceString(str);
            }catch (Exception e){
            }

            try {
                str = String.format("%.2f", bp.getMultPrice()).replaceFirst(",", ".");
                bp.setMultPriceString(str);
            }catch (Exception e){
            }

            try {
                str = String.format("%.2f", bp.getVolume()).replaceFirst(",", ".");
                bp.setVolumeString(str);
            }catch (Exception e){
            }
        }
    }


    //      UPDATE FLOAT TO 0.2F AND REMOVE EXPONENT FOR TOTALPRICE
    public String formatFloat(float total){
        String totalString = "";

        try {
            String str = String.format("%.2f", total).replaceFirst(",", ".");
            totalString = str;
        }catch (Exception e){
        }

        return totalString;
    }

}
