package lk.ijse.computerShop.model;
/* 
    @author Sachi_S_Bandara
    @created 11/21/2023 - 8:50 PM 
*/

import lk.ijse.computerShop.db.DbConnection;
import lk.ijse.computerShop.dto.SellingOrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public void placeSellingOrder(SellingOrderDto sellingOrderDto) {


//            boolean result = false;
//            Connection connection=null;
//
//            try {
//                connection = DbConnection.getInstance().getConnection();
//                connection.setAutoCommit(false);
//
//
//                boolean isOrderSaved = SellingOrderModel.saveOrder();
//                if (isOrderSaved) {
//                    boolean isUpdated = RawMaterialModel.updateRawMaterial(placeOrderDto.getTmList());
//                    if(isUpdated) {
//                        boolean isOrderDetailSaved = OrderDetailModel.saveOrderDetail(placeOrderDto.getOrderId(), placeOrderDto.getTmList());
//                        if(isOrderDetailSaved) {
//                            connection.commit();
//                            result = true;
//                        }
//                    }
//                }
//            } catch (SQLException e) {
//                connection.rollback();
//            } finally {
//                connection.setAutoCommit(true);
//            }
//            return result;


    }

//    private static boolean saveOrder() {
//        try {
//            Connection connection = DbConnection.getInstance().getConnection();
//            String sql="";
//            PreparedStatement pstm = connection.prepareStatement(sql);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
