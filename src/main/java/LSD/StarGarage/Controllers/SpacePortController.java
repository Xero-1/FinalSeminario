package LSD.StarGarage.Controllers;

import LSD.StarGarage.Dtos.Requests.SpacePortRequest;
import LSD.StarGarage.Dtos.Responses.SpacePortsResponse;
import LSD.StarGarage.Services.SpacePortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.sql.SQLException;

@RequestMapping("/spaceport")
@RestController
public class SpacePortController
{
    @Autowired
    private SpacePortService service;

    @PostMapping("/newSpacePort")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addSpacePort(@RequestBody SpacePortRequest request)
    {
        return service.addSpacePort(request);
    }

    @PutMapping("/updateSpacePort/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateSpacePort(@PathVariable("id") Long id,@RequestBody SpacePortRequest request)
    {
        return service.updateSpacePort(request,id);
    }

    @DeleteMapping("/deleteSpacePort/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteSpacePort(@PathVariable("id") Long id) throws SQLException
    {
        try
        {
            service.deleteSpacePort(id);
            return ResponseEntity.ok("SpacePort eliminated.");
        }catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Not possible eliminated SpacePort with ID= "+id+"ERROR= "+ex.getMessage());
        }
    }

    @GetMapping()
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SpacePortsResponse listSpacePorts()
    {
        return service.listSpacePorts();
    }
}
