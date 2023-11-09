package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/5/2023 - 1:32 PM 
*/

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import lk.ijse.computerShop.dto.EmployeeDto;
import lk.ijse.computerShop.model.EmployeeModel;
import lk.ijse.computerShop.navigation.Navigation;
import lk.ijse.computerShop.navigation.Routes;

import java.io.ByteArrayInputStream;
import java.io.IOException;

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
    public TableView<?> tblEmployee;

    public static EmployeeFormController employeeFormController;

    public void initialize(){
        employeeFormController=this;
        loadAllEmployees();
        setCellValueFactory();
        addButtonsToTable();
    }

    private void addButtonsToTable() {
    }

    private void setCellValueFactory() {
        
    }

    private void loadAllEmployees() {
        
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