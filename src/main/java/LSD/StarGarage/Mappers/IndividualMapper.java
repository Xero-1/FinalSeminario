package LSD.StarGarage.Mappers;

import LSD.StarGarage.Dtos.Requests.IndividualRequest;
import LSD.StarGarage.Dtos.Responses.IndividualsResponse;
import LSD.StarGarage.Models.Individual;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndividualMapper
{
    public Individual individualRequestToIndividual(IndividualRequest request)
    {
        Individual individual = Individual.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .species(request.getSpecies())
                .build();
        return individual;
    }
    public IndividualsResponse individualsListToResponse(List<Individual> list)
    {
        List<Individual> responseList=new ArrayList<>();
        for(Individual individual : list)
        {
            Individual newIndividual=Individual.builder()
                    .name(individual.getName())
                    .lastName(individual.getLastName())
                    .species(individual.getSpecies())
                    .build();
            responseList.add(newIndividual);
        }
        IndividualsResponse individualsResponse = IndividualsResponse.builder()
                .individuals(responseList)
                .build();
        return individualsResponse;
    }
}
