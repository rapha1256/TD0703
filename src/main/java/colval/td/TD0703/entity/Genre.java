package colval.td.TD0703.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long id;

    @Column(name = "nom")
    private String nom;
}
