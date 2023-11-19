package lk.ijse.computerShop.model;
/* 
    @author Sachi_S_Bandara
    @created 11/19/2023 - 10:11 PM 
*/

import lk.ijse.computerShop.db.DbConnection;
import lk.ijse.computerShop.dto.AttendenceDto;

import java.sql.*;

public class AttendenceModel {
    public boolean saveAttendence(AttendenceDto attendenceDto) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql="insert into attendence values (?,?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setObject(1,attendenceDto.getAttendenceID());
            pstm.setObject(2,attendenceDto.getDate());
            pstm.setObject(3,attendenceDto.getInTime());
            pstm.setObject(4,attendenceDto.getOutTime());
            pstm.setObject(5,attendenceDto.getOtHours());
            pstm.setObject(6,attendenceDto.getEmpID());

            boolean b = pstm.executeUpdate() > 0;
            return b;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String genarateId() {  try {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql="SELECT attendenceID FROM attendence ORDER BY attendenceID DESC LIMIT 1";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        String currentAttendenceId = null;

        if(resultSet.next()) {
            currentAttendenceId= resultSet.getString(1);
            return splitOrderId(currentAttendenceId);
        }
        return splitOrderId(null);

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    private String splitOrderId(String currentCusId) {
        if(currentCusId != null) {
            String[] split = currentCusId.split("c");
            int id = Integer.parseInt(split[1]);    //008
            id ++;  //9
            // return "c00" + id;
            return String.format("c%03d", id); // Formats the integer with leading zeros
        }
        return "c001";
    }

    public String checkIsLeaved(String text, Date valueOf) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql=" SELECT OUTTIME FROM ATTENDENCE WHERE EMPID=?&& DATE=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1,text);
            pstm.setObject(2,valueOf);

            ResultSet resultSet = pstm.executeQuery();
            String check=null;
            if (resultSet.next()){
                 check = resultSet.getString(1);

            }
            return check;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public boolean updateOutTime(String text, Date valueOf, Double valueOf1) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql="update ATTENDENCE set outTime=? where EMPID=?&& DATE=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1,valueOf1);
            pstm.setObject(2,text);
            pstm.setObject(3,valueOf);

            boolean b = pstm.executeUpdate() > 0;
            return b;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//    public void checkIsAdmited(String text, Date valueOf) {
//        try {
//            Connection connection = DbConnection.getInstance().getConnection();
//            String sql="select empID from attendence where date =?";
//            PreparedStatement pstm = connection.prepareStatement(sql);
//            pstm.setObject(1,valueOf);
//            ResultSet resultSet = pstm.executeQuery();
//
//            if (resultSet.next()){
//                System.out.println(resultSet.getString(1) );;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}

