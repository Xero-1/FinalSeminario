package LSD.StarGarage.Services;

import LSD.StarGarage.Dtos.Requests.StarshipRequest;
import LSD.StarGarage.Dtos.Responses.StarshipsResponse;
import LSD.StarGarage.Mappers.StarshipMapper;
import LSD.StarGarage.Models.Starship;
import LSD.StarGarage.Repositories.StarshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarshipService
{
    @Autowired
    private StarshipRepository repository;
    @Autowired
    private StarshipMapper mapper;

    public ResponseEntity addStarship(StarshipRequest request)
    {
        Starship starship=mapper.starshipRequestToStarship(request);
        repository.save(starship);
        return ResponseEntity.ok("New Starship saved: "+starship.getName());
    }
    public void deleteStarship(Long id)
    {
        repository.deleteById(id);
    }
    public StarshipsResponse listStarships()
    {
        List<Starship> list=repository.findAll();
        return mapper.starshipsListToResponse(list);
    }
    public ResponseEntity updateStarship(StarshipRequest request,Long id)
    {
        try
        {
            Starship starship = repository.getById(id);
            starship = mapper.starshipRequestToStarship(request);
            repository.save(starship);
            return ResponseEntity.ok("Starship updated");
        }catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Not founded Starship with ID= "+id);
        }
    }

    public List<Starship> findByName(String name)
    {
        return repository.findByName(name);
    }
    public Starship setNewOrExistentStarship(StarshipRequest request,Starship starship)
    {
        if(repository.findByName(request.getName()).isEmpty())
            repository.save(starship);
        else
            starship=repository.findByName(request.getName()).get(0);
        return starship;
    }
}
