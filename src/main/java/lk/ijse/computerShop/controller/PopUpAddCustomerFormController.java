package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 7:49 PM 
*/
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lk.ijse.computerShop.dto.CustomerDto;
import lk.ijse.computerShop.model.CustomerModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PopUpAddCustomerFormController {

        @FXML
        private AnchorPane ap;
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

        private byte [] imageBytes;
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


                CustomerDto customerDto = new CustomerDto(id, name, address,email, mobile,imageBytes);

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
        @FXML
        void btnIdImageAddOnAction(ActionEvent event) throws IOException {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open a file");
                fileChooser.setInitialDirectory(new File("C:\\"));
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG Image","*.jpg"), new FileChooser.ExtensionFilter("PNG Image", "*.png"), new FileChooser.ExtensionFilter("All image files","*.jpg","*.png"));

                Stage stage = (Stage) txtId.getScene().getWindow();
                File file = fileChooser.showOpenDialog(stage);
                System.out.println(file.getPath());

// image convert to byte array
                imageBytes = readImageToByteArray(file);

        }

        private byte[] readImageToByteArray(File file) throws IOException {
                try (FileInputStream fis = new FileInputStream(file);
                     ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = fis.read(buffer)) != -1) {
                                bos.write(buffer, 0, bytesRead);
                        }
                        return bos.toByteArray();
                }
        }

        @FXML
        void btnCloseOnAction(ActionEvent event) {
                customerFormController.btnAddCustomer.setDisable(false);
                customerFormController.tblCustomer.setDisable(false);
                Stage stage = (Stage) txtName.getScene().getWindow();
                stage.close();
        }
}
