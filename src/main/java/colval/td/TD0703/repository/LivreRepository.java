package colval.td.TD0703.repository;

import colval.td.TD0703.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
    Livre findLivreById(Long id);

    Livre findLivresByTitre(String titre);


}
