package LSD.StarGarage.Repositories;

import LSD.StarGarage.Models.Starship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarshipRepository extends JpaRepository<Starship,Long>
{

}
