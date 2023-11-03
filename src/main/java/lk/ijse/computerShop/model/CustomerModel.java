package lk.ijse.computerShop.model;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 8:38 PM 
*/

import lk.ijse.computerShop.db.DbConnection;
import lk.ijse.computerShop.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    public boolean saveCustomer(CustomerDto customerDto) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql="insert into customer values (?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setObject(1,customerDto.getId());
            pstm.setObject(2,customerDto.getName());
            pstm.setObject(3,customerDto.getAddress());
            pstm.setObject(4,customerDto.getEmail());
            pstm.setObject(5,customerDto.getMobile());

            boolean b = pstm.executeUpdate() > 0;
            return b;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<CustomerDto> getAllCustomers() {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql="select * from customer";
            PreparedStatement pstm = connection.prepareStatement(sql);

            ArrayList<CustomerDto> dtoList = new ArrayList<>();

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String email = resultSet.getString(4);
                int mobile = resultSet.getInt(5);

                CustomerDto customerDto = new CustomerDto(id, name, address, email, mobile);
                dtoList.add(customerDto);
            }
            return dtoList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
