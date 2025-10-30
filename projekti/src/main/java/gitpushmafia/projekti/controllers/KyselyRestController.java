package gitpushmafia.projekti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import gitpushmafia.projekti.domain.Kysely;
import gitpushmafia.projekti.domain.KyselyRepository;

@Controller
public class KyselyRestController {

    @Autowired
    private KyselyRepository krepository;

    @GetMapping("/kyselyrest")
    public @ResponseBody List<Kysely> getKyselytRest() {

        return (List<Kysely>) krepository.findAll();
    }

}
