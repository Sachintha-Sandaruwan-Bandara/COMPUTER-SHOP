package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/11/2023 - 8:28 PM 
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lk.ijse.computerShop.dto.EmployeeDto;
import lk.ijse.computerShop.model.EmployeeModel;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.ArrayList;

public class SupplierFormController {
    @FXML
    private Label lblAddress;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblId;

    @FXML
    private Label lblMobile;

    @FXML
    private Label lblName;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    public VBox vBox;

    @FXML
    private TextField searchTxt;

    ArrayList<Object> rows = new ArrayList<>();
    public void initialize() throws IOException {
        loadc();
         scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    }

    private void loadc() throws IOException {

        ArrayList<EmployeeDto> allEmployees = new EmployeeModel().getAllEmployees();
        for (int i = 0; i <allEmployees.size(); i++) {

        VBox vb = new VBox(); // Create a new VBox to hold the records
        vb.setSpacing(20);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/supplierRowForm.fxml"));
        SupplierRowFormController supplierRowFormController = new SupplierRowFormController();
        fxmlLoader.setController(supplierRowFormController);
        Node node = fxmlLoader.load();
        VBox.setMargin(node, new Insets(5, 5, 5, 5));


        String id=allEmployees.get(i).getId();
       supplierRowFormController.setId(allEmployees.get(i).getId());
       supplierRowFormController.setName(allEmployees.get(i).getName());
       supplierRowFormController.setAddress(allEmployees.get(i).getAddress());
       supplierRowFormController.setMobile(allEmployees.get(i).getMobile());
       supplierRowFormController.setEmail (allEmployees.get(i).getEmail());
            JFXButton clear = supplierRowFormController.getClear();
            Pane row = supplierRowFormController.getRow();
            Pane colourPane = supplierRowFormController.getColourPane();
            row.setId(id);

            rows.add(row);

            clear.setOnAction(actionEvent -> {
                System.out.println("cleard");
                new EmployeeModel().deleteEmployee(id);
            vb.getChildren().clear();
            });
            row.setOnMouseClicked(mouseEvent -> {
                colourPane.setStyle("-fx-background-color: white;-fx-border-radius: 20;-fx-background-radius: 20;");

                System.out.println(row.getId());

                EmployeeDto employee = new EmployeeModel().getEmployee(row.getId());

                lblId.setText(employee.getId());
                lblName.setText(employee.getName());
                lblAddress.setText(employee.getAddress());
                lblEmail.setText(employee.getEmail());
                lblMobile.setText(employee.getMobile());

            });
            row.setOnMouseEntered(mouseEvent -> {
               colourPane.setStyle("-fx-background-color: rgba(0,0,0,0.23);-fx-border-radius: 20;-fx-background-radius: 20;");


            });
            row.setOnMouseExited(mouseEvent -> {
                colourPane.setStyle("-fx-background-color:white;-fx-border-radius: 20;-fx-background-radius: 20;");



            });





            vb.getChildren().add(node);
            vBox.getChildren().add(vb);
    }

        searchTxt.setOnKeyReleased(keyEvent -> {
            EmployeeDto employee = new EmployeeModel().getEmployee(searchTxt.getText());

            lblId.setText(employee.getId());
            lblName.setText(employee.getName());
            lblAddress.setText(employee.getAddress());
            lblEmail.setText(employee.getEmail());
            lblMobile.setText(employee.getMobile());
        });


    }

    @FXML
    void addSupplierOnAction(ActionEvent event) throws IOException {


        VBox vb = new VBox(); // Create a new VBox to hold the records
        vb.setSpacing(20);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/supplierRowForm.fxml"));
        Node node = fxmlLoader.load();
        VBox.setMargin(node, new Insets(5, 5, 5, 5));
        vb.getChildren().add(node);
        vBox.getChildren().add(vb);


    }
public static void action(ActionEvent event){
    System.out.println("clear");
}
    @FXML
    void searchOnAction(ActionEvent event) {



    }
}

