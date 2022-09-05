package com.magdi.stair.View.сontroller;

import com.magdi.stair.models.Client;
import com.magdi.stair.models.Order;
import com.magdi.stair.dao.ClientInterface;
import com.magdi.stair.dao.OrderInterface;
import com.magdi.stair.dao.impl.ClientDAO;
import com.magdi.stair.dao.impl.OrderDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import org.controlsfx.control.textfield.TextFields;

import java.sql.SQLException;

public class NewOrderFrame {


    @FXML
    private ComboBox<Client> ClientListB;
    @FXML
    private TextField boxSizeField;
    @FXML
    private TextField quontField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField noteField;
    @FXML
    private Label nameLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private TextField boxLenghtField;
    @FXML
    private TextField rezMaxHField;


    @FXML
    public void initialize () {
    }

    @FXML
    public void boXini () throws SQLException, ClassNotFoundException {
        ObservableList<Client> innerList;
        ClientInterface CI = new ClientDAO ();
        innerList = CI.getClients ();


        ClientListB.setItems (innerList);
        TextFields.bindAutoCompletion (ClientListB.getEditor (), ClientListB.getItems ());
        ClientListB.setConverter (new StringConverter<Client> () {
            @Override
            public String toString ( Client object ) {
                if (object == null) return null;
                return object.toString ();
            }

            @Override
            public Client fromString ( String string ) {

                return ClientListB.getItems ().stream ().filter (ap -> ap.getName ().equals (string)).findFirst ().orElse (null);
            }
        });
    }

    int selectedID;

    @FXML
    public void select ( ActionEvent actionEvent ) {
        selectedID = ClientListB.getValue ().idClientProperty ().get ();
        nameLabel.setText (ClientListB.getValue ().getName ());
        phoneLabel.setText (ClientListB.getValue ().getPhone ());
    }

    @FXML
    public void insertNewOrder ( ActionEvent actionEvent ) throws SQLException, ClassNotFoundException {
        String notein;
        if (noteField.getText ().isEmpty ()) {
            notein = "не заполнено";
        } else {
            notein = noteField.getText ();
        }
        String sizein;
        if (boxSizeField.getText ().isEmpty ()) {
            sizein = "не заполнено";
        } else {
            sizein = boxSizeField.getText ();
        }
        String price;
        if (priceField.getText ().isEmpty ()) {
            price = "не заполнено";
        } else {
            price = priceField.getText ();
        }
        String quont;
        if (quontField.getText ().isEmpty ()) {
            quont = "не заполнено";
        } else {
            quont = quontField.getText ();
        }
        Order model = new Order (selectedID, sizein, quont, price, notein);
        OrderInterface OF = new OrderDAO ();
        OF.insertOrder (model);
        boxSizeField.clear ();
        quontField.clear ();
        priceField.clear ();
        noteField.clear ();
    }

    @FXML
    public void calcMaxHeight ( ActionEvent actionEvent ) {
        Double boxLenght = Double.parseDouble (boxLenghtField.getText ());
        Double maxHeight = Math.floor (MaxHeightCalc.maxHeightCalc (boxLenght));
        rezMaxHField.setText (maxHeight.toString ());
    }
}







