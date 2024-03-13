package colval.td.TD0703.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Exemplaires")
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exemplaire_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livre_id", referencedColumnName = "livre_id")
    private Livre livre;

    @Column(name = "statut")
    private String statut;
}
