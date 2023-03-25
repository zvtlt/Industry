package eve.wajifeng.industry.data.invgroups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvgroupsService {

    public final InvgroupsRepository invgroupsRepository;

    @Autowired
    public InvgroupsService(InvgroupsRepository invgroupsRepository) {
        this.invgroupsRepository = invgroupsRepository;
    }

    public List<Invgroups> getItems() {
        return invgroupsRepository.findAll();
    }

}
