package LSD.StarGarage.Dtos.Responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IndividualResponse
{
    private Long id;
    private String name;
    private String lastName;
    private String species;
}
