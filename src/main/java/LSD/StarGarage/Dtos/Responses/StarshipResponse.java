package LSD.StarGarage.Dtos.Responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StarshipResponse
{
    private Long id;
    private String name;
    private String model;
    private float cargoCapacity;
    private IndividualResponse captainResponse;
}
