package colval.td.TD0703.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Auteurs")
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auteur_id")
    private Long id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;

    @Column(name = "biographie")
    private String biographie;


}
