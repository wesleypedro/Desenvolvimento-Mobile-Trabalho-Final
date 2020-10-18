package br.ufc.quixada.dsdm.paymentsmanager.model;

public class User {
    private int id;
    private Photo photo;
    private String name;
    private String email;
    private String password;

    public User() {
    }

    public User(int id, Photo photo, String name, String email, String password) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
