package com.example.codeclan.cswm.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="hosts")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private int age;

    @Column(name="tagline")
    private String tagline;

    @Column(name="venue_type")
    private String venueType;

    @Column(name="music_type")
    private String musicType;

    @Column(name="budget")
    private String budget;

    @Column(name="rating")
    private int rating;

    @OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
    private List<User> users;

    public Host(String firstName, String lastName, int age, String tagline, String venueType, String musicType, String budget, int rating) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.tagline = tagline;
        this.venueType = venueType;
        this.musicType = musicType;
        this.budget = budget;
        this.rating = rating;
        this.users = new ArrayList<>();
    }

    public Host() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
