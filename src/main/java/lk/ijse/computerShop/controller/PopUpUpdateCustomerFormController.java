package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 7:50 PM 
*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.computerShop.dto.CustomerDto;
import lk.ijse.computerShop.model.CustomerModel;

public class PopUpUpdateCustomerFormController {
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

        private String updateCustomerId;

        public void initialize(){
                updateCustomerId = CustomerFormController.customerFormController.updateCustomerId;
                loadCustomerDetails( updateCustomerId);
        }

        private void loadCustomerDetails(String  updateCustomerId) {
                CustomerModel customerModel = new CustomerModel();
            CustomerDto customer = customerModel.getCustomer(updateCustomerId);
            txtId.setText(customer.getId());
            txtId.setEditable(false);
            txtName.setText(customer.getName());
            txtAddress.setText(customer.getAddress());
            txtEmail.setText(customer.getEmail());
            txtMobile.setText(String.valueOf(customer.getMobile()));
        }

        @FXML
        void btnCancelOnAction(ActionEvent event) {
                     clear();
        }

        @FXML
        void btnSaveOnAction(ActionEvent event) {
           var dto= new CustomerDto(
                    txtId.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    txtEmail.getText(),
                    Integer.parseInt(txtMobile.getText())
            );
            CustomerModel customerModel = new CustomerModel();
            boolean isUpdated = customerModel.updateCustomer(dto);
            if (isUpdated){
                System.out.println("customer Updated Successfully!!!");
                CustomerFormController.customerFormController.loadAllCustomers();
                Stage stage = (Stage) txtName.getScene().getWindow();
                stage.close();
            }else{
                System.out.println("something went wrong!!");
            }
        }

        private void clear(){
            txtId.clear();
            txtName.clear();
            txtAddress.clear();
            txtEmail.clear();
            txtMobile.clear();
        }

}
