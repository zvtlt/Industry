package eve.wajifeng.industry.data.invtypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvtypesRepository  extends JpaRepository<Invtypes, Long> {

    @Query("select e from Invtypes e where e.typeID = :x")
    List<Invtypes> getInfo(@Param("x")int i);

    @Query("select e from Invtypes e where e.typeName = :x")
    List<Invtypes> getInfo(@Param("x")String s);

}
