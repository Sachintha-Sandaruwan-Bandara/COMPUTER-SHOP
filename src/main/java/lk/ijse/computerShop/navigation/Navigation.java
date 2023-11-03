package lk.ijse.computerShop.navigation;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 8:31 PM 
*/

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Navigation {
    public static void navigatePopUpWindow(Routes route) throws IOException {
        switch (route) {
            case ADDCUSTOMER:
                initPopUp("popUpAddCustomerForm");
                break;
            case UPDATECUSTOMER:
                initPopUp("popUpUpdateCustomerForm");
                break;


        }


    }

    private static void initPopUp(String url) throws IOException {

        Parent root = FXMLLoader.load(Navigation.class.getResource("/view/" + url+".fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();


    }
}
