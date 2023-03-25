package eve.wajifeng.industry.dbidname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbidnameService {

    public final DbidnameRepository dbidnameRepository;

    @Autowired
    public DbidnameService(DbidnameRepository dbidnameRepository) {
        this.dbidnameRepository = dbidnameRepository;
    }

    public List<Dbidname> getItems() {
        return dbidnameRepository.findAll();
    }

    public List<Dbidname> getItemsNames(@Param("x")String s){
        return dbidnameRepository.getItemsNames(s);
    }

    public List<Dbidname> getItem(@Param("x")String d){
        return dbidnameRepository.getItem(d);
    }

}