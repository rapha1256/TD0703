package colval.td.TD0703.controller;

import colval.td.TD0703.entity.Livre;
import colval.td.TD0703.entity.Utilisateur;
import colval.td.TD0703.repository.UtilisateurRepository;
import jdk.jshell.execution.Util;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    private final UtilisateurRepository utilisateurRepo;

    private Logger logger = Logger.getLogger("loggerUtilisateur");

    @Autowired
    public UtilisateurController(UtilisateurRepository utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
    }

    @GetMapping("/getUtilisateursById")
    public Utilisateur getUtilisateurById(@RequestParam(name = "id") Long id) {
        System.out.println("Request received");
        Utilisateur result = utilisateurRepo.findUtilisateurById(id);
        System.out.println("Response : " + result);
        return result;
    }

//    @PostMapping
//
//    @PutMapping
//
//    @DeleteMapping
//
//    @PatchMapping
}
