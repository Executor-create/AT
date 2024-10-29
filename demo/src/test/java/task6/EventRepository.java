import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
