package LSD.StarGarage.Controllers;

import LSD.StarGarage.Dtos.Requests.IndividualRequest;
import LSD.StarGarage.Dtos.Responses.IndividualsResponse;
import LSD.StarGarage.Services.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@RequestMapping("/individual")
@RestController
public class IndividualController
{
    @Autowired
    private IndividualService service;

    @PostMapping("/newIndividual")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity addIndividual(@RequestBody IndividualRequest request)
    {
        return service.addIndividual(request);
    }

    @PutMapping("/updateIndividual/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity updateIndividual(@PathVariable("id") Long id, @RequestBody IndividualRequest request)
    {
        return service.updateIndividual(request,id);
    }

    @DeleteMapping("/deleteIndividual/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity deleteIndividual(@PathVariable("id") Long id) throws SQLException
    {
        try
        {
            service.deleteIndividual(id);
            return ResponseEntity.ok("Individual eliminated.");
        }catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Not possible eliminate individual with id= "+id+" ERROR= "+ex.getMessage());
        }
    }

    @GetMapping()
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseBody
    public IndividualsResponse listIndividuals()
    {
        return service.listIndividuals();
    }
}