package demo.src.test.java.task7;

@Service
public class Main {
  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  public Event createEvent(String name, Date date, List<Guest> guests, Location location, Set<Category> categories) {
    Event event = new Event(name, date, guests, location);
    event.setCategories(categories);

    for (Category category : categories) {
      category.getEvents().add(event);
    }

    return eventRepository.save(event);
  }

  public Event getEvent(Long id) {
    return eventRepository.findById(id).orElse(null);
  }

  public Event updateEvent(Long id, String name, Date date, List<Guest> guests, Location location,
      Set<Category> categories) {
    Event event = getEvent(id);
    if (event != null) {
      event.setName(name);
      event.setDate(date);
      event.setGuests(guests);
      event.setLocation(location);
      event.setCategories(categories);
      return eventRepository.save(event);
    }
    return null;
  }

  public void deleteEvent(Long id) {
    eventRepository.deleteById(id);
  }

}
