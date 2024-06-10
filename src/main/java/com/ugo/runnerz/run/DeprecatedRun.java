package com.ugo.runnerz.run;
import java.time.LocalDateTime;
import java.time.Duration;
import javax.xml.stream.Location;

public class DeprecatedRun {
    public DeprecatedRun(Integer id, String title, LocalDateTime startedOn, LocalDateTime completedOn, Location location) {
        this.id = id;
        this.title = title;
        this.startedOn = startedOn;
        this.completedOn = completedOn;
        this.location = location;

        if (!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed on must be after Started on!");

        }
    }
    private Integer id;
    private String title;
    private LocalDateTime startedOn;
    private LocalDateTime completedOn;
    private Integer miles;
    private Location location;

    public Duration getDuration() {
        return Duration.between(startedOn,completedOn);
    }
    public Integer getMiles() {
        return miles;
    }
    public void setMiles(Integer miles) {
        this.miles = miles;
    }
    public Integer getAvePace() {
        return Math.toIntExact(getDuration().toMinutes()/miles);
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getStartedOn() {
        return startedOn;
    }
    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }
    public LocalDateTime getCompletedOn() {
        return completedOn;
    }
    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }


}
