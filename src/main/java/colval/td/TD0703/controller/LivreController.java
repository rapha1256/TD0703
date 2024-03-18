package colval.td.TD0703.controller;

import colval.td.TD0703.entity.Auteur;
import colval.td.TD0703.entity.Livre;
import colval.td.TD0703.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/livres")
public class LivreController {

    private final LivreRepository livreRepo;
    Logger logger = Logger.getLogger("loggerLivre");

    @Autowired
    public LivreController(LivreRepository livreRepo) {
        this.livreRepo = livreRepo;
    }

    @GetMapping("/getLivreById")
    public Livre getLivreById(@RequestParam(name = "id") Long id) {
        System.out.println("Request received");
        Livre result = livreRepo.findLivreById(id);
        System.out.println("Response : " + result);
        return result;
    }

//    @PostMapping
//
//
//    @PutMapping
//
//
//    @DeleteMapping
//
//
//    @PatchMapping


}
