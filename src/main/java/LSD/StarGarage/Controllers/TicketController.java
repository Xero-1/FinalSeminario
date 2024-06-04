package LSD.StarGarage.Controllers;

import LSD.StarGarage.Dtos.Requests.TicketRequest;
import LSD.StarGarage.Dtos.Responses.TicketsResponse;
import LSD.StarGarage.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.sql.SQLException;

@RequestMapping("/ticket")
@RestController
public class  TicketController
{
    @Autowired
    private TicketService service;

    @PostMapping("/newTicket")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addTicket(@RequestBody TicketRequest request)
    {
        return service.addTicket(request);
    }

    @PutMapping("/updateTicket/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTicket(@PathVariable("id") Long id, @RequestBody TicketRequest request)
    {
        return service.updateTicket(request,id);
    }

    @DeleteMapping("/deleteTicket/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteIndividual(@PathVariable("id") Long id) throws SQLException
    {
        try
        {
            service.deleteTicket(id);
            return ResponseEntity.ok("Ticket eliminated.");
        }catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Not possible eliminate ticket with id= "+id+" ERROR= "+ex.getMessage());
        }
    }

    @GetMapping()
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TicketsResponse listTickets()
    {
        return service.listTickets();
    }
}
