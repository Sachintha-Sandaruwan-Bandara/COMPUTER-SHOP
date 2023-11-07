package lk.ijse.computerShop.controller;
/* 
    @author Sachi_S_Bandara
    @created 11/7/2023 - 12:52 AM 
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.computerShop.navigation.Navigation;
import lk.ijse.computerShop.navigation.Routes;
import java.io.IOException;

public class LoginPageFormController {

    @FXML
    private AnchorPane loginPageAnchorPane;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private Text wrongPw;


    public void initialize() {
        introVideo();

    }

    private void introVideo() {


    }


    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,loginPageAnchorPane);
    }

    @FXML
    void fogetPasswordOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void forgetPasswordOnMouseClicked(MouseEvent event) {

    }

}