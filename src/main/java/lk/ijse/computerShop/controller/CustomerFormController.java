package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 7:48 PM 
*/
import com.jfoenix.controls.JFXButton;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lk.ijse.computerShop.dto.CustomerDto;
import lk.ijse.computerShop.dto.tm.CustomerTm;
import lk.ijse.computerShop.model.CustomerModel;
import lk.ijse.computerShop.navigation.Navigation;
import lk.ijse.computerShop.navigation.Routes;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerFormController {
          @FXML
          private TableColumn<?, ?> colDelete;
          @FXML
          private TableColumn<?, ?> colEdit;

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
        public TableView<CustomerTm> tblCustomer;

        public static CustomerFormController customerFormController;
        public static CustomerDto dto;

        public String updateCustomerId;

       public void initialize(){
           customerFormController=this;
               loadAllCustomers();
               setCellValueFactory();
               addButtonsToTable();

       }

    private void addButtonsToTable() {

        TableColumn<CustomerTm, JFXButton> editCol= (TableColumn<CustomerTm, JFXButton>) tblCustomer.getColumns().get(5);

        editCol.setCellValueFactory(param -> {
            JFXButton btnEdit = new JFXButton("       ");
            btnEdit.setCursor(Cursor.HAND);
            Font font = Font.font("Courier New", FontWeight.BOLD, 14);
            btnEdit.setFont(font);
            btnEdit.setStyle("-fx-graphic: url(/icons/edit.png)");


            btnEdit.setOnAction(event -> {
                updateCustomerId = param.getValue().getId();
                try {

                    Navigation.navigatePopUpWindow(Routes.UPDATECUSTOMER);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            });
            return new ReadOnlyObjectWrapper<>(btnEdit);
        });

        TableColumn<CustomerTm, JFXButton> deleteCol = (TableColumn<CustomerTm, JFXButton>) tblCustomer.getColumns().get(6);

        deleteCol.setCellValueFactory(param -> {
            JFXButton btnDelete=new JFXButton("       ");
            btnDelete.setCursor(Cursor.HAND);
            Font font = Font.font("Courier New", FontWeight.BOLD, 14);
            btnDelete.setFont(font);
            //btnDelete.setStyle("-fx-background-color: white");
            btnDelete.setStyle("-fx-graphic: url(/icons/delete.png)");

            btnDelete.setOnAction(event -> {
                String id = param.getValue().getId();
                CustomerModel customerModel = new CustomerModel();
                boolean isDeleted = customerModel.deleteCustomer(id);

                if (isDeleted){
                    System.out.println("customer deleted Successfully!!");
                    loadAllCustomers();
                }else {
                    System.out.println("something went wrong !!");
                }


            });
            return new ReadOnlyObjectWrapper<>(btnDelete);
        });

    }

    public void setCellValueFactory() {
           colId.setCellValueFactory(new PropertyValueFactory<>("id"));
           colName.setCellValueFactory(new PropertyValueFactory<>("name"));
           colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
           colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
           colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
           colEdit.setCellValueFactory(new PropertyValueFactory<>("btnEdit"));
           colDelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));


    }

    public void loadAllCustomers() {
               var model=new CustomerModel();
        ArrayList<CustomerDto> dtoList = model.getAllCustomers();

        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();


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
