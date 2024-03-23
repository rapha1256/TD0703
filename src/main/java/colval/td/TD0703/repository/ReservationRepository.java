package colval.td.TD0703.repository;

import colval.td.TD0703.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findReservationById(Long id);

    List<Reservation> findReservationsByLivre_Id(Long id);
}
