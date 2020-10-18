package br.ufc.quixada.dsdm.paymentsmanager.model;

public class Photo {
    private int id;
    private String name;

    public Photo() {
    }

    public Photo(int id, String name) {
        this.id = id;
        this.name = name;
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
}
