package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/5/2023 - 1:46 PM 
*/

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.computerShop.dto.EmployeeDto;
import lk.ijse.computerShop.model.EmployeeModel;

public class PopUpAddEmployeeFormController {

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
    private EmployeeFormController empCon;

    public void initialize(){
        empCon=EmployeeFormController.employeeFormController;
        empCon.btnAddEmployee.setDisable(true);
        empCon.tblEmployee.setDisable(true);
    }
    @FXML
    void btnCancelOnAction(ActionEvent event) {
        clear();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        EmployeeDto employeeDto = new EmployeeDto(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtEmail.getText(),
                Integer.parseInt(txtMobile.getText()),
                txtPosition.getText()
        );

        EmployeeModel employeeModel = new EmployeeModel();

        boolean isSaved= employeeModel.saveEmployee(employeeDto);

        if (isSaved){
            System.out.println("Employee saved!!");
            clear();
            Stage stage = (Stage) txtName.getScene().getWindow();
            stage.close();
            empCon.btnAddEmployee.setDisable(false);
            empCon.tblEmployee.setDisable(false);
        }else {
            System.out.println("Employee not saved!!");
        }
    }

    private void clear(){
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtEmail.clear();
        txtMobile.clear();
        txtPosition.clear();
    }

}