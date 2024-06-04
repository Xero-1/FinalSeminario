package LSD.StarGarage.Mocks.Ticket;

import LSD.StarGarage.Dtos.Responses.TicketResponse;
import LSD.StarGarage.Mocks.Starship.StarshipResponseMock;

public class TicketResponseMock
{
    public static TicketResponse mockResponse()
    {
        TicketResponse response=TicketResponse.builder()
                .dateStart("2024-06-04")
                .dateEnd("2024-06-05")
                .starshipResponse(StarshipResponseMock.mockResponse())
                .build();
        return response;
    }
}
