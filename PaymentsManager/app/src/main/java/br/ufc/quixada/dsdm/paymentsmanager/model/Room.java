package br.ufc.quixada.dsdm.paymentsmanager.model;

import java.util.List;

public class Room {
    private int id;
    private String name;
    private Photo photo;
    private String description;
    private List<User> persons;

    public Room() {
    }

    public Room(int id, String name, Photo photo, String description, List<User> persons) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.persons = persons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getPersons() {
        return persons;
    }

    public void setPersons(List<User> persons) {
        this.persons = persons;
    }
}
