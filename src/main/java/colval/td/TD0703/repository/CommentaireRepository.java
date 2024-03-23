package colval.td.TD0703.repository;

import colval.td.TD0703.entity.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    Commentaire findCommentaireById(Long id);

    List<Commentaire> findCommentairesByLivre_Id(Long id);
}
