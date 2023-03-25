package eve.wajifeng.industry.data.industryactivitymaterials;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IndustryactivitymaterialsRepository extends JpaRepository<Industryactivitymaterials, Long> {

    @Query("select e from Industryactivitymaterials e where e.activityID = 1 and e.typeID = :x")
    List<Industryactivitymaterials> getMaterials(@Param("x")int s);

}