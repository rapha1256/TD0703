package colval.td.TD0703.controller;

import colval.td.TD0703.entity.Auteur;
import colval.td.TD0703.entity.Livre;
import colval.td.TD0703.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/getLivres")
    public List<Livre> getLivres() {
        System.out.println("Fecthing all livres...");
        return livreRepo.findAll();
    }

    @PostMapping("/saveLivre")
    public ResponseEntity<String> saveLivre(@RequestHeader("invocationFrom") String invocationFrom,
                                             @RequestBody Livre livre) {
        logger.info(String.format("Header invocationFrom = %s", invocationFrom));
        livreRepo.save(livre);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Auteur created:" + livre);
    }

    @PutMapping("/updateLivre/{id}")
    public ResponseEntity<String> updateLivre(@RequestHeader("invocationFrom") String invocationFrom,
                                               @PathVariable Long id,
                                               @RequestBody Livre updatedLivre) {
        logger.info(String.format("Header invocationFrom = %s", invocationFrom));
        Livre existingLivre = livreRepo.findLivreById(id);
        if (existingLivre == null) {
            return ResponseEntity.notFound().build();
        }
        existingLivre.setTitre(updatedLivre.getTitre());
        existingLivre.setAuteur(updatedLivre.getAuteur());
        existingLivre.setGenre(updatedLivre.getGenre());
        existingLivre.setEdition(updatedLivre.getEdition());
        existingLivre.setDisponibilite(updatedLivre.getDisponibilite());
        livreRepo.save(existingLivre);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Auteur updated: " + updatedLivre);
    }


    @DeleteMapping("/deleteLivre")
    public ResponseEntity<String> deleteLivre(@RequestParam(name = "id") Long id) {
        livreRepo.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Livre with this id deleted from db:" + id);
    }

    @PatchMapping("/closeLivre")
    public ResponseEntity<String> closeAuteur(@RequestHeader("invocationFrom") String invocationFrom,
                                              @RequestBody Livre livreReq) {
        logger.info(String.format("Header invocationFrom = %s", invocationFrom));
        if (livreReq != null) {
            livreRepo.save(livreReq);
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
