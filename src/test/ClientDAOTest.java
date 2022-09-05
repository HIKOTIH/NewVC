package test;

import com.magdi.stair.models.Client;
import com.magdi.stair.dao.ClientInterface;
import com.magdi.stair.dao.impl.ClientDAO;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class ClientDAOTest {

    @Test
    public void getClientByID() throws SQLException, ClassNotFoundException {
        ClientInterface CI = new ClientDAO();
        int testId = 2;
        Client testModel = CI.getClientByID(testId);
        if (testModel.getIdClient()!=testId)Assert.fail("wrong ID");

    }
}