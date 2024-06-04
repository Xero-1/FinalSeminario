package LSD.StarGarage.Mocks.SpacePort;

import LSD.StarGarage.Mocks.Starship.StarshipMock;
import LSD.StarGarage.Models.SpacePort;
import LSD.StarGarage.Models.Starship;

import java.util.ArrayList;
import java.util.List;

public class SpacePortMock
{
    public static SpacePort mockEntity()
    {
        List<Starship> list=new ArrayList<>();
        list.add(StarshipMock.mockEntity());
        SpacePort spacePort= SpacePort.builder()
                .id(1L)
                .name("Jabba Lair")
                .location("Tatuin")
                .starships(list)
                .build();
        return spacePort;
    }
}
