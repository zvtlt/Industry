package eve.wajifeng.industry.data.ramactivities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RamactivitiesService {

    public final RamactivitiesRepository ramactivitiesRepository;

    @Autowired
    public RamactivitiesService(RamactivitiesRepository ramactivitiesRepository) {
        this.ramactivitiesRepository = ramactivitiesRepository;
    }

    public List<Ramactivities> getItems() {
        return ramactivitiesRepository.findAll();
    }


}

