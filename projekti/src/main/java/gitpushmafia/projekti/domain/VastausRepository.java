package gitpushmafia.projekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VastausRepository extends CrudRepository<Vastaus, Long> {

    List<Vastaus> findAll();

    List<Vastaus> findByVastausId(Long vastausId);

    List<Vastaus> findByVastaus(String vastaus);

    List<Vastaus> findByKysymys_Kysely_KyselyId(Long kyselyId);

}
