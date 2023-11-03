package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 7:48 PM 
*/
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.computerShop.dto.CustomerDto;
import lk.ijse.computerShop.dto.tm.CustomerTm;
import lk.ijse.computerShop.model.CustomerModel;
import lk.ijse.computerShop.navigation.Navigation;
import lk.ijse.computerShop.navigation.Routes;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerFormController {
        @FXML
        private TableColumn<?, ?> colAction;

        @FXML
        private TableColumn<?, ?> colAddress;

        @FXML
        private TableColumn<?, ?> colEmail;

        @FXML
        private TableColumn<?, ?> colId;

        @FXML
        private TableColumn<?, ?> colMobile;

        @FXML
        private TableColumn<?, ?> colName;

        @FXML
        private TableView<CustomerTm> tblCustomer;

       public void initialize(){
               loadAllCustomers();
               setCellValueFactory();
       }

    private void setCellValueFactory() {
           colId.setCellValueFactory(new PropertyValueFactory<>("id"));
           colName.setCellValueFactory(new PropertyValueFactory<>("name"));
           colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
           colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
           colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    }

    private void loadAllCustomers() {
               var model=new CustomerModel();

            ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

            ArrayList<CustomerDto> dtoList = model.getAllCustomers();
            for (CustomerDto dto:dtoList) {
                obList.add(
                        new CustomerTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getAddress(),
                                dto.getEmail(),
                                dto.getMobile()
                        )
                );
            }
            tblCustomer.setItems(obList);

        }

        @FXML
        void btnAddCustomerOnAction(ActionEvent event) throws IOException {
                Navigation.navigatePopUpWindow(Routes.ADDCUSTOMER);
        }
        
        

}
