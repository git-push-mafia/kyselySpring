package gitpushmafia.projekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KyselyRepository extends CrudRepository<Kysely, Long> {

    List<Kysely> findAll();

    List<Kysely> findByKyselyId(Long kyselyId);

    List<Kysely> findByNimi(String nimi);
}