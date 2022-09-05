package com.magdi.stair.dao;

import com.magdi.stair.models.Client;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ClientInterface {
    void insertClient ( Client model ) throws SQLException, ClassNotFoundException;

    ObservableList<Client> getClients () throws SQLException, ClassNotFoundException;

    Client getClientByID ( int ClientId ) throws SQLException, ClassNotFoundException;

    void updateClient ( Client client ) throws SQLException, ClassNotFoundException;
}
