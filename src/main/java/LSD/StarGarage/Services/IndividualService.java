package LSD.StarGarage.Services;

import LSD.StarGarage.Dtos.Requests.IndividualRequest;
import LSD.StarGarage.Dtos.Responses.IndividualsResponse;
import LSD.StarGarage.Mappers.IndividualMapper;
import LSD.StarGarage.Models.Individual;
import LSD.StarGarage.Repositories.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualService
{
    @Autowired
    private IndividualRepository repository;
    @Autowired
    private IndividualMapper mapper;


    public ResponseEntity addIndividual(IndividualRequest request)
    {
        Individual individual=mapper.individualRequestToIndividual(request);
        repository.save(individual);
        return ResponseEntity.ok("New Individual saved: "+individual.getName());
    }
    public void deleteIndividual(Long id)
    {
        repository.deleteById(id);
    }
    public IndividualsResponse listIndividuals()
    {
        List<Individual> list=repository.findAll();
        return mapper.individualsListToResponse(list);
    }
    public ResponseEntity updateIndividual(IndividualRequest request, Long id)
    {
        try
        {
            Individual individual = repository.getById(id);
            individual = mapper.individualRequestToIndividual(request);
            repository.save(individual);
            return ResponseEntity.ok("Individual updated");
        }catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Not founded Individual with ID= "+id);
        }
    }
    public List<Individual> findByName(String name)
    {
        return repository.findByName(name);
    }
    public Individual setNewOrExistentIndividual(IndividualRequest request,Individual individual)
    {
        if(repository.findByName(request.getName()).isEmpty())
            repository.save(individual);
        else
            individual=repository.findByName(request.getName()).get(0);
        return individual;
    }
}
