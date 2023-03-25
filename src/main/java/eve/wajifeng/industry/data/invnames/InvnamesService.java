package eve.wajifeng.industry.data.invnames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvnamesService {

    public final InvnamesRepository invnamesRepository;

    @Autowired
    public InvnamesService(InvnamesRepository invnamesRepository) {
        this.invnamesRepository = invnamesRepository;
    }

    public List<Invnames> getItems() {
        return invnamesRepository.findAll();
    }

}
