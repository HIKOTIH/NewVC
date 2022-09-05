package com.gumenniy.stair.View.сontroller;


import com.gumenniy.stair.dao.OrderInterface;
import com.gumenniy.stair.dao.impl.OrderDAO;
import com.gumenniy.stair.models.Client;
import com.gumenniy.stair.models.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Date;

public class ConditionFrame {

    private ObservableList<Order> orderList = FXCollections.observableArrayList ();

    @FXML
    private TableView<Order> OrderListTable;
    @FXML
    private TableColumn<Order, Date> DateOfOrder;
    @FXML
    private TableColumn<Order, Client> CustomerName;
    @FXML
    private TableColumn<Order, String> boxSize;
    @FXML
    private TableColumn<Order, String> quont;
    @FXML
    private TableColumn<Order, Boolean> ChekDone;


    private ObservableList<Order> initAllOrders () throws SQLException, ClassNotFoundException {
        OrderInterface OI = new OrderDAO();
        orderList = OI.getUnDoneOrderList ();
        return orderList;
    }

    @FXML
    public void initialize () throws SQLException, ClassNotFoundException {


        DateOfOrder.setCellValueFactory (new PropertyValueFactory<Order, Date> ("date"));
        CustomerName.setCellValueFactory (new PropertyValueFactory<Order, Client> ("client"));
        boxSize.setCellValueFactory (new PropertyValueFactory<Order, String> ("size"));
        quont.setCellValueFactory (new PropertyValueFactory<Order, String> ("quantity"));
        ChekDone.setCellValueFactory (new PropertyValueFactory<Order, Boolean> ("done"));

        ChekDone.setCellFactory (CheckBoxTableCell.forTableColumn (ChekDone));

        OrderListTable.setItems (initAllOrders ());
        OrderListTable.setRowFactory (tv -> {
            TableRow<Order> row1 = new TableRow<> ();
            row1.setOnMouseClicked (event -> {
                if (event.getClickCount () == 2 && (!row1.isEmpty ())) {
                    Order rowData1 = row1.getItem ();
                    try {
                        showOrderDetails (rowData1);
                    } catch (Exception e) {
                        e.printStackTrace ();
                    }
                }
            });
            return row1;
        });
    }


    public void showOrderDetails ( Order order ) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("/com/gumenniy/stair/View/сontroller/GUI/OrderFullDetals.fxml"));
        Parent root1 = (Parent) fxmlLoader.load ();
        Stage stage = new Stage ();
        stage.setTitle ("Подробности");
        stage.setScene (new Scene (root1));

        OrderFullDetals controller = fxmlLoader.getController ();
        controller.setOrder (order);
        stage.show ();
    }

    @FXML
    public void refresh () throws SQLException, ClassNotFoundException {
        initialize ();
    }

    @FXML
    public void checkDone () throws SQLException, ClassNotFoundException {

        ObservableList<Order> doneList = FXCollections.observableArrayList ();

        for (Order order : OrderListTable.getItems ()) {
            if (order.isDone () == true) {
                doneList.add (order);
            }
        }
        OrderInterface OF = new OrderDAO ();
        OF.setOrderDone (doneList);
        initialize ();
    }
}
