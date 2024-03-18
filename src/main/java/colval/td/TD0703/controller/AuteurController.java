package colval.td.TD0703.controller;

import colval.td.TD0703.entity.*;
import colval.td.TD0703.repository.AuteurRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("auteurs")
public class AuteurController {
    private final AuteurRepository auteurRepo;
    Logger logger = Logger.getLogger("loggerAuteur");

    @Autowired
    public AuteurController(AuteurRepository auteurRepo) {
        this.auteurRepo = auteurRepo;
    }

    @GetMapping("/getAuteurs")
    public List<Auteur> getAllAuteurs() {
        return auteurRepo.findAll();
    }
    @GetMapping("/getAuteurById")
    public Auteur getAuteurById(@RequestParam(name = "id") Long id) {
        System.out.println("Request received");
        Auteur result = auteurRepo.findAuteurById(id);
        System.out.println("Response : " + result);
        return result;
    }

    @PostMapping("/saveAuteur")
    public ResponseEntity<String> saveAuteur(@RequestHeader("invocationFrom") String invocationFrom,
                                               @RequestBody Auteur auteur) {
        logger.info(String.format("Header invocationFrom = %s", invocationFrom));
        auteurRepo.save(auteur);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Auteur created:" + auteur.toString());
    }

    @PutMapping("/updateAuteur")
    public ResponseEntity<String> updateAuteur(@RequestHeader("invocationFrom") String invocationFrom,
                                                 @PathVariable Long id,
                                                 @RequestBody Auteur updatedAuteur) {
        logger.info(String.format("Header invocationFrom = %s", invocationFrom));
        Auteur existingAuteur = auteurRepo.findAuteurById(id);
        if (existingAuteur == null) {
            return ResponseEntity.notFound().build();
        }
        existingAuteur.setNom(updatedAuteur.getNom());
        existingAuteur.setPrenom(updatedAuteur.getPrenom());
        existingAuteur.setBiographie(updatedAuteur.getBiographie());
        auteurRepo.save(existingAuteur);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Auteur updated: " + updatedAuteur);
    }


    @DeleteMapping("/deleteAuteur")
    public ResponseEntity<String> deleteAuteur(@RequestParam(name = "id") Long id) {
        auteurRepo.deleteAuteurById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Auteur deleted from db:" + auteurRepo.findAuteurById(id).toString());
    }

    @PatchMapping("/closeAuteur")
    public ResponseEntity<String> closeAuteur(@RequestBody Auteur auteurReq) {
        Response response = new Response();
        Auteur auteur = auteurRepo.findAuteurById(auteurReq.getId());
        if (auteur != null) {
            auteurRepo.save(auteur);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("");
    }




}

