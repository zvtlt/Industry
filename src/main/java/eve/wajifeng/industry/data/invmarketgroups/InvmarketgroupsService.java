package eve.wajifeng.industry.data.invmarketgroups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvmarketgroupsService {

    public final InvmarketgroupsRepository invmarketgroupsRepository;

    @Autowired
    public InvmarketgroupsService(InvmarketgroupsRepository invmarketgroupsRepository) {
        this.invmarketgroupsRepository = invmarketgroupsRepository;
    }

    public List<Invmarketgroups> getItems() {
        return invmarketgroupsRepository.findAll();
    }
}
