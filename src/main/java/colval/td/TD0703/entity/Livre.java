package colval.td.TD0703.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Livres")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livre_id")
    private Long id;

    @Column(name = "titre")
    private String titre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auteur_id", referencedColumnName = "auteur_id")
    private Auteur auteur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private Genre genre;

    @Column(name = "edition")
    private String edition;

    @Column(name = "disponibilite")
    private Boolean disponibilite;

}
