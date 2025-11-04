package gitpushmafia.projekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KysymysRepository extends CrudRepository<Kysymys, Long> {

    List<Kysymys> findAll();

    List<Kysymys> findByKysymysId(Long kysymysId);

    List<Kysymys> findByKysymys(String kysymys);
}
