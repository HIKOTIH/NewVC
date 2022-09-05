package com.magdi.stair.View.сontroller;

import com.magdi.stair.models.Client;
import com.magdi.stair.models.Order;
import com.magdi.stair.dao.OrderInterface;
import com.magdi.stair.dao.impl.OrderDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Date;

public class OrdersFrame {

    private ObservableList<Order> orderList = FXCollections.observableArrayList ();


    @FXML
    private TableView<Order> ordersTableView;

    @FXML
    private TableView<Order> week1ordersTableView;
    @FXML
    private TableView<Order> mounth1ordersTableView;
    @FXML
    private TableView<Order> mounth3ordersTableView;
    @FXML
    private TableView<Order> year1ordersTableView;
    @FXML
    private TableColumn<Order, Date> orderDateTable1;
    @FXML
    private TableColumn<Order, Client> clientTable1;
    @FXML
    private TableColumn<Order, String> sizeTable1;
    @FXML
    private TableColumn<Order, String> quontityTable1;
    @FXML
    private TableColumn<Order, String> priseTable1;
    @FXML
    private TableColumn<Order, String> dateDoneTable1;
    @FXML
    private TableColumn<Order, Date> orderDateTable2;
    @FXML
    private TableColumn<Order, Client> clientTable2;
    @FXML
    private TableColumn<Order, String> sizeTable2;
    @FXML
    private TableColumn<Order, String> quontityTable2;
    @FXML
    private TableColumn<Order, String> priseTable2;
    @FXML
    private TableColumn<Order, String> dateDoneTable2;
    @FXML
    private TableColumn<Order, Date> orderDateTable3;
    @FXML
    private TableColumn<Order, Client> clientTable3;
    @FXML
    private TableColumn<Order, String> sizeTable3;
    @FXML
    private TableColumn<Order, String> quontityTable3;
    @FXML
    private TableColumn<Order, String> priseTable3;
    @FXML
    private TableColumn<Order, String> dateDoneTable3;
    @FXML
    private TableColumn<Order, Date> orderDateTable4;
    @FXML
    private TableColumn<Order, Client> clientTable4;
    @FXML
    private TableColumn<Order, String> sizeTable4;
    @FXML
    private TableColumn<Order, String> quontityTable4;
    @FXML
    private TableColumn<Order, String> priseTable4;
    @FXML
    private TableColumn<Order, String> dateDoneTable4;
    @FXML
    private TableColumn<Order, Date> orderDateTable5;
    @FXML
    private TableColumn<Order, Client> clientTable5;
    @FXML
    private TableColumn<Order, String> sizeTable5;
    @FXML
    private TableColumn<Order, String> quontityTable5;
    @FXML
    private TableColumn<Order, String> priseTable5;
    @FXML
    private TableColumn<Order, String> dateDoneTable5;


    private ObservableList<Order> initAllOrders () throws SQLException, ClassNotFoundException {
        OrderInterface OI = new OrderDAO ();
        orderList = OI.getOrderList ();
        return orderList;
    }

    private ObservableList<Order> init1MounthOrders () throws SQLException, ClassNotFoundException {
        OrderInterface OI = new OrderDAO ();
        orderList = OI.getOrderList1mounth ();
        return orderList;
    }

    private ObservableList<Order> init3MounthOrders () throws SQLException, ClassNotFoundException {
        OrderInterface OI = new OrderDAO ();
        orderList = OI.getOrderList3mounth ();
        return orderList;
    }

    private ObservableList<Order> init1YearOrders () throws SQLException, ClassNotFoundException {
        OrderInterface OI = new OrderDAO ();
        orderList = OI.getOrderList1Year ();
        return orderList;
    }

    private ObservableList<Order> init1WeekOrders () throws SQLException, ClassNotFoundException {
        OrderInterface OI = new OrderDAO ();
        orderList = OI.getOrderList1Week ();
        return orderList;
    }

    public void showOrderDetails ( Order order ) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("/com/magdi/stair/View/сontroller/GUI/OrderFullDetals.fxml"));
        Parent root1 = (Parent) fxmlLoader.load ();
        Stage stage = new Stage ();
        stage.setTitle ("Подробности Заказа");
        stage.setScene (new Scene (root1));

        OrderFullDetals controller = fxmlLoader.getController ();
        controller.setOrder (order);
        stage.show ();
    }

    @FXML
    public void initialize () throws SQLException, ClassNotFoundException {

        orderDateTable1.setCellValueFactory (new PropertyValueFactory<Order, Date> ("date"));
        clientTable1.setCellValueFactory (new PropertyValueFactory<Order, Client> ("client"));
        sizeTable1.setCellValueFactory (new PropertyValueFactory<Order, String> ("size"));
        quontityTable1.setCellValueFactory (new PropertyValueFactory<Order, String> ("quantity"));
        priseTable1.setCellValueFactory (new PropertyValueFactory<Order, String> ("price"));
        dateDoneTable1.setCellValueFactory (new PropertyValueFactory<Order, String> ("compliteDate"));

        week1ordersTableView.setItems (init1WeekOrders ());      //1 week
        onClicked (week1ordersTableView);

        orderDateTable2.setCellValueFactory (new PropertyValueFactory<Order, Date> ("date"));
        clientTable2.setCellValueFactory (new PropertyValueFactory<Order, Client> ("client"));
        sizeTable2.setCellValueFactory (new PropertyValueFactory<Order, String> ("size"));
        quontityTable2.setCellValueFactory (new PropertyValueFactory<Order, String> ("quantity"));
        priseTable2.setCellValueFactory (new PropertyValueFactory<Order, String> ("price"));
        dateDoneTable2.setCellValueFactory (new PropertyValueFactory<Order, String> ("compliteDate"));

        mounth1ordersTableView.setItems (init1MounthOrders ());            //1 mointh
        onClicked (mounth1ordersTableView);


        orderDateTable3.setCellValueFactory (new PropertyValueFactory<Order, Date> ("date"));
        clientTable3.setCellValueFactory (new PropertyValueFactory<Order, Client> ("client"));
        sizeTable3.setCellValueFactory (new PropertyValueFactory<Order, String> ("size"));
        quontityTable3.setCellValueFactory (new PropertyValueFactory<Order, String> ("quantity"));
        priseTable3.setCellValueFactory (new PropertyValueFactory<Order, String> ("price"));
        dateDoneTable3.setCellValueFactory (new PropertyValueFactory<Order, String> ("compliteDate"));

        mounth3ordersTableView.setItems (init3MounthOrders ());            //3 mounth
        onClicked (mounth3ordersTableView);

        orderDateTable4.setCellValueFactory (new PropertyValueFactory<Order, Date> ("date"));
        clientTable4.setCellValueFactory (new PropertyValueFactory<Order, Client> ("client"));
        sizeTable4.setCellValueFactory (new PropertyValueFactory<Order, String> ("size"));
        quontityTable4.setCellValueFactory (new PropertyValueFactory<Order, String> ("quantity"));
        priseTable4.setCellValueFactory (new PropertyValueFactory<Order, String> ("price"));
        dateDoneTable4.setCellValueFactory (new PropertyValueFactory<Order, String> ("compliteDate"));

        year1ordersTableView.setItems (init1YearOrders ());              //1 year
        onClicked (year1ordersTableView);


        orderDateTable5.setCellValueFactory (new PropertyValueFactory<Order, Date> ("date"));
        clientTable5.setCellValueFactory (new PropertyValueFactory<Order, Client> ("client"));
        sizeTable5.setCellValueFactory (new PropertyValueFactory<Order, String> ("size"));
        quontityTable5.setCellValueFactory (new PropertyValueFactory<Order, String> ("quantity"));
        priseTable5.setCellValueFactory (new PropertyValueFactory<Order, String> ("price"));
        dateDoneTable5.setCellValueFactory (new PropertyValueFactory<Order, String> ("compliteDate"));

        ordersTableView.setItems (initAllOrders ());                   //all time
        onClicked (ordersTableView);
    }

    private void onClicked ( TableView<Order> mounth3ordersTableView ) {
        mounth3ordersTableView.setRowFactory (tv -> {
            TableRow<Order> row = new TableRow<> ();
            row.setOnMouseClicked (event -> {
                if (event.getClickCount () == 2 && (!row.isEmpty ())) {
                    Order rowData = row.getItem ();
                    try {
                        showOrderDetails (rowData);
                    } catch (Exception e) {
                        e.printStackTrace ();
                    }

                }
            });
            return row;
        });
    }

    @FXML
    public void refresh () throws SQLException, ClassNotFoundException {
        initialize ();
    }
}
