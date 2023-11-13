package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 7:40 PM 
*/

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.computerShop.navigation.Navigation;
import lk.ijse.computerShop.navigation.Routes;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashboardFormController {

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblTimeMini;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private AnchorPane subAnchorPane;

    public void initialize() {
        generateRealTime();
    }

    @FXML
    void btnAttendenceOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ATTENDANCE, subAnchorPane);
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CUSTOMER, subAnchorPane);
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, mainAnchorPane);
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE, subAnchorPane);
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ITEM, subAnchorPane);
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrderOnAction(ActionEvent event) throws IOException {

        Navigation.navigatePopUpWindow(Routes.PLACEORDERSELECT);
    }

    @FXML
    void btnSalaryOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SALARY, subAnchorPane);
    }

    @FXML
    void btnServiceOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SERVICE, subAnchorPane);
    }

    @FXML
    void btnSettingOnAction(ActionEvent event) {

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SUPPLIER, subAnchorPane);
    }

    /*-----DATE AND TIME GENERATE------*/
    private void generateRealTime() {
        lblDate.setText(LocalDate.now().toString());
        Timeline timeline = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            lblTimeMini.setText(LocalDateTime.now().format(formatter));
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}

