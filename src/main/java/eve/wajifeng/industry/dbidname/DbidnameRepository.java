package eve.wajifeng.industry.dbidname;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DbidnameRepository extends JpaRepository<Dbidname, Long> {

    @Query("select e from Dbidname e where e.typeName like :x")
    List<Dbidname> getItemsNames(@Param("x")String s);

    @Query("select e from Dbidname e where e.typeName = :x")
    List<Dbidname> getItem(@Param("x")String s);
}