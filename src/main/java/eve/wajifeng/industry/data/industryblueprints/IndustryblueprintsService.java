package eve.wajifeng.industry.data.industryblueprints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryblueprintsService {

    public final IndustryblueprintsRepository industryblueprintsRepository;

    @Autowired
    public IndustryblueprintsService(IndustryblueprintsRepository industryblueprintsRepository) {
        this.industryblueprintsRepository = industryblueprintsRepository;
    }

    public List<Industryblueprints> getItems() {
        return industryblueprintsRepository.findAll();
    }

}
