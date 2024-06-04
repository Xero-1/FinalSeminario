package LSD.StarGarage.Dtos.Responses;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TicketResponse
{
    private Long id;
    private String dateStart;
    private String dateEnd;
    private StarshipResponse starshipResponse;
}
