package eve.wajifeng.industry.industryactivityproducts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryactivityproductsService {

    public final IndustryactivityproductsRepository industryactivityproductsRepository;

    @Autowired
    public IndustryactivityproductsService(IndustryactivityproductsRepository industryactivityproductsRepository) {
        this.industryactivityproductsRepository = industryactivityproductsRepository;
    }

    public List<Industryactivityproducts> getItems() {
        return industryactivityproductsRepository.findAll();
    }

    public List<Industryactivityproducts> getInfo(@Param("x")int i){
        return industryactivityproductsRepository.getInfo(i);
    }

}
