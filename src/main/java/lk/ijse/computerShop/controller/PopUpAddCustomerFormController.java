package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 7:49 PM 
*/
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.computerShop.Alert;
import lk.ijse.computerShop.dto.CustomerDto;
import lk.ijse.computerShop.model.CustomerModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

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

        public void initialize(){
                setCusId();

        }

        private void setCusId() {
                String lastCustomerId = new CustomerModel().getLastCustomerId();
                txtId.setText(lastCustomerId);
                txtId.setEditable(false);
        }


        @FXML
        void btnCancelOnAction(ActionEvent event) {

        }

        @FXML
        void btnSaveOnAction(ActionEvent event) throws IOException {

                validateAndFlash(txtName, "([a-zA-Z\\s]+)");
                validateAndFlash(txtAddress, "([a-zA-Z0-9\\s]+)");
                validateAndFlash(txtMobile, "[0-9]{10}");
                validateAndFlash(txtEmail,"^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");





                String id = txtId.getText();
                String name = txtName.getText();
                String address = txtAddress.getText();
                String mobile = txtMobile.getText();
                String email = txtEmail.getText();

                HashMap map = new HashMap<>();
                map.put("ID", id);
                map.put("NAME", name);
                map.put("ADDRESS", address);
                map.put("MOBILE", mobile);
                map.put("EMAIL", email);

                try {
                        JasperDesign load = JRXmlLoader.load(this.getClass().getResourceAsStream("/view/reports/customer.jrxml"));
                        JasperReport jasperReport = JasperCompileManager.compileReport(load);
                        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JREmptyDataSource());
                        JasperViewer.viewReport(jasperPrint, false);


                } catch (JRException e) {
                        throw new RuntimeException(e);}





//
//
//                CustomerDto customerDto = new CustomerDto(id, name, address,email, mobile,imageBytes);
//
//                CustomerModel customerModel = new CustomerModel();
//                boolean isSaved = customerModel.saveCustomer(customerDto);
//
//                if (isSaved){
//                        System.out.println("customer saved!!");
//                     CustomerFormController.customerFormController.loadAllCustomers();
//                        new Alert().createAlert().show();
//
//
////                        Stage stage = (Stage) txtName.getScene().getWindow();
////                        stage.close();
//
//                }else {
//                        System.out.println("not saved!!");
//                }
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

                Stage stage = (Stage) txtName.getScene().getWindow();
                stage.close();
        }

        private boolean validateAndFlash(TextField textField, String regex) {
                boolean isValid = Pattern.matches(regex, textField.getText());
                if (!isValid) {
                        flashBorder(textField);
                }
                return isValid;
        }

        private void flashBorder(TextField textField) {
                textField.setStyle("-fx-border-color: #000000;-fx-background-color: rgba(255,0,0,0.13)");


                setBorderResetAnimation(textField);
        }

        private void setBorderResetAnimation(TextField textField) {
//                double closeAfterSeconds = 0.5;
//
//                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(closeAfterSeconds), event -> {
//                        textField.setStyle("-fx-border-color: gray");
//                }));
//
//                timeline.play();

                Timeline timeline1 = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(textField.styleProperty(), "-fx-background-color:rgba(255,0,0,0.13);-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10")),
                        new KeyFrame(Duration.seconds(0.1), new KeyValue(textField.styleProperty(), "-fx-background-color: white;-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10")),
                        new KeyFrame(Duration.seconds(0.2), new KeyValue(textField.styleProperty(), "-fx-background-color:rgba(255,0,0,0.13);-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10")),
                        new KeyFrame(Duration.seconds(0.3), new KeyValue(textField.styleProperty(), "-fx-background-color: white;-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10")),
                        new KeyFrame(Duration.seconds(0.4), new KeyValue(textField.styleProperty(), "-fx-background-color:rgba(255,0,0,0.13);-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10")),
                        new KeyFrame(Duration.seconds(0.5), new KeyValue(textField.styleProperty(), "-fx-background-color: white;-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10"))
                );
                timeline1.play();
        }



}
