package LSD.StarGarage.Mocks.Individual;

import LSD.StarGarage.Dtos.Requests.IndividualRequest;

public class IndividualRequestMock
{
    public static IndividualRequest mockRequest()
    {
        IndividualRequest request=new IndividualRequest();
        request.setName("Han");
        request.setLastName("Solo");
        request.setSpecies("Human");
        return request;
    }
}
