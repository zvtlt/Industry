package eve.wajifeng.industry.data.invtypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvtypesService {

    public final InvtypesRepository invtypesRepository;

    @Autowired
    public InvtypesService(InvtypesRepository invtypesRepository) {
        this.invtypesRepository = invtypesRepository;
    }

    public List<Invtypes> getInfo(@Param("x")int i) {
        return invtypesRepository.getInfo(i);
    }

    public List<Invtypes> getInfo(@Param("x")String s) {
        return invtypesRepository.getInfo(s);
    }

}
