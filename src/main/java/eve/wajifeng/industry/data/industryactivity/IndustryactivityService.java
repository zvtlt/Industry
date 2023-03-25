package eve.wajifeng.industry.data.industryactivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryactivityService {

    public final IndustryactivityRepository industryactivityRepository;

    @Autowired
    public IndustryactivityService(IndustryactivityRepository industryactivityRepository) {
        this.industryactivityRepository = industryactivityRepository;
    }

    public List<Industryactivity> getItems() {
        return industryactivityRepository.findAll();
    }

}