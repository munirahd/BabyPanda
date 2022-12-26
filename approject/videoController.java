/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author munirhkhaled
 */
public class videoController implements Initializable {

    public Stage stage;
    public Scene scene;
    public Parent root;
    public Button nextButton;
    public Label WrongChoiesMessage1;
    public Label WrongChoiesMessage2;

    public MediaView mediaView;
    public Button playButton;
    public Button pauseButton;
    public File file;
    public Media media;
    public MediaPlayer mediaPlayer;

    @FXML

    public void handleHomeButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        file = new File("ABC_Song.mp4");

        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        System.out.println(file.exists());

    }

    public void playMedia() {

        mediaPlayer.play();
    }

    public void pauseMedia() {

        mediaPlayer.pause();
    }

}
