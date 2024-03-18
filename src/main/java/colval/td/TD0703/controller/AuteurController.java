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

    @GetMapping("/getAuteurById")
    public Auteur getAuteurById(@RequestParam(name = "id") Long id) {
        System.out.println("Request received");
        Auteur result = auteurRepo.findAuteurById(id);
        System.out.println("Response : " + result);
        return result;
    }

    @PostMapping("/saveAuteur")
    public ResponseEntity<Response> saveAuteur(@RequestHeader("invocationFrom") String invocationFrom,
                                               @RequestBody Auteur auteur) {
        logger.info(String.format("Header invocationFrom = %s", invocationFrom));
        auteurRepo.save(auteur);
        Response response = new Response();
        response.setStatus(200);
        response.setMessage("Auteur successfully created");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("isAuteurSaved", "true")
                .body(response);
    }

    @PutMapping("/updateAuteur")
    public ResponseEntity<Response> updateAuteur(@RequestHeader("invocationFrom") String invocationFrom,
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
        Response response = new Response();
        response.setStatus(200);
        response.setMessage("Auteur updated successfully");
        return ResponseEntity.status(HttpStatus.OK)
                .header("isAuteurUpdated", "true")
                .body(response);
    }


    @DeleteMapping("/deleteAuteur")
    public ResponseEntity<Response> deleteAuteur(RequestEntity<Auteur> requestEntity) {
        HttpHeaders headers = requestEntity.getHeaders();
        headers.forEach((key, value)-> {
            logger.info(String.format("Header = '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
        });
        Auteur auteur = requestEntity.getBody();
        auteurRepo.deleteAuteurById(auteur.getId());
        Response response = new Response();
        response.setStatus(200);
        response.setMessage("Auteur deleted successfully");
        return ResponseEntity
                .status(200)
                .body(response);
    }

    @PatchMapping("/closeAuteur")
    public ResponseEntity<Response> closeAuteur(@RequestBody Auteur auteurReq) {
        Response response = new Response();
        Auteur auteur = auteurRepo.findAuteurById(auteurReq.getId());
        if (auteur != null) {
            auteurRepo.save(auteur);
        } else {
            response.setStatus(400);
            response.setMessage("Invalid auteur id wad received");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
        response.setStatus(200);
        response.setMessage("Auteur successfully closed");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }




}

