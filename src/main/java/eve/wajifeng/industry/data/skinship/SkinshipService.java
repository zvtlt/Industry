package eve.wajifeng.industry.data.skinship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinshipService {

    public final SkinshipRepository skinsRepository;

    @Autowired
    public SkinshipService(SkinshipRepository skinsRepository) {
        this.skinsRepository = skinsRepository;
    }

    public List<Skinship> getItems() {
        return skinsRepository.findAll();
    }

}
