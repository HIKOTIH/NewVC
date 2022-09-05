package com.magdi.stair.models;


import com.magdi.stair.dao.ClientInterface;
import com.magdi.stair.dao.impl.ClientDAO;
import javafx.beans.property.*;

import java.sql.SQLException;
import java.util.Date;

public class Order {

    private IntegerProperty idOrder;
    private Date date;
    private Client client;
    private StringProperty size;
    private StringProperty quantity;
    private StringProperty price;
    private SimpleBooleanProperty done;
    private StringProperty compliteDate;
    private StringProperty note;


    public Order ( Client client ) {
        this.idOrder = new SimpleIntegerProperty ();
        this.date = new Date ();
        this.client = client;
        this.size = new SimpleStringProperty ();
        this.quantity = new SimpleStringProperty ();
        this.price = new SimpleStringProperty ();
        this.done = new SimpleBooleanProperty ();
        this.note = new SimpleStringProperty ();
        this.compliteDate = new SimpleStringProperty ();
    }

    public Order ( int clientID, String size, String quantity, String price, String note ) throws SQLException, ClassNotFoundException {
        ClientInterface CI = new ClientDAO ();
        Client client = CI.getClientByID (clientID);

        this.date = new Date ();
        this.client = client;
        this.size = new SimpleStringProperty (size);
        this.quantity = new SimpleStringProperty (quantity);
        this.price = new SimpleStringProperty (price);
        this.note = new SimpleStringProperty (note);
        this.done = new SimpleBooleanProperty ();
        this.compliteDate = new SimpleStringProperty ();
    }

    public Client getClient () {
        return this.client;
    }

    public int getIdOrder () {
        return idOrder.get ();
    }

    public void setIdOrder ( int idOrder ) {
        this.idOrder.set (idOrder);
    }

    public Date getDate () {
        return date;
    }

    public void setDate ( Date date ) {
        this.date = date;
    }

    public String getClientName () {
        return client.getName ();
    }

    public String getClientPhone () {
        return client.getPhone ();
    }

    public int getIdClient () {
        int idClient = this.client.getIdClient ();
        return idClient;
    }

    public String getClientNote () {
        return client.getDelivery ();
    }

    public void setClient ( Client client ) {
        this.client = client;
    }

    public String getSize () {
        return size.get ();
    }

    public void setSize ( String size ) {
        this.size.set (size);
    }

    public String getQuantity () {
        return quantity.get ();
    }

    public void setQuantity ( String quantity ) {
        this.quantity.set (quantity);
    }

    public String getPrice () {
        return price.get ();
    }

    public void setPrice ( String price ) {
        this.price.set (price);
    }

    public boolean isDone () {
        return done.get ();
    }

    public void setDone ( boolean done ) {
        this.done.set (done);
    }

    public String getCompliteDate () {
        return compliteDate.get ();
    }

    public void setCompliteDate ( String compliteDate ) {
        this.compliteDate.set (compliteDate);
    }

    public String getNote () {
        return note.get ();
    }

    public void setNote ( String note ) {
        this.note.set (note);
    }
}

