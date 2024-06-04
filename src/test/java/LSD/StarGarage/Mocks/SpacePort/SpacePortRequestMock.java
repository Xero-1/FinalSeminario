package LSD.StarGarage.Mocks.SpacePort;

import LSD.StarGarage.Dtos.Requests.SpacePortRequest;
import LSD.StarGarage.Dtos.Requests.StarshipRequest;
import LSD.StarGarage.Mocks.Starship.StarshipRequestMock;

import java.util.ArrayList;
import java.util.List;

public class SpacePortRequestMock
{
    public static SpacePortRequest mockRequest()
    {
        List<StarshipRequest> list=new ArrayList<>();
        list.add(StarshipRequestMock.mockRequest());
        SpacePortRequest request=new SpacePortRequest();
        request.setName("Jabba Lair");
        request.setLocation("Tatuin");
        request.setStarshipsRequests(list);
        return request;
    }
}
