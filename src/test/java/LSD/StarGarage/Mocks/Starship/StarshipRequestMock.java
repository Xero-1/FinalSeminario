package LSD.StarGarage.Mocks.Starship;

import LSD.StarGarage.Dtos.Requests.StarshipRequest;
import LSD.StarGarage.Mocks.Individual.IndividualRequestMock;

public class StarshipRequestMock
{
    public static StarshipRequest mockRequest()
    {
        StarshipRequest request=new StarshipRequest();
        request.setName("Millennium Falcon");
        request.setModel("YT-1300fp light freighter");
        request.setCargoCapacity(200.f);
        request.setCaptainRequest(IndividualRequestMock.mockRequest());
        return request;
    }
}
