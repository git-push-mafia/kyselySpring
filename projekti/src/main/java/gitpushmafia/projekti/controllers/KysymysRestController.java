package gitpushmafia.projekti.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import gitpushmafia.projekti.domain.Kysymys;
import gitpushmafia.projekti.domain.KysymysRepository;

public class KysymysRestController {

    @Autowired
    private KysymysRepository krepository;

    @GetMapping("/kysymykset")
    public @ResponseBody List<Kysymys> getKysymyksetRest() {

        return (List<Kysymys>) krepository.findAll();
    }

    @GetMapping("/kysymykset/{kysymysId}")
    public @ResponseBody Optional<Kysymys> getKysymysByIdRest(@PathVariable("kysymysId") Long kysymysId) {
        return krepository.findById(kysymysId);
    }
}
