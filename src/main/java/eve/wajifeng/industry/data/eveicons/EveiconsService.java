package eve.wajifeng.industry.data.eveicons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EveiconsService {

    public final EveiconsRepository eveiconsRepository;

    @Autowired
    public EveiconsService(EveiconsRepository eveiconsRepository) {
        this.eveiconsRepository = eveiconsRepository;
    }

    public List<Eveicons> getItems() {
        return eveiconsRepository.findAll();
    }

}

