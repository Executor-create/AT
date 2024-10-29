package demo.src.test.java.task6.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Temporal(TemporalType.DATE)
  private Date date;

  @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
  private List<Guest> guests;

  public Event() {
  }

  public Event(String name, Date date, List<Guest> guests) {
    this.name = name;
    this.date = date;
    this.guests = guests;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public List<Guest> getGuests() {
    return guests;
  }

  public void setGuests(List<Guest> guests) {
    this.guests = guests;
  }

}
