package com.gumenniy.stair.View.сontroller;

import com.gumenniy.stair.dao.ClientInterface;
import com.gumenniy.stair.dao.impl.ClientDAO;
import com.gumenniy.stair.models.Client;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.sql.SQLException;

public class ClientDetail {

    @FXML
    private TextArea phoneField;
    @FXML
    private TextArea nameField;
    @FXML
    private TextArea noteField;

    Client model;

    @FXML
    private void initialize () {
    }

    public void setClient ( Client client ) {

        phoneField.setText (client.getPhone ());
        nameField.setText (client.getName ());
        noteField.setText (client.getDelivery ());
        model = client;
    }

    @FXML
    public void updateClient () throws SQLException, ClassNotFoundException {

        ClientInterface CI = new ClientDAO();
        CI.updateClient (getClient ());
    }

    private Client getClient () {

        model.setName (nameField.getText ());
        model.setPhone (phoneField.getText ());
        model.setDelivery (noteField.getText ());
        return model;
    }
}
