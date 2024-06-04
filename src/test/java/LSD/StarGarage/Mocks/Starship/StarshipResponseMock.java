package LSD.StarGarage.Mocks.Starship;

import LSD.StarGarage.Dtos.Responses.StarshipResponse;
import LSD.StarGarage.Mocks.Individual.IndividualResponseMock;

public class StarshipResponseMock
{
    public static StarshipResponse mockResponse()
    {
        StarshipResponse response=StarshipResponse.builder()
                .name("Millennium Falcon")
                .model("YT-1300fp light freighter")
                .cargoCapacity(200.f)
                .captainResponse(IndividualResponseMock.mockResponse()).build();
        return response;
    }
}
