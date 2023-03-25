package eve.wajifeng.industry.data.invmetagroups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvmetagroupsService {

    public final InvmetagroupsRepository invmetagroupsRepository;

    @Autowired
    public InvmetagroupsService(InvmetagroupsRepository invmetagroupsRepository) {
        this.invmetagroupsRepository = invmetagroupsRepository;
    }

    public List<Invmetagroups> getItems() {
        return invmetagroupsRepository.findAll();
    }

}
