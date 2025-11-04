package gitpushmafia.projekti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import gitpushmafia.projekti.domain.Kysymys;
import gitpushmafia.projekti.domain.KysymysRepository;

public class KysymysRestController {

    @Autowired
    private KysymysRepository krepository;

    @GetMapping("/kysymysrest")
    public @ResponseBody List<Kysymys> getKysymyksetRest() {

        return (List<Kysymys>) krepository.findAll();
    }
}
