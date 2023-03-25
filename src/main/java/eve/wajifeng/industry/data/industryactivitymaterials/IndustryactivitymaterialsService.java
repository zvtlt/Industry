package eve.wajifeng.industry.data.industryactivitymaterials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryactivitymaterialsService {

    public final IndustryactivitymaterialsRepository industryactivitymaterialsRepository;

    @Autowired
    public IndustryactivitymaterialsService(IndustryactivitymaterialsRepository industryactivitymaterialsRepository) {
        this.industryactivitymaterialsRepository = industryactivitymaterialsRepository;
    }

    public List<Industryactivitymaterials> getMaterials(@Param("x")int s) {
        return industryactivitymaterialsRepository.getMaterials(s);
    }

}