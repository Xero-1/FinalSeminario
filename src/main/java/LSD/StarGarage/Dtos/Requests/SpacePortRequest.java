package LSD.StarGarage.Dtos.Requests;

import lombok.Data;

import java.util.List;

@Data
public class SpacePortRequest
{
    private String name;
    private String location;
    private List<StarshipRequest> starshipsRequests;
}
