package LSD.StarGarage.Dtos.Responses;

import LSD.StarGarage.Models.Ticket;
import lombok.Builder;
import lombok.Data;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Builder
@Data
@Produces(MediaType.APPLICATION_JSON)
public class TicketsResponse
{
    private List<Ticket> tickets;
}
