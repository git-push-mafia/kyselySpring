package gitpushmafia.projekti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gitpushmafia.projekti.domain.Kysely;
import gitpushmafia.projekti.domain.KyselyRepository;

@Controller
public class KyselyController {

    @Autowired
    private KyselyRepository kyselyRepository;

    @GetMapping("/")
    public String getKysely(Model model) {
        model.addAttribute("kyselyt", kyselyRepository.findAll());
        return "etusivu";
    }

    @GetMapping("/addkysely")
    public String addKysely(Model model) {
        Kysely kysely = new Kysely();
        model.addAttribute("kysely", kysely);
        return "addkysely";
    }

    @GetMapping("/kysely/{kyselyId}")
    public String editKysely(@PathVariable Long kyselyId, Model model) {

        Kysely kysely = kyselyRepository.findById(kyselyId).orElse(null);

        model.addAttribute("kysely", kysely);

        return "editkysely";
    }

    @PostMapping("/savekysely")
    public String saveKysely(@ModelAttribute Kysely kysely) {
        kyselyRepository.save(kysely);
        System.out.println("Tallennettu kysely: " + kysely);

        return "redirect:/etusivu";
    }

}