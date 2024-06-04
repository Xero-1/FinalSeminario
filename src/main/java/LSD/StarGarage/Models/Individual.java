package LSD.StarGarage.Models;

import javax.persistence.*;
import lombok.*;

@Table(name="individual")
@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Individual
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String name;
    private String lastName;
    private String species;
}
