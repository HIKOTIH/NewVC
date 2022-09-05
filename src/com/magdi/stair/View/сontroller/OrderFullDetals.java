package com.magdi.stair.View.сontroller;

import com.magdi.stair.models.Client;
import com.magdi.stair.models.Order;
import com.magdi.stair.dao.OrderInterface;
import com.magdi.stair.dao.impl.OrderDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.sql.SQLException;

public class OrderFullDetals {

    Client clientModel;
    Order orderModel;

    @FXML
    private TextArea OrderNoteField;
    @FXML
    private TextArea DoneField;
    @FXML
    private TextArea MakeDateField;
    @FXML
    private TextArea quontField;
    @FXML
    private TextArea PriceField;
    @FXML
    private TextArea SizeField;
    @FXML
    private TextArea DateField;
    @FXML
    private TextArea NameField;
    @FXML
    private TextArea PhoneField;
    @FXML
    private TextArea ClientNoteField;

    @FXML
    private void initialize () {
    }

    public void setOrder ( Order order ) {
        OrderNoteField.setText (order.getNote ());
        String date = String.valueOf (order.getDate ());
        DateField.setText (date);
        MakeDateField.setText (order.getCompliteDate ());
        quontField.setText (order.getQuantity ());
        PriceField.setText (order.getPrice ());
        SizeField.setText (order.getSize ());
        NameField.setText (order.getClientName ());
        PhoneField.setText (order.getClientPhone ());
        ClientNoteField.setText (order.getClientNote ());
        DoneField.setText (String.valueOf (order.isDone ()));

        clientModel = order.getClient ();
        orderModel = order;
    }

    @FXML
    public void deleteOrder () throws SQLException, ClassNotFoundException {

        OrderInterface OI = new OrderDAO ();
        OI.deleteOrder (getOrder ());
    }

    @FXML
    public void updateOrder () throws SQLException, ClassNotFoundException {

        OrderInterface OI = new OrderDAO ();
        OI.updateOrder (getOrder ());
    }

    private Order getOrder () {

        orderModel.setNote (OrderNoteField.getText ());
        orderModel.setPrice (PriceField.getText ());
        orderModel.setQuantity (quontField.getText ());
        orderModel.setSize (SizeField.getText ());
        return orderModel;
    }
}
