package be.vdab;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Passenger {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @EmbeddedId
    private PassengerId passengerId;
    @Column(length = 50)
    private String firstName;
    private int frequentFlyerMiles;
    private byte [] picture;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, updatable = false)
    private Date dateOfBirth;
    @Transient
    private int age;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlight;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PassengerType passengerType;

    public Passenger(Date dateOfBirth, String firstName) {
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
    }

    public Passenger() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(int frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }

    public PassengerId getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(PassengerId passengerId) {
        this.passengerId = passengerId;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
