package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/5/2023 - 1:48 PM 
*/

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.ijse.computerShop.model.EmployeeModel;

public class PopUpUpdateEmployeeFormController {

    @FXML
    private JFXButton btnSave;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPosition;

    private EmployeeFormController employeeFormController;

    public void initialize(){
        employeeFormController=EmployeeFormController.employeeFormController;
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {


    }

}