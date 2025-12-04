package gitpushmafia.projekti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gitpushmafia.projekti.domain.Kysely;
import gitpushmafia.projekti.domain.KyselyRepository;
import gitpushmafia.projekti.domain.Kysymys;
import gitpushmafia.projekti.domain.KysymysRepository;
import gitpushmafia.projekti.domain.Vaihtoehto;

@Controller
public class KysymysController {

    @Autowired
    private KyselyRepository kyselyRepository;

    @Autowired
    private KysymysRepository kysmyrepo;

    @GetMapping("/addkysymys")
    public String addNewKysymys(Model model) {

        model.addAttribute("kysymys", new Kysymys());

        return "addkysymys";
    }

    @GetMapping("/kysely/{kyselyId}/addkysymys")
    public String showAddKysymysForm(@PathVariable Long kyselyId, Model model) {

        Kysely kysely = kyselyRepository.findById(kyselyId).orElseThrow();

        model.addAttribute("kysely", kysely);
        model.addAttribute("kysymys", new Kysymys());

        return "addkysymys";
    }

    @PostMapping("/kysely/{kyselyId}/addkysymys")
    public String saveKysymys(@PathVariable Long kyselyId, @PathVariable Long kysymysId, @RequestParam String kysymys,
            @RequestParam String vastaustyyppi) {
        Kysely kysely = kyselyRepository.findById(kyselyId).orElseThrow();

        Kysymys q = new Kysymys();
        q.setKysymys(kysymys);
        q.setVastaustyyppi(vastaustyyppi);
        q.setKysely(kysely);

        kysely.getKysymykset().add(q);
        kyselyRepository.save(kysely);

        if (vastaustyyppi.equals("monivalinta")) {
            return "redirect:/kysely/" + kyselyId + "/addkysymys" + q.getKysymysId() + "/addvaihtoehto";
        } else {
            return "redirect:/kysely/" + kyselyId;
        }

    }

    @GetMapping("kysely/{kyselyId}/addkysymys/{kysymysId}/addvaihtoehto")
    public String addVaihtoehto(@PathVariable Long kysymysId, Model model) {

        Kysymys kysymys = kysmyrepo.findById(kysymysId).orElseThrow();

        model.addAttribute("kysymys", kysymys);
        model.addAttribute("vaihtoehto", new Vaihtoehto());

        return "addvaihtoehto";
    }

    @PostMapping("kysely/{kyselyId}/addkysymys/{kysymysId}/addvaihtoehto")
    public String saveVaihtoehto(@PathVariable Long kysymysId, @RequestParam String vaihtoehto) {

        Kysymys kysymys = kysmyrepo.findById(kysymysId).orElseThrow();

        Vaihtoehto ve = new Vaihtoehto();
        ve.setVaihtoehto(vaihtoehto);
        ve.setKysymys(kysymys);

        kysymys.getVaihtoehdot().add(ve);
        kysmyrepo.save(kysymys);

        return "redirect:/addkysymys/" + kysymysId;
    }
}
