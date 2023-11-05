package lk.ijse.computerShop.model;
/* 
    @author Sachi_S_Bandara
    @created 11/5/2023 - 2:08 PM 
*/

import lk.ijse.computerShop.db.DbConnection;
import lk.ijse.computerShop.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeModel {
    public boolean saveEmployee(EmployeeDto employeeDto) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();

            String sql="insert  into employee values (?,?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setObject(1, employeeDto.getId());
            pstm.setObject(2, employeeDto.getName());
            pstm.setObject(3, employeeDto.getAddress());
            pstm.setObject(4, employeeDto.getEmail());
            pstm.setObject(5, employeeDto.getMobile());
            pstm.setObject(6, employeeDto.getPosition());

            boolean b = pstm.executeUpdate() > 0;
            return b;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
