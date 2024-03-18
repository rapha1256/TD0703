package colval.td.TD0703.repository;

import colval.td.TD0703.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findUtilisateurById(Long id);

    void deleteUtilisateurById(Long id);
}
