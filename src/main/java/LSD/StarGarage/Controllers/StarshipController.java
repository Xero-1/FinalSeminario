package LSD.StarGarage.Controllers;

import LSD.StarGarage.Dtos.Requests.StarshipRequest;
import LSD.StarGarage.Dtos.Responses.StarshipsResponse;
import LSD.StarGarage.Services.StarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.sql.SQLException;

@RequestMapping("/starship")
@RestController
public class StarshipController
{
    @Autowired
    private StarshipService service;

    @PostMapping("/newShip")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addStarship(@RequestBody StarshipRequest request)
    {
        return service.addStarship(request);
    }

    @PutMapping("/updateShip/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateStarship(@PathVariable("id") Long id,@RequestBody StarshipRequest request)
    {
        return service.updateStarship(request,id);
    }

    @DeleteMapping("/deleteShip/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteStarship(@PathVariable("id") Long id) throws SQLException
    {
        try
        {
            service.deleteStarship(id);
            return ResponseEntity.ok("Ship eliminated.");
        }catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Not possible eliminate ship with id= "+id+" ERROR= "+ex.getMessage());
        }
    }

    @GetMapping()
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StarshipsResponse listStarships()
    {
        return service.listStarships();
    }
}
