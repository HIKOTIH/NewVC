package com.gumenniy.stair.dao.impl;

import com.gumenniy.stair.dao.ClientInterface;
import com.gumenniy.stair.models.Client;
import com.gumenniy.stair.sqlFunc.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO implements ClientInterface {

    public void insertClient ( Client model ) throws SQLException, ClassNotFoundException {
        String name = model.getName ();
        String phone = model.getPhone ();
        String delivery = model.getDelivery ();
        String updateStmt = "INSERT INTO CLIENTS (name,phone,delivery) Values ('" + name + "','" + phone + "','" + delivery + "')";
        DBUtil.dbExecuteUpdate (updateStmt);
    }

    public ObservableList<Client> getClients () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM CLIENTS";
        ResultSet rs = DBUtil.dbExecuteQuery (selectStmt);
        ObservableList<Client> clientList = FXCollections.observableArrayList ();
        while (rs.next ()) {
            Client model = new Client ();
            model.setIdClient (rs.getInt ("idClient"));
            model.setName (rs.getString ("name"));
            model.setPhone (rs.getString ("phone"));
            model.setDelivery (rs.getString ("delivery"));
            clientList.add (model);
        }
        return clientList;
    }


    public Client getClientByID ( int ClientId ) throws SQLException, ClassNotFoundException {
        String selectClientByID = "SELECT * FROM CLIENTS WHERE idClient =" + ClientId;
        Client model = new Client ();
        ResultSet rs = DBUtil.dbExecuteQuery (selectClientByID);
        while (rs.next ()) {
            model.setIdClient (rs.getInt ("idClient"));
            model.setName (rs.getString ("name"));
            model.setPhone (rs.getString ("phone"));
            model.setDelivery (rs.getString ("delivery"));
        }
        return model;
    }

    public void updateClient ( Client client ) throws SQLException, ClassNotFoundException {

        String name = client.getName ();
        String phone = client.getPhone ();
        String note = client.getDelivery ();
        int clientId = client.getIdClient ();

        String updateStmt = "UPDATE PUBLIC.CLIENTS" +
                " SET  NAME='" + name + "', PHONE='" + phone + "', delivery='" + note + "' WHERE IDClient='" + clientId + "';";
        DBUtil.dbExecuteUpdate (updateStmt);
    }
}
