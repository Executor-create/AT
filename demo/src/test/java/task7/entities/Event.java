package demo.src.test.java.task6.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Temporal(TemporalType.DATE)
  private Date date;

  @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Guest> guests;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "location_id", referencedColumnName = "id")
  private Location location;

  @ManyToMany(mappedBy = "events")
  private Set<Category> categories = new HashSet<>();

  public Event() {
  }

  public Event(String name, Date date, List<Guest> guests, Location location) {
    this.name = name;
    this.date = date;
    this.guests = guests;
    this.location = location;
  }

  @Override
  public String toString() {
    return "Event{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", date=" + date +
        ", guestsCount=" + (guests != null ? guests.size() : 0) +
        ", location=" + (location != null ? location.getAddress() : null) +
        ", categoriesCount=" + categories.size() +
        '}';
  }

}
