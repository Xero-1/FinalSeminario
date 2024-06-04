package LSD.StarGarage.Services;

import LSD.StarGarage.Dtos.Requests.TicketRequest;
import LSD.StarGarage.Dtos.Responses.TicketsResponse;
import LSD.StarGarage.Mappers.TicketMapper;
import LSD.StarGarage.Models.Ticket;
import LSD.StarGarage.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService
{
    @Autowired
    private TicketRepository repository;
    @Autowired
    private TicketMapper mapper;

    public ResponseEntity addTicket(TicketRequest request)
    {
        Ticket ticket=mapper.ticketRequestToTicket(request);
        repository.save(ticket);
        return ResponseEntity.ok("New Ticket created.");
    }
    public void deleteTicket(Long id){repository.deleteById(id);}
    public TicketsResponse listTickets()
    {
        List<Ticket> tickets=repository.findAll();
        return mapper.ticketsListToResponse(tickets);
    }
    public ResponseEntity updateTicket(TicketRequest request,Long id)
    {
        try
        {
            Ticket ticket=repository.getById(id);
            ticket=mapper.ticketRequestToTicket(request);
            repository.save(ticket);
            return ResponseEntity.ok("Ticket updated");
        }catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Not founded Ticket with ID= "+id);
        }
    }
}
