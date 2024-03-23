package colval.td.TD0703.repository;

import colval.td.TD0703.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {

    Auteur findAuteurById(Long id);

    Auteur findAuteurByNomAndPrenom(String nom, String prenom);
}
