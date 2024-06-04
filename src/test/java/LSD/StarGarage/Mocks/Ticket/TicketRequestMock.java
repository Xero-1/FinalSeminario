package LSD.StarGarage.Mocks.Ticket;

import LSD.StarGarage.Dtos.Requests.TicketRequest;
import LSD.StarGarage.Mocks.Starship.StarshipRequestMock;

public class TicketRequestMock
{
    public static TicketRequest mockRequest()
    {
        TicketRequest request=new TicketRequest();
        request.setDateStart("2024-06-04");
        request.setDateEnd("2024-06-05");
        request.setStarshipRequest(StarshipRequestMock.mockRequest());
        return request;
    }
}
