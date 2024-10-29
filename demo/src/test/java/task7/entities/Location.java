package demo.src.test.java.task6.entities;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String address;

  @OneToOne(mappedBy = "location")
  private Event event;

  // Constructors, getters, and setters
  public Location() {
  }

  public Location(String address) {
    this.address = address;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  @Override
  public String toString() {
    return "Location{" +
        "id=" + id +
        ", address='" + address + '\'' +
        '}';
  }
}
