package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 7:40 PM 
*/

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.ijse.computerShop.navigation.Navigation;
import lk.ijse.computerShop.navigation.Routes;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashboardFormController {
    @FXML
    private JFXToggleButton darkMode;
    @FXML
    private Pane detail1;

    @FXML
    private Pane detail2;
    @FXML
    private Pane bgclrPane;
    @FXML
    private Pane detail3;

    @FXML
    private Pane detail4;

    @FXML
    private Pane detail5;
    @FXML
    private JFXComboBox<String> orderComb;
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
        ObservableList<String> options = FXCollections.observableArrayList(
                "SELLING ORDER",
                "BUYING ORDER"
        );
        orderComb.setItems(options);
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
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.LOGIN, mainAnchorPane);
    }

    @FXML
    void combOrderOnAction(ActionEvent event) throws IOException {
        if (orderComb.getValue().equals("BUYING ORDER")) {
            Navigation.navigate(Routes.BUYINGORDER, subAnchorPane);

        } else if (orderComb.getValue().equals("SELLING ORDER")) {
            Navigation.navigate(Routes.SELLINGORDER, subAnchorPane);

        }
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
    void btnSettingOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SETTING, subAnchorPane);
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

        detail1.setOnMouseEntered(event -> {
            bgclrPane.setStyle("-fx-background-color: rgba(250,177,160,0.25);");
            lblTimeMini.setStyle("-fx-text-fill:white;");

        });

        // Add mouse exited event handler
        detail1.setOnMouseExited(event -> {
            //       subAnchorPane.setStyle("-fx-background-color: #ffffff;");
        });
        detail2.setOnMouseEntered(event -> {
            bgclrPane.setStyle("-fx-background-color: rgba(85,239,196,0.26);");
        });

        // Add mouse exited event handler
        detail2.setOnMouseExited(event -> {
            //      subAnchorPane.setStyle("-fx-background-color: #ffffff;");
        });
        detail3.setOnMouseEntered(event -> {
            bgclrPane.setStyle("-fx-background-color: rgba(129,236,236,0.25);");
        });

        // Add mouse exited event handler
        detail3.setOnMouseExited(event -> {
            //     subAnchorPane.setStyle("-fx-background-color: #ffffff;");
        });
        detail4.setOnMouseEntered(event -> {
            bgclrPane.setStyle("-fx-background-color: rgba(116,185,255,0.26);");
        });

        // Add mouse exited event handler
        detail4.setOnMouseExited(event -> {
            //      subAnchorPane.setStyle("-fx-background-color: #ffffff;");
        });
        detail5.setOnMouseEntered(event -> {
            bgclrPane.setStyle("-fx-background-color: rgba(162,155,254,0.22);");
        });

        // Add mouse exited event handler
        detail5.setOnMouseExited(event -> {
            //     subAnchorPane.setStyle("-fx-background-color: #ffffff;");
        });
        darkMode.setOnAction(event -> {
            if (darkMode.isSelected()) {
                System.out.println("Toggle button is ON");
                subAnchorPane.setStyle("-fx-background-color: rgb(44,62,80);");

            } else {
                System.out.println("Toggle button is OFF");
                subAnchorPane.setStyle("-fx-background-color: rgb(255,255,255);");
            }
        });
    }

}

