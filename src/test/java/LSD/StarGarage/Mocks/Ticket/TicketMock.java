package LSD.StarGarage.Mocks.Ticket;

import LSD.StarGarage.Mocks.Starship.StarshipMock;
import LSD.StarGarage.Models.Ticket;

public class TicketMock{
    public static Ticket mockEntity()
    {
        Ticket ticket=Ticket.builder()
                .dateStart("2024-06-04")
                .dateEnd("2024-06-05")
                .starship(StarshipMock.mockEntity())
                .build();
        return ticket;
    }
}
