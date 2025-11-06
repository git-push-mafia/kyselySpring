package gitpushmafia.projekti.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import gitpushmafia.projekti.domain.Kysely;
import gitpushmafia.projekti.domain.KyselyRepository;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class KyselyRestController {

    @Autowired
    private KyselyRepository krepository;

    @GetMapping("/kyselyt")
    public @ResponseBody List<Kysely> getKyselytRest() {

        return (List<Kysely>) krepository.findAll();
    }

    @GetMapping("/kyselyt/{kyselyId}")
    public @ResponseBody Optional<Kysely> getKysely(Long kyselyId) {
        return krepository.findById(kyselyId);
    }

}
