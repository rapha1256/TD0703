package colval.td.TD0703.controller;

import colval.td.TD0703.entity.Auteur;
import colval.td.TD0703.entity.Livre;
import colval.td.TD0703.entity.Utilisateur;
import colval.td.TD0703.repository.UtilisateurRepository;
import jdk.jshell.execution.Util;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/getUtilisateurs")
    public List<Utilisateur> getUtilisateurs() {
        System.out.println("Fetching all utilisateurs...");
        return utilisateurRepo.findAll();
    }
    @PostMapping("/saveUtilisateur")
    public ResponseEntity<String> saveUtilisateur(@RequestHeader("invocationFrom") String invocationFrom,
                                                  @RequestBody Utilisateur utilisateur) {
        logger.info(String.format("Header invocationFrom = %s", invocationFrom));
        utilisateurRepo.save(utilisateur);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Utilisateur created:" + utilisateur);
    }

    @PutMapping("/updateUtilisateur/{id}")
    public ResponseEntity<String> updateLivre(@RequestHeader("invocationFrom") String invocationFrom,
                                              @PathVariable Long id,
                                              @RequestBody Utilisateur updatedUtilisateur) {
        logger.info(String.format("Header invocationFrom = %s", invocationFrom));
        Utilisateur existingUtilisateur = utilisateurRepo.findUtilisateurById(id);
        if (existingUtilisateur == null) {
            return ResponseEntity.notFound().build();
        }
        existingUtilisateur.setNom(updatedUtilisateur.getNom());
        existingUtilisateur.setPrenom(updatedUtilisateur.getPrenom());
        existingUtilisateur.setAdresseEmail(updatedUtilisateur.getAdresseEmail());
        existingUtilisateur.setMotDePasse(updatedUtilisateur.getMotDePasse());
        existingUtilisateur.setRole(updatedUtilisateur.getRole());
        utilisateurRepo.save(existingUtilisateur);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Auteur updated: " + updatedUtilisateur);
    }
    @DeleteMapping("/deleteUtilisateur")
    public ResponseEntity<String> deleteUtilisateur(@RequestParam(name = "id") Long id) {
        System.out.println("Deleting user with id: " + id);
        utilisateurRepo.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Utilisateur with this id deleted from db:" + id);
    }
    @PatchMapping("/closeUtilisateur")
    public ResponseEntity<String> closeUtilisateur(@RequestHeader("invocationFrom") String invocationFrom,
                                              @RequestBody Utilisateur utilisateurReq) {
        logger.info(String.format("Header invocationFrom = %s", invocationFrom));
        if (utilisateurReq != null) {
            utilisateurRepo.save(utilisateurReq);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Request was unsuccessful");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Request was successful");
    }


}
