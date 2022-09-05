package test;

import com.gumenniy.stair.models.Order;
import com.gumenniy.stair.dao.impl.OrderDAO;
import javafx.collections.ObservableList;
import org.junit.Assert;

import java.sql.SQLException;

public class OrderDAOTest {

    @org.junit.Test
    public void getOrderList() throws SQLException, ClassNotFoundException {
        ObservableList<Order> orderList;
        OrderDAO OD = new OrderDAO();
        orderList = OD.getOrderList();
        if (orderList == null)Assert.fail();

    }
}