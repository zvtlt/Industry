package eve.wajifeng.industry.bpinfos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BpinfosService {

    public final BpinfosRepository bpinfosRepository;

    @Autowired
    public BpinfosService(BpinfosRepository bpinfosRepository) {
        this.bpinfosRepository = bpinfosRepository;
    }

    public List<Bpinfos> getInfo(@Param("x")int i) {
        return bpinfosRepository.getInfo(i);
    }

}