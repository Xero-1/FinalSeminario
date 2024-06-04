package LSD.StarGarage.Dtos.Responses;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class SpacePortResponse
{
    private Long id;
    private String name;
    private String location;
    private List<StarshipResponse> starshipsResponses;
}
