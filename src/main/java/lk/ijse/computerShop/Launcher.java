package lk.ijse.computerShop;
/* 
    @author Sachi_S_Bandara
    @created 11/3/2023 - 6:54 PM 
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Launcher.class.getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(root);
       // stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
    }
}
