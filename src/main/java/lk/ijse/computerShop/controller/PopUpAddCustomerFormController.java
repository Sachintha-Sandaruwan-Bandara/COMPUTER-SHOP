package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 7:49 PM 
*/
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.computerShop.dto.CustomerDto;
import lk.ijse.computerShop.model.CustomerModel;

import java.io.IOException;

public class PopUpAddCustomerFormController {
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

        private CustomerFormController customerFormController;
        public void initialize(){
                this.customerFormController=CustomerFormController.customerFormController;
                customerFormController.btnAddCustomer.setDisable(true);
                customerFormController.tblCustomer.setDisable(true);
        }

        @FXML
        void btnCancelOnAction(ActionEvent event) {

        }

        @FXML
        void btnSaveOnAction(ActionEvent event) {
                String id = txtId.getText();
                String name = txtName.getText();
                String address = txtAddress.getText();
                String mobile = txtMobile.getText();
                String email = txtEmail.getText();

                CustomerDto customerDto = new CustomerDto(id, name, address,email, mobile);

                CustomerModel customerModel = new CustomerModel();
                boolean isSaved = customerModel.saveCustomer(customerDto);

                if (isSaved){
                        System.out.println("customer saved!!");
                       customerFormController.loadAllCustomers();
                       customerFormController.btnAddCustomer.setDisable(false);
                       customerFormController.tblCustomer.setDisable(false);

                        Stage stage = (Stage) txtName.getScene().getWindow();
                        stage.close();

                }else {
                        System.out.println("not saved!!");
                }
        }

}
