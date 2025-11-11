package gitpushmafia.projekti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import gitpushmafia.projekti.domain.Vastaus;
import gitpushmafia.projekti.domain.VastausRepository;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class VastausRestController {

    @Autowired
    private VastausRepository vrepository;

    @GetMapping("/vastaukset")
    public @ResponseBody List<Vastaus> getVastauksetRest() {
        return (List<Vastaus>) vrepository.findAll();
    }

    @PostMapping("/vastaukset")
    public @ResponseBody Vastaus tallennaVastaus(@RequestBody Vastaus vastaus) {
        return vrepository.save(vastaus);
    }

}
