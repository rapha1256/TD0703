package colval.td.TD0703.controller;

import colval.td.TD0703.entity.Auteur;
import colval.td.TD0703.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auteurs")
public class AuteurController {
    private final AuteurRepository auteurRepo;

    @Autowired
    public AuteurController(AuteurRepository auteurRepo) {
        this.auteurRepo = auteurRepo;
    }

    @GetMapping("/getAuteurById")
    public List<Auteur> getAuteurById(@RequestParam(name = "id") Long id) {
        System.out.println("Request received");
        List<Auteur> result = auteurRepo.findAll();
        System.out.println("Response : " + result);
        return result;
    }

    @PostMapping


    @PutMapping


    @DeleteMapping


    @PatchMapping


}
