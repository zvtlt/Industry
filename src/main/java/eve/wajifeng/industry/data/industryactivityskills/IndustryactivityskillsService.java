package eve.wajifeng.industry.data.industryactivityskills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IndustryactivityskillsService {

    public final IndustryactivityskillsRepository industryactivityskillsRepository;

    @Autowired
    public IndustryactivityskillsService(IndustryactivityskillsRepository industryactivityskillsRepository) {
        this.industryactivityskillsRepository = industryactivityskillsRepository;
    }

    public List<Industryactivityskills> getItems() {
        return industryactivityskillsRepository.findAll();
    }

}