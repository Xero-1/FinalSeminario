package LSD.StarGarage.Mocks.Starship;

import LSD.StarGarage.Mocks.Individual.IndividualMock;
import LSD.StarGarage.Models.Starship;

public class StarshipMock
{
    public static Starship mockEntity()
    {
        Starship starship=Starship.builder()
                .name("Millennium Falcon")
                .model("YT-1300fp light freighter")
                .cargoCapacity(200.f)
                .captain(IndividualMock.mockEntity())
                .build();
        return starship;
    }
}
