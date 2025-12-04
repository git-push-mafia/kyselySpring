package gitpushmafia.projekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VaihtoehtoRepository extends CrudRepository<Vaihtoehto, Long> {
    List<Vaihtoehto> findAll();

    List<Vaihtoehto> findByVaihtoehtoId(Long vaihtoehtoId);
}