package eve.wajifeng.industry.data.invnames;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvnamesRepository extends JpaRepository<Invnames, Long> {


}
