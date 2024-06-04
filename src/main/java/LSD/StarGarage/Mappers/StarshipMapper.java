package LSD.StarGarage.Mappers;

import LSD.StarGarage.Dtos.Requests.StarshipRequest;
import LSD.StarGarage.Dtos.Responses.StarshipsResponse;
import LSD.StarGarage.Models.Individual;
import LSD.StarGarage.Models.Starship;
import LSD.StarGarage.Services.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarshipMapper
{
    @Autowired
    private IndividualService individualService;

    public Starship starshipRequestToStarship(StarshipRequest request) {
        Individual captain=Individual.builder()
                .name(request.getCaptainRequest().getName())
                .lastName(request.getCaptainRequest().getLastName())
                .species(request.getCaptainRequest().getSpecies())
                .build();
        captain=individualService.setNewOrExistentIndividual(request.getCaptainRequest(),captain);
        Starship starship = Starship.builder()
                .name(request.getName())
                .model(request.getModel())
                .cargoCapacity(request.getCargoCapacity())
                .captain(captain)
                .build();
        return starship;
    }
    public StarshipsResponse starshipsListToResponse(List<Starship> list) {

        List<Starship> responseList = new ArrayList<>();
        for (Starship starship : list)
        {
            Individual captain=Individual.builder()
                    .id(starship.getCaptain().getId())
                    .name(starship.getCaptain().getName())
                    .lastName(starship.getCaptain().getLastName())
                    .species(starship.getCaptain().getSpecies())
                    .build();
            Starship newStarship=Starship.builder()
                    .id(starship.getId())
                    .name(starship.getName())
                    .model(starship.getModel())
                    .cargoCapacity(starship.getCargoCapacity())
                    .captain(captain)
                    .build();
            responseList.add(newStarship);
        }
        StarshipsResponse starshipsResponse=StarshipsResponse.builder()
                .starships(responseList)
                .build();
        return starshipsResponse;
    }
}
