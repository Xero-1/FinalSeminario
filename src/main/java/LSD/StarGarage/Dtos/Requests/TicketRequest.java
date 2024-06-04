package LSD.StarGarage.Dtos.Requests;

import lombok.Data;

@Data
public class TicketRequest
{
    private String dateStart;
    private String dateEnd;
    private StarshipRequest starshipRequest;
}
