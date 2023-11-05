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
import lk.ijse.computerShop.navigation.Navigation;
import lk.ijse.computerShop.navigation.Routes;

import java.io.IOException;

public class EmployeeFormController {

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

}