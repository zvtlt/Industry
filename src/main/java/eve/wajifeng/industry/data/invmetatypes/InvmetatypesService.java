package eve.wajifeng.industry.data.invmetatypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvmetatypesService {

    public final InvmetatypesRepository invmetatypesRepository;

    @Autowired
    public InvmetatypesService(InvmetatypesRepository invmetatypesRepository) {
        this.invmetatypesRepository = invmetatypesRepository;
    }

    public List<Invmetatypes> getItems() {
        return invmetatypesRepository.findAll();
    }

}
