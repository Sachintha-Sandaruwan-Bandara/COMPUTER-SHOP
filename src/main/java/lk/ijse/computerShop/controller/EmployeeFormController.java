package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/5/2023 - 1:32 PM 
*/

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lk.ijse.computerShop.dto.EmployeeDto;
import lk.ijse.computerShop.dto.tm.CustomerTm;
import lk.ijse.computerShop.dto.tm.EmployeeTm;
import lk.ijse.computerShop.model.CustomerModel;
import lk.ijse.computerShop.model.EmployeeModel;
import lk.ijse.computerShop.navigation.Navigation;
import lk.ijse.computerShop.navigation.Routes;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeFormController {


    @FXML
    private Text address;
    @FXML
    private Text email;

    @FXML
    private Text id;

    @FXML
    private ImageView imgView;

    @FXML
    private Text mobile;

    @FXML
    private Text name;

    @FXML
    private TextField searchId;

    @FXML
    public JFXButton btnAddEmployee;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private TableColumn<?, ?> colEdit;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colMobile;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPosition;

    @FXML
    public TableView<EmployeeTm> tblEmployee;

    public static EmployeeFormController employeeFormController;

    public void initialize(){
        employeeFormController=this;
        loadAllEmployees();
        setCellValueFactory();
        addButtonsToTable();
    }

    private void addButtonsToTable() {

        TableColumn<EmployeeTm, JFXButton> editCol = (TableColumn<EmployeeTm, JFXButton>) tblEmployee.getColumns().get(6);

        editCol.setCellValueFactory(param -> {
            JFXButton btnEdit = new JFXButton("       ");
            btnEdit.setCursor(Cursor.HAND);
            Font font = Font.font("Courier New", FontWeight.BOLD, 14);
            btnEdit.setFont(font);
            btnEdit.setStyle("-fx-graphic: url(/icons/edit.png)");


            btnEdit.setOnAction(event -> {
               String updateEmployeeId = param.getValue().getId();
                try {

                    Navigation.navigatePopUpWindow(Routes.UPDATEEMPLOYEE);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            });
            return new ReadOnlyObjectWrapper<>(btnEdit);
        });
        TableColumn<EmployeeTm, JFXButton> deleteCol = (TableColumn<EmployeeTm, JFXButton>) tblEmployee.getColumns().get(7);

        deleteCol.setCellValueFactory(param -> {
            JFXButton btnDelete = new JFXButton("       ");
            btnDelete.setCursor(Cursor.HAND);
            Font font = Font.font("Courier New", FontWeight.BOLD, 14);
            btnDelete.setFont(font);
            //btnDelete.setStyle("-fx-background-color: white");
            btnDelete.setStyle("-fx-graphic: url(/icons/delete.png)");

            btnDelete.setOnAction(event -> {
                String id = param.getValue().getId();
                CustomerModel customerModel = new CustomerModel();
                boolean isDeleted = customerModel.deleteCustomer(id);

                if (isDeleted) {
                    System.out.println("customer deleted Successfully!!");

                } else {
                    System.out.println("something went wrong !!");
                }


            });
            return new ReadOnlyObjectWrapper<>(btnDelete);
        });

    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colEdit.setCellValueFactory(new PropertyValueFactory<>("btnEdit"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
    }

    private void loadAllEmployees() {
        ArrayList<EmployeeDto> allEmployees = new EmployeeModel().getAllEmployees();

        ObservableList<EmployeeTm> obList = FXCollections.observableArrayList();


        for (EmployeeDto dto : allEmployees) {
            obList.add(
                    new EmployeeTm(
                            dto.getId(),
                            dto.getName(),
                            dto.getAddress(),
                            dto.getEmail(),
                            dto.getMobile(),
                            dto.getPosition()

                    )
            );
        }
        tblEmployee.setItems(obList);
    }

    @FXML
    void btnAddEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.navigatePopUpWindow(Routes.ADDEMPLOYEE);
    }
    @FXML
    void btnSearchOnAction(ActionEvent event) {
        clear();
        EmployeeModel employeeModel = new EmployeeModel();
        EmployeeDto employee = employeeModel.getEmployee(searchId.getText());

        id.setText(employee.getId());
        name.setText(employee.getName());
        address.setText(employee.getAddress());
        email.setText(employee.getEmail());
        mobile.setText(String.valueOf(employee.getMobile()));

        Image image = new Image(new ByteArrayInputStream(employee.getImageBytes()));
        imgView.setImage(image);
        imgView.fitHeightProperty();
        imgView.fitWidthProperty();
        Circle clip = new Circle(100,100,100);
        imgView.setClip(clip);
        imgView.setFitWidth(200); // Set the desired width of the circular image
        imgView.setFitHeight(200);

    }
    private void clear() {
        id.setText(null);
        name.setText(null);
        address.setText(null);
        email.setText(null);
        mobile.setText(null);
        imgView.setImage(null);
    }

    @FXML
    void searchIdOnAction(ActionEvent event) {
        btnSearchOnAction(event);
    }
}