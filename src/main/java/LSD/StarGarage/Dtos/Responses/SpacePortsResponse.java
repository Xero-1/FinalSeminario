package LSD.StarGarage.Dtos.Responses;

import LSD.StarGarage.Models.SpacePort;
import lombok.Builder;
import lombok.Data;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Builder
@Data
@Produces(MediaType.APPLICATION_JSON)
public class SpacePortsResponse
{
    private List<SpacePort> spacePorts;
}
