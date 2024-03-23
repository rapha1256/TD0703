package colval.td.TD0703.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "Commentaires")
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentaire_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "livre_id", referencedColumnName = "livre_id")
    private Livre livre;

    @Column(name = "contenu")
    private String contenu;
    @Column(name = "date_commentaire")
    private Date dateCommentaire;

    @Column(name = "note")
    private int note;

}
