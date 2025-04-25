package info.hccis.photography.session.repositories;

import info.hccis.photography.session.jpa.entity.PhotographySession;
import info.hccis.photography.session.jpa.entity.TicketOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhotographySessionRepository extends CrudRepository<PhotographySession, Integer> {
    /**
     * Use Spring Data JPA functionality to find a list of photography sessions containing the
     * string passed in as a paramter.
     *
     * @param name The name to find
     * @return The list of clients
     * @since 20241209
     * @author Vy Phan
     */
    //https://www.baeldung.com/spring-jpa-like-queries
    List<PhotographySession> findByClientNameContaining(String name);




}