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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import lk.ijse.computerShop.navigation.Navigation;
import lk.ijse.computerShop.navigation.Routes;

import java.io.File;
import java.io.IOException;

public class LoginPageFormController {
    @FXML
    private MediaView mediaView;
    @FXML
    private AnchorPane loginPageAnchorPane;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private Text wrongPw;

    public void initialize() {
        // Create a media object by specifying the file path of the video
        String path = "C:\\IJSE\\First Semester\\OOP-[Object-Oriented Programming]\\MY PROJECTS\\template\\src\\main\\resources\\assets\\JARVIS START UP.mp4"; // Replace with the actual path to your video file
        Media media = new Media(new File(path).toURI().toString());

        // Create a MediaPlayer by passing the media
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaView.setFitWidth(1037); // Set the width
        mediaView.setFitHeight(600); // Set the height
        mediaView.setPreserveRatio(true); // Maintain the aspect ratio

        // Create a MediaView by passing the MediaPlayer
//            MediaView mediaView = new MediaView(mediaPlayer);
//
//            // Create a Group and add the MediaView to it
//            Group root = new Group(mediaView);
//
//            // Create a Scene and add the Group to it
//            Scene scene = new Scene(root, 600, 400);
//
//            // Set the title of the Stage and set the Scene to the Stage
//            Stage primaryStage=new Stage();
//            primaryStage.setTitle("JavaFX Video Player");
//            primaryStage.setScene(scene);
//
        // Play the video
        mediaPlayer.play();

        mediaPlayer.setOnEndOfMedia(() -> {
            // Media playback is over
          //  id.setText("Status: Playback Over");
            mediaView.setVisible(false);
        });


//
//            // Display the Stage
//            primaryStage.show();
    }


    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.LOGIN,loginPageAnchorPane);
    }

    @FXML
    void fogetPasswordOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void forgetPasswordOnMouseClicked(MouseEvent event) {

    }

}