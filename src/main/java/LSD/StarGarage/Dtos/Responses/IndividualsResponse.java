package LSD.StarGarage.Dtos.Responses;

import LSD.StarGarage.Models.Individual;
import lombok.Builder;
import lombok.Data;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Builder
@Data
@Produces(MediaType.APPLICATION_JSON)
public class IndividualsResponse
{
    private List<Individual> individuals;
}
