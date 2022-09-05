package com.gumenniy.stair.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
    private IntegerProperty idClient;
    private StringProperty name;
    private StringProperty phone;
    private StringProperty delivery;

    public Client () {
        this.idClient = new SimpleIntegerProperty ();
        this.name = new SimpleStringProperty ();
        this.phone = new SimpleStringProperty ();
        this.delivery = new SimpleStringProperty ();
    }

    public Client ( String name, String phone, String delivery ) {
        this.name = new SimpleStringProperty (name);
        this.phone = new SimpleStringProperty (phone);
        this.delivery = new SimpleStringProperty (delivery);

    }

    public int getIdClient () {
        return idClient.get ();
    }

    public IntegerProperty idClientProperty () {
        return idClient;
    }

    public void setIdClient ( int idClient ) {
        this.idClient.set (idClient);
    }

    public String getName () {
        return this.name.get ();
    }

    public void setName ( String name ) {
        this.name.set (name);
    }

    public String getPhone () {
        return phone.get ();
    }

    public void setPhone ( String phone ) {
        this.phone.set (phone);
    }

    public String getDelivery () {
        return delivery.get ();
    }

    public void setDelivery ( String delivery ) {
        this.delivery.set (delivery);
    }

    @Override
    public String toString () {
        return this.name.get ();

    }
}
