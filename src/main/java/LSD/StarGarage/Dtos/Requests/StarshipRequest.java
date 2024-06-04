package LSD.StarGarage.Dtos.Requests;

import lombok.Data;

@Data
public class StarshipRequest
{
    private String name;
    private String model;
    private float cargoCapacity;
    private IndividualRequest captainRequest;
}
