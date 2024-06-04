package LSD.StarGarage;

import LSD.StarGarage.Dtos.Requests.IndividualRequest;
import LSD.StarGarage.Dtos.Requests.SpacePortRequest;
import LSD.StarGarage.Dtos.Requests.StarshipRequest;
import LSD.StarGarage.Dtos.Requests.TicketRequest;
import LSD.StarGarage.Dtos.Responses.IndividualResponse;
import LSD.StarGarage.Dtos.Responses.SpacePortResponse;
import LSD.StarGarage.Dtos.Responses.StarshipResponse;
import LSD.StarGarage.Dtos.Responses.TicketResponse;
import LSD.StarGarage.Mocks.Individual.IndividualMock;
import LSD.StarGarage.Mocks.Individual.IndividualRequestMock;
import LSD.StarGarage.Mocks.Individual.IndividualResponseMock;
import LSD.StarGarage.Mocks.SpacePort.SpacePortMock;
import LSD.StarGarage.Mocks.SpacePort.SpacePortRequestMock;
import LSD.StarGarage.Mocks.SpacePort.SpacePortResponseMock;
import LSD.StarGarage.Mocks.Starship.StarshipMock;
import LSD.StarGarage.Mocks.Starship.StarshipRequestMock;
import LSD.StarGarage.Mocks.Starship.StarshipResponseMock;
import LSD.StarGarage.Mocks.Ticket.TicketMock;
import LSD.StarGarage.Mocks.Ticket.TicketRequestMock;
import LSD.StarGarage.Mocks.Ticket.TicketResponseMock;
import LSD.StarGarage.Models.Individual;
import LSD.StarGarage.Models.SpacePort;
import LSD.StarGarage.Models.Starship;
import LSD.StarGarage.Models.Ticket;
import LSD.StarGarage.Repositories.IndividualRepository;
import LSD.StarGarage.Repositories.SpacePortRepository;
import LSD.StarGarage.Repositories.StarshipRepository;
import LSD.StarGarage.Repositories.TicketRepository;
import LSD.StarGarage.Services.IndividualService;
import LSD.StarGarage.Services.SpacePortService;
import LSD.StarGarage.Services.StarshipService;
import LSD.StarGarage.Services.TicketService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class StarGarageApplicationTests
{
	@Mock
	private IndividualRepository individualRepository;
	@Mock
	private IndividualService individualService;
	@Test
	public void indivialServiceReturnsResponse()
	{
		IndividualRequest requestMock= IndividualRequestMock.mockRequest();
		IndividualResponse responseMock= IndividualResponseMock.mockResponse();
		Individual entityMock= IndividualMock.mockEntity();

		when(individualRepository.save(entityMock)).thenReturn(entityMock);
		when(individualService.addIndividual(requestMock))
				.thenReturn(ResponseEntity.ok("Individual saved: "+responseMock.getName()));
		Assert.assertNotNull(individualService.addIndividual(requestMock));
		Assert.assertEquals(ResponseEntity.ok("Individual saved: "+responseMock.getName()), individualService.addIndividual(requestMock));
	}
	@Mock
	private StarshipRepository starshipRepository;
	@Mock
	private StarshipService starshipService;
	@Test
	public void starshipServiceReturnsResponse()
	{
		StarshipRequest requestMock= StarshipRequestMock.mockRequest();
		StarshipResponse responseMock= StarshipResponseMock.mockResponse();
		Starship entityMock= StarshipMock.mockEntity();

		when(starshipRepository.save(entityMock)).thenReturn(entityMock);
		when(starshipService.addStarship(requestMock))
				.thenReturn(ResponseEntity.ok("Starship saved: "+responseMock.getName()));
		Assert.assertNotNull(starshipService.addStarship(requestMock));
		Assert.assertEquals(ResponseEntity.ok("Starship saved: "+responseMock.getName()), starshipService.addStarship(requestMock));
	}
	@Mock
	private TicketRepository ticketRepository;
	@Mock
	private TicketService ticketService;
	@Test
	public void ticketServiceReturnsResponse()
	{
		TicketRequest requestMock= TicketRequestMock.mockRequest();
		TicketResponse responseMock= TicketResponseMock.mockResponse();
		Ticket entityMock= TicketMock.mockEntity();

		when(ticketRepository.save(entityMock)).thenReturn(entityMock);
		when(ticketService.addTicket(requestMock))
				.thenReturn(ResponseEntity.ok("Ticket saved: "+responseMock.getDateStart()));
		Assert.assertNotNull(ticketService.addTicket(requestMock));
		Assert.assertEquals(ResponseEntity.ok("Ticket saved: "+responseMock.getDateStart()), ticketService.addTicket(requestMock));
	}
	@Mock
	private SpacePortRepository spaceportRepository;
	@Mock
	private SpacePortService spaceportService;
	@Test
	public void spacePortServiceReturnsResponse()
	{
		SpacePortRequest requestMock= SpacePortRequestMock.mockRequest();
		SpacePortResponse responseMock= SpacePortResponseMock.mockResponse();
		SpacePort entityMock= SpacePortMock.mockEntity();

		when(spaceportRepository.save(entityMock)).thenReturn(entityMock);
		when(spaceportService.addSpacePort(requestMock))
				.thenReturn(ResponseEntity.ok("SpacePort saved: "+responseMock.getName()));
		Assert.assertNotNull(spaceportService.addSpacePort(requestMock));
		Assert.assertEquals(ResponseEntity.ok("SpacePort saved: "+responseMock.getName()), spaceportService.addSpacePort(requestMock));
	}

}
