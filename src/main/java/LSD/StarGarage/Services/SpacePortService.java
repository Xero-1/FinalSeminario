package LSD.StarGarage.Services;

import LSD.StarGarage.Dtos.Requests.SpacePortRequest;
import LSD.StarGarage.Dtos.Responses.SpacePortsResponse;
import LSD.StarGarage.Mappers.SpacePortMapper;
import LSD.StarGarage.Models.SpacePort;
import LSD.StarGarage.Repositories.SpacePortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpacePortService
{
    @Autowired
    private SpacePortRepository repository;
    @Autowired
    private SpacePortMapper mapper;

    public ResponseEntity addSpacePort(SpacePortRequest request)
    {
        SpacePort spacePort=mapper.spacePortRequestToSpacePort(request);
        repository.save(spacePort);
        return ResponseEntity.ok("New SpacePort saved: "+spacePort.getName()+" at location "+spacePort.getLocation());
    }
    public void deleteSpacePort(Long id)
    {
        repository.deleteById(id);
    }
    public SpacePortsResponse listSpacePorts()
    {
        List<SpacePort> list=repository.findAll();
        return mapper.spacePortsListToResponse(list);
    }
    public ResponseEntity updateSpacePort(SpacePortRequest request,Long id)
    {
        try
        {
            SpacePort spacePort=repository.getById(id);
            spacePort=mapper.spacePortRequestToSpacePort(request);
            repository.save(spacePort);
            return ResponseEntity.ok("SpacePort updated.");
        }catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Not founded SpacePort with ID= "+id);
        }
    }
}
