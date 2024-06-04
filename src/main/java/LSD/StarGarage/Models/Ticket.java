package LSD.StarGarage.Models;

import lombok.*;
import javax.persistence.*;

@Table(name="ticket")
@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String dateStart;
    private String dateEnd;
    @OneToOne
    private Starship starship;
}
