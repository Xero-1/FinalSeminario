package LSD.StarGarage.Repositories;

import LSD.StarGarage.Models.Starship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StarshipRepository extends JpaRepository<Starship,Long>
{
    public List<Starship> findByName(String name);
}
