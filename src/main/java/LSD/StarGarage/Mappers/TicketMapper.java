package LSD.StarGarage.Mappers;

import LSD.StarGarage.Dtos.Requests.TicketRequest;
import LSD.StarGarage.Dtos.Responses.TicketsResponse;
import LSD.StarGarage.Models.Starship;
import LSD.StarGarage.Models.Ticket;
import LSD.StarGarage.Services.StarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketMapper
{
    @Autowired
    private StarshipService starshipService;

    public Ticket ticketRequestToTicket(TicketRequest request)
    {
        Starship starship=Starship.builder()
                .name(request.getStarshipRequest().getName())
                .model(request.getStarshipRequest().getModel())
                .cargoCapacity(request.getStarshipRequest().getCargoCapacity())
                .build();
        starship=starshipService.setNewOrExistentStarship(request.getStarshipRequest(),starship);
        Ticket ticket= Ticket.builder()
                .dateStart(request.getDateStart())
                .dateEnd(request.getDateEnd())
                .starship(starship)
                .build();
        return ticket;
    }
    public TicketsResponse ticketsListToResponse(List<Ticket> list)
    {
        List<Ticket> responseList=new ArrayList<>();
        for(Ticket ticket : list)
        {
            Starship starship=Starship.builder()
                    .id(ticket.getStarship().getId())
                    .name(ticket.getStarship().getName())
                    .model(ticket.getStarship().getModel())
                    .cargoCapacity(ticket.getStarship().getCargoCapacity())
                    .captain(ticket.getStarship().getCaptain())
                    .build();
            Ticket newTicket=Ticket.builder()
                    .id(ticket.getId())
                    .dateStart(ticket.getDateStart())
                    .dateEnd(ticket.getDateEnd())
                    .starship(starship)
                    .build();
            responseList.add(newTicket);
        }
        TicketsResponse ticketsResponse=TicketsResponse.builder()
                .tickets(responseList)
                .build();
        return ticketsResponse;
    }
}
