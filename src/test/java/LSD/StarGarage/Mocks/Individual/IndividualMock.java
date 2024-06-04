package LSD.StarGarage.Mocks.Individual;

import LSD.StarGarage.Models.Individual;

public class IndividualMock
{
    public static Individual mockEntity()
    {
        Individual individual=Individual.builder()
                .id(1L)
                .name("Han")
                .lastName("Solo")
                .species("Human")
                .build();
        return individual;
    }
}
