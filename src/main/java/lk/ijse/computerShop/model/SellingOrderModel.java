package lk.ijse.computerShop.model;
/* 
    @author Sachi_S_Bandara
    @created 11/21/2023 - 8:50 PM 
*/

import lk.ijse.computerShop.db.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellingOrderModel {
    public String generateNextOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT soID FROM sellingOrder ORDER BY soID DESC LIMIT 1";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        String currentOrderId = null;

        if(resultSet.next()) {
            currentOrderId = resultSet.getString(1);
            return splitOrderId(currentOrderId);
        }
        return splitOrderId(null);
    }

    private String splitOrderId(String currentOrderId) {    //O008
        if(currentOrderId != null) {
            String[] split = currentOrderId.split("O");
            int id = Integer.parseInt(split[1]);    //008
            id ++;  //9
            return "O00" + id;
        }
        return "O001";
    }
}
