package eve.wajifeng.industry.data.skins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SkinsRepository extends JpaRepository<Skins, Long> {


}