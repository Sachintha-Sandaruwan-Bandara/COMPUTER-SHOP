package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/11/2023 - 8:28 PM 
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lk.ijse.computerShop.dto.EmployeeDto;
import lk.ijse.computerShop.model.EmployeeModel;

import java.io.IOException;
import java.util.ArrayList;

public class SupplierFormController {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    public VBox vBox;

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

            clear.setOnAction(actionEvent -> {
                System.out.println("cleard");
                new EmployeeModel().deleteEmployee(id);
            vb.getChildren().clear();
            });






            vb.getChildren().add(node);
            vBox.getChildren().add(vb);
    }







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
}

