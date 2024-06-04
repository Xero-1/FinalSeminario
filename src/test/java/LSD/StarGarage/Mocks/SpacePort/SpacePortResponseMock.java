package LSD.StarGarage.Mocks.SpacePort;

import LSD.StarGarage.Dtos.Responses.SpacePortResponse;
import LSD.StarGarage.Dtos.Responses.StarshipResponse;
import LSD.StarGarage.Mocks.Starship.StarshipResponseMock;

import java.util.ArrayList;
import java.util.List;

public class SpacePortResponseMock
{
    public static SpacePortResponse mockResponse()
    {
        List<StarshipResponse> list=new ArrayList<>();
        list.add(StarshipResponseMock.mockResponse());
        SpacePortResponse response= SpacePortResponse.builder()
                .id(1L)
                .name("Jabba Lair")
                .location("Tatuin")
                .starshipsResponses(list)
                .build();
        return response;
    }
}
