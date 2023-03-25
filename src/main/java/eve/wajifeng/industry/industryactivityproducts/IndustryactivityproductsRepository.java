package eve.wajifeng.industry.industryactivityproducts;

import eve.wajifeng.industry.bpinfos.Bpinfos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IndustryactivityproductsRepository extends JpaRepository<Industryactivityproducts, Long> {

    @Query("select e from Industryactivityproducts e where e.typeID = :x")
    List<Industryactivityproducts> getInfo(@Param("x")int i);

}