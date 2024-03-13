package colval.td.TD0703.repository;

import colval.td.TD0703.entity.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
