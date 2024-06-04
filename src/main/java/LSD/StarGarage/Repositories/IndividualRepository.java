package LSD.StarGarage.Repositories;

import LSD.StarGarage.Models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndividualRepository extends JpaRepository<Individual,Long>
{
    List<Individual> findByName(String name);
}
