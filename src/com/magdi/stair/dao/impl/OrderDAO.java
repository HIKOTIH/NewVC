package com.magdi.stair.dao.impl;


import com.magdi.stair.models.Client;
import com.magdi.stair.models.Order;
import com.magdi.stair.dao.ClientInterface;
import com.magdi.stair.dao.OrderInterface;
import com.magdi.stair.sqlFunc.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO implements OrderInterface {


    public void insertOrder ( Order order ) throws SQLException, ClassNotFoundException {

        String size = order.getSize ();
        int idClient = order.getIdClient ();
        String quantity = order.getQuantity ();
        String price = order.getPrice ();
        String note = order.getNote ();

        String updateStmt = "INSERT INTO ORDERS" +
                "(DATE, BOXSIZE, IDCLIENT, QUANTITY, PRICE, DONE, COMPLITEDATE, NOTE)" +
                "VALUES(SYSDATE, '" + size + "', " + idClient + ", '" + quantity + "', '" + price + "', false, 'not done', '" + note + "')";
        DBUtil.dbExecuteUpdate (updateStmt);
    }

    public ObservableList<Order> getOrderList () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM ORDERS";
        ResultSet rs = DBUtil.dbExecuteQuery (selectStmt);
        ObservableList<Order> orderList = getFULLOrderList (rs);
        return orderList;
    }

    private ObservableList<Order> getFULLOrderList ( ResultSet rs ) throws SQLException, ClassNotFoundException {
        ObservableList<Order> orderList = FXCollections.observableArrayList ();
        while (rs.next ()) {
            ClientInterface CI = new ClientDAO ();
            Client client = CI.getClientByID ((rs.getInt ("idClient")));


            Order model = new Order (client);
            String shortDate = null;
            model.setIdOrder (rs.getInt ("idOrder"));
            model.setDate (rs.getDate ("Date"));
            model.setSize (rs.getString ("boxSize"));
            model.setQuantity (rs.getString ("quantity"));
            model.setPrice (rs.getString ("price"));
            model.setDone (rs.getBoolean ("done"));
            String fullDate = rs.getString ("compliteDate");
            if (fullDate.length () >= 10) {
                shortDate = fullDate.substring (0, 11);
            } else {
                shortDate = fullDate;
            }
            model.setCompliteDate (shortDate);
            model.setNote (rs.getString ("note"));

            orderList.add (model);
        }
        return orderList;
    }

    public ObservableList<Order> getOrderList1mounth () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM ORDERS WHERE Date >= DATEADD(MONTH, -1, GETDATE())";
        ResultSet rs = DBUtil.dbExecuteQuery (selectStmt);
        ObservableList<Order> orderList = getFULLOrderList (rs);
        return orderList;
    }

    public ObservableList<Order> getOrderList3mounth () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM ORDERS WHERE Date >= DATEADD(MONTH, -3, GETDATE())";
        ResultSet rs = DBUtil.dbExecuteQuery (selectStmt);
        ObservableList<Order> orderList = getFULLOrderList (rs);
        return orderList;
    }

    public ObservableList<Order> getOrderList1Year () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM ORDERS WHERE Date >= DATEADD(YEAR, -1, GETDATE())";
        ResultSet rs = DBUtil.dbExecuteQuery (selectStmt);
        ObservableList<Order> orderList = getFULLOrderList (rs);
        return orderList;
    }

    public ObservableList<Order> getOrderList1Week () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM ORDERS WHERE Date >= DATEADD(WEEK, -1, GETDATE())";
        ResultSet rs = DBUtil.dbExecuteQuery (selectStmt);
        ObservableList<Order> orderList = getFULLOrderList (rs);
        return orderList;
    }


    public ObservableList<Order> getUnDoneOrderList () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM ORDERS WHERE done = FALSE";
        ResultSet rs = DBUtil.dbExecuteQuery (selectStmt);
        ObservableList<Order> orderList = getFULLOrderList (rs);
        return orderList;
    }

    public void setOrderDone ( ObservableList<Order> orderList ) throws SQLException, ClassNotFoundException {

        for (Order order : orderList) {
            int orderId = order.getIdOrder ();
            String selextStmt = "UPDATE PUBLIC.ORDERS SET  DONE=true, COMPLITEDATE=trunc(sysdate) WHERE IDORDER=" + orderId + "; ";
            DBUtil.dbExecuteUpdate (selextStmt);
        }

    }

    public void updateOrder ( Order order ) throws SQLException, ClassNotFoundException {

        String size = order.getSize ();
        String quantity = order.getQuantity ();
        String price = order.getPrice ();
        String note = order.getNote ();
        int orderId = order.getIdOrder ();

        String updateStmt = "UPDATE PUBLIC.ORDERS" +
                " SET BOXSIZE='" + size + "', QUANTITY='" + quantity + "', PRICE='" + price + "', NOTE='" + note + "' WHERE IDORDER='" + orderId + "';";
        DBUtil.dbExecuteUpdate (updateStmt);
    }


    public void deleteOrder ( Order order ) throws SQLException, ClassNotFoundException {

        int idOrder = order.getIdOrder ();

        String updateSmtp = "DELETE FROM PUBLIC.ORDERS WHERE IDORDER=" + idOrder + ";";
        DBUtil.dbExecuteUpdate (updateSmtp);

    }
}
