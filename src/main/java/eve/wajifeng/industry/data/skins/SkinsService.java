package eve.wajifeng.industry.data.skins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinsService {

    public final SkinsRepository skinsRepository;

    @Autowired
    public SkinsService(SkinsRepository skinsRepository) {
        this.skinsRepository = skinsRepository;
    }

    public List<Skins> getItems() {
        return skinsRepository.findAll();
    }

}
