package br.ufc.quixada.dsdm.paymentsmanager.model;

import java.util.Date;

public class Card {
    private int id;
    private String name;
    private String description;
    private Photo photo;
    private Date vencimento;
    private double valor;

    public Card() {
    }

    public Card(int id, String name, String description, Photo photo, Date vencimento, double valor) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.vencimento = vencimento;
        this.valor = valor;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
