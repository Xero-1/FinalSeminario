package LSD.StarGarage.Models;

import lombok.*;
import javax.persistence.*;

@Table(name="starship")
@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Starship
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String name;
    private String model;
    private float cargoCapacity;
    @OneToOne
    private Individual captain;
}
