package colval.td.TD0703.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "Utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "utilisateur_id")
    private Long id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;

    @Column(name = "adresse_email")
    private String adresseEmail;

    @Column(name = "mot_de_passe_hashed")
    private String motDePasse;
    @Column(name = "role")
    private String role;

}
