package cs3220.model;

import java.time.LocalDate;

public class Event {
    // Properties
    private String name;
    private LocalDate eventDate;
    private String createdBy;

    // Constructor
    public Event(String name, LocalDate eventDate, String createdBy) {
        this.name = name;
        this.eventDate = eventDate;
        this.createdBy = createdBy;
    }

    // Getters
    public String getName() {
        return name;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    // toString method for easy display
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", eventDate=" + eventDate +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
