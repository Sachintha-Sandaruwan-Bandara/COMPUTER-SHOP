package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/14/2023 - 7:17 PM 
*/

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class SupplierRowFormController {
    @FXML
    public JFXButton btnClear;
    @FXML
    public Label address;
    @FXML
    public Label email;

    @FXML
    public Label id;

    @FXML
    public Label mobile;

    @FXML
    public Label name;

    @FXML
    private Pane colourPane;

    public Pane getColourPane() {
        return colourPane;
    }

    @FXML
    private Pane row;


    public Pane getRow() {
        return row;
    }


    public void setAddress(String address) {
        this.address.setText(address);
    }

    public void setEmail(String email) {
        this.email.setText(email);
    }

    public void setId(String id) {
        this.id.setText(id);
    }

    public void setMobile(String mobile) {
        this.mobile.setText(mobile);
    }

    public void setName(String name) {
        this.name.setText(name);
    }
    public JFXButton getClear(){
        return this.btnClear;
    }

    public void initialize(){
//    ArrayList<EmployeeDto> allEmployees = new EmployeeModel().getAllEmployees();
//
//    for (int i = 0; i <allEmployees.size(); i++) {
//
//        id.setText(allEmployees.get(i).getId());
//        name.setText(allEmployees.get(i).getName());
//        address.setText(allEmployees.get(i).getAddress());
//        mobile.setText(allEmployees.get(i).getMobile());
//        email.setText(allEmployees.get(i).getEmail());
//
//
//
//    }

}
    @FXML
    void btnClearOnAction(ActionEvent event) {
        SupplierFormController.action(event);
    }

}
