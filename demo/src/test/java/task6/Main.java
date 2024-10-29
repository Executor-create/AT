package demo.src.test.java.task6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
public class Main implements CommandLineRunner {
  @Autowired
  private EventRepository eventRepository;
  @Autowired
  private GuestRepository guestRepository;

  @Override
  public void run(String... args) throws Exception {
    Event event = new Event();
    event.setName("Birthday Party");
    event.setDate(new Date());

    Guest guest1 = new Guest();
    guest1.setName("Alice");
    guest1.setEvent(event);

    Guest guest2 = new Guest();
    guest2.setName("Bob");
    guest2.setEvent(event);

    event.setGuests(Arrays.asList(guest1, guest2));

    eventRepository.save(event);

    Event fetchedEvent = eventRepository.findById(event.getId()).orElse(null);
    System.out.println("Event: " + fetchedEvent);

    if (fetchedEvent != null) {
      fetchedEvent.setName("Updated Birthday Party");
      eventRepository.save(fetchedEvent);
    }

    eventRepository.deleteById(event.getId());
  }
}
