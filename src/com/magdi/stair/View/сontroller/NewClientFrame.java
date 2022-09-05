package com.magdi.stair.View.сontroller;

import com.magdi.stair.models.Client;
import com.magdi.stair.dao.ClientInterface;
import com.magdi.stair.dao.impl.ClientDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;

public class NewClientFrame {
    Client clientModel;
    private ObservableList<Client> clientList = FXCollections.observableArrayList ();


    @FXML
    private TextField clientName;
    @FXML
    private TextField clientPhone;
    @FXML
    private TextField clientNote;
    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn ClientNameColumn;
    @FXML
    private TableColumn ClientPhoneColumn;

    private ObservableList<Client> initAllClients () throws SQLException, ClassNotFoundException {
        ClientInterface CI = new ClientDAO ();
        clientList = CI.getClients ();
        return clientList;
    }

    @FXML
    private void initialize () throws SQLException, ClassNotFoundException {
        ClientNameColumn.setCellValueFactory (new PropertyValueFactory<Client, String> ("name"));
        ClientPhoneColumn.setCellValueFactory (new PropertyValueFactory<Client, String> ("phone"));

        clientTable.setItems (initAllClients ());
        clientTable.setRowFactory (tv -> {
            TableRow<Client> row1 = new TableRow<> ();
            row1.setOnMouseClicked (event -> {
                if (event.getClickCount () == 2 && (!row1.isEmpty ())) {
                    Client model = row1.getItem ();
                    try {
                        clientModel = model;
                        showClientDetails (clientModel);
                    } catch (Exception e) {
                        e.printStackTrace ();
                    }

                }
            });
            return row1;
        });
    }


    public void insertNewClient ( ActionEvent actionEvent ) throws SQLException, ClassNotFoundException {

        String name = clientName.getText ();
        String phone = clientPhone.getText ();
        String note = clientNote.getText ();
        Client model = new Client (name, phone, note);
        ClientInterface CI = new ClientDAO ();
        CI.insertClient (model);
        clientName.clear ();
        clientPhone.clear ();
        clientNote.clear ();
    }

    @FXML
    public void refresh () throws SQLException, ClassNotFoundException {
        initialize ();
    }

    public void showClientDetails ( Client client ) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("/com/magdi/stair/View/сontroller/GUI/ClientDetail.fxml"));
        Parent root1 = (Parent) fxmlLoader.load ();
        Stage stage = new Stage ();
        stage.setTitle ("Подробности");
        stage.setScene (new Scene (root1));

        ClientDetail controller = fxmlLoader.getController ();
        controller.setClient (client);
        stage.show ();
    }
}
