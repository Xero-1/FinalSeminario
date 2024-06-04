package LSD.StarGarage.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Table(name="space_port")
@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SpacePort
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String name;
    private String location;
    @OneToMany
    private List<Starship> starships;

}
