package LSD.StarGarage.Mappers;

import LSD.StarGarage.Dtos.Requests.SpacePortRequest;
import LSD.StarGarage.Dtos.Responses.SpacePortsResponse;
import LSD.StarGarage.Models.SpacePort;
import LSD.StarGarage.Models.Starship;
import LSD.StarGarage.Services.StarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpacePortMapper
{
    @Autowired
    private StarshipService starshipService;

    public SpacePort spacePortRequestToSpacePort(SpacePortRequest request)
    {
        List<Starship> starships=new ArrayList<>();
        SpacePort spacePort= SpacePort.builder()
                .name(request.getName())
                .location(request.getLocation())
                .starships(starships)
                .build();
        return spacePort;
    }
    public SpacePortsResponse spacePortsListToResponse(List<SpacePort> list)
    {
        List<SpacePort> responseList=new ArrayList<>();
        for(SpacePort spacePort : list)
        {
            SpacePort newSpacePort=SpacePort.builder()
                    .name(spacePort.getName())
                    .location(spacePort.getLocation())
                    .build();
            responseList.add(newSpacePort);
        }
        SpacePortsResponse spacePortsResponse=SpacePortsResponse.builder()
                .spacePorts(responseList)
                .build();
        return spacePortsResponse;
    }
}
