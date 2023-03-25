package eve.wajifeng.industry.bpinfos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BpinfosRepository extends JpaRepository<Bpinfos, Long> {

    @Query("select e from Bpinfos e where e.typeID = :x")
    List<Bpinfos> getInfo(@Param("x")int s);
}