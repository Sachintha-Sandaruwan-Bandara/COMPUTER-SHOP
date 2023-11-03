package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 7:49 PM 
*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.ijse.computerShop.dto.CustomerDto;
import lk.ijse.computerShop.model.CustomerModel;

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

                CustomerDto customerDto = new CustomerDto(id, name, address,email, Integer.valueOf(mobile));

                CustomerModel customerModel = new CustomerModel();
                boolean isSaved = customerModel.saveCustomer(customerDto);

                if (isSaved){
                        System.out.println("customer saved!!");
                }else {
                        System.out.println("not saved!!");
                }
        }

}
