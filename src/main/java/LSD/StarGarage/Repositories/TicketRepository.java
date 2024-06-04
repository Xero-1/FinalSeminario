package LSD.StarGarage.Repositories;

import LSD.StarGarage.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long>
{
}
