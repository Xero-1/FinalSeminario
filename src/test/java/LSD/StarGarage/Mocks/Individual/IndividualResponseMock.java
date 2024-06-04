package LSD.StarGarage.Mocks.Individual;

import LSD.StarGarage.Dtos.Responses.IndividualResponse;

public class IndividualResponseMock
{
    public static IndividualResponse mockResponse()
    {
        IndividualResponse response=IndividualResponse.builder()
                .name("Han")
                .lastName("Solo")
                .species("Human")
                .build();
        return response;
    }
}
