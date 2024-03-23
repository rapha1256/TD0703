package colval.td.TD0703.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "Emprunts")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emprunt_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exemplaire_id", referencedColumnName = "exemplaire_id")
    private Exemplaire exemplaire;

    @Column(name = "date_emprunt")
    private Date dateEmprunt;

    @Column(name = "date_retour_prevue")
    private Date dateRetour;

    @Column(name = "statut")
    private String statut;

}
