package com.gumenniy.stair.dao;


import com.gumenniy.stair.models.Order;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface OrderInterface {
    void insertOrder ( Order order ) throws SQLException, ClassNotFoundException;

    ObservableList<Order> getOrderList () throws SQLException, ClassNotFoundException;

    ObservableList<Order> getOrderList1mounth () throws SQLException, ClassNotFoundException;

    ObservableList<Order> getOrderList3mounth () throws SQLException, ClassNotFoundException;

    ObservableList<Order> getOrderList1Year () throws SQLException, ClassNotFoundException;

    ObservableList<Order> getOrderList1Week () throws SQLException, ClassNotFoundException;

    ObservableList<Order> getUnDoneOrderList () throws SQLException, ClassNotFoundException;

    void setOrderDone ( ObservableList<Order> order ) throws SQLException, ClassNotFoundException;

    void updateOrder ( Order order ) throws SQLException, ClassNotFoundException;

    void deleteOrder ( Order order ) throws SQLException, ClassNotFoundException;
}
