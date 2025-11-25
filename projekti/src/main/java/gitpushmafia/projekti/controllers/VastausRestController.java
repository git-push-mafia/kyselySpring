package gitpushmafia.projekti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import gitpushmafia.projekti.domain.Kysymys;
import gitpushmafia.projekti.domain.KysymysRepository;
import gitpushmafia.projekti.domain.Vastaus;
import gitpushmafia.projekti.domain.VastausRepository;
import gitpushmafia.projekti.dto.KyselyVastauksetDto;
import gitpushmafia.projekti.dto.VastausDto;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class VastausRestController {

    @Autowired
    private VastausRepository vrepository;

    @Autowired
    private KysymysRepository kysymysRepository;

    @GetMapping("/vastaukset")
    public @ResponseBody List<Vastaus> getVastauksetRest() {
        return (List<Vastaus>) vrepository.findAll();
    }

    @PostMapping("/vastaukset")
    public @ResponseBody void tallennaVastaukset(@RequestBody KyselyVastauksetDto dto) {
        for (VastausDto vdto : dto.getVastaukset()) {
            Vastaus v = new Vastaus();
            v.setVastaus(vdto.getVastaus());

            Kysymys k = kysymysRepository.findById(vdto.getKysymysId())
                    .orElseThrow(() -> new RuntimeException("Kysymystä ei löydy id:llä " + vdto.getKysymysId()));

            v.setKysymys(k);

            vrepository.save(v);
        }
    }

    @GetMapping("/kyselyt/{kyselyId}/vastaukset")
    public @ResponseBody List<Vastaus> getVastauksetByKysely(@PathVariable Long kyselyId) {
        return vrepository.findByKysymys_Kysely_KyselyId(kyselyId);
    }

}
