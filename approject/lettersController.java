/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author munirhkhaled
 */
public class lettersController {

    public Stage stage;
    public Scene scene;
    public Parent root;
    public Button nextButton;
    public Label WrongChoiesMessage1;
    public Label WrongChoiesMessage2;

    public MediaView mediaView;
    public Button playButton, pauseButton, resetButton;
    public File file;
    public Media media;
    public MediaPlayer mediaPlayer;

    @FXML

    public void handleHomeButton(ActionEvent event) throws IOException {
        global.checkNewUser = false;
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();

    }

    // ========================== Munirah Interface cnotrolers 
    public void handleNextButton_ToLetterB(ActionEvent event) throws IOException {
        // global.currentUser.getLettersAtndNumbersLearned().setLetters(null);
        if (global.checkNewUser) {

            global.currentUser.getLettersAtndNumbersLearned().setLetters("A");

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(global.currentUser.lettersAndNumbersLearned);
            tx.commit();
            session.close();
            global.checkNewUser=false;
            
            
        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            lettersAndNumbers lettersAndNumbersLearn = null;
            lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
            lettersAndNumbersLearn.setLetters("A");

            Transaction tx = session.beginTransaction();
            session.save(lettersAndNumbersLearn);
            tx.commit();
            session.close();

        }
        
        root = FXMLLoader.load(getClass().getResource("B.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleNextButton_ToLetterC(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setLetters(lettersAndNumbersLearn.getLetters() + ", B");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("C.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleNextButton_ToLetterD(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setLetters(lettersAndNumbersLearn.getLetters() + ", C");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("D.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleNextButton_ToLetterE(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setLetters(lettersAndNumbersLearn.getLetters() + ", D");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("E.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleNextButton_ToLetterF(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setLetters(lettersAndNumbersLearn.getLetters() + ", E");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("F.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleNextButton_ToLetterG(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setLetters(lettersAndNumbersLearn.getLetters() + ", F");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("G.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleNextButton_ToLetterH(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setLetters(lettersAndNumbersLearn.getLetters() + ", G");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("H.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleNextButton_ToLetterI(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setLetters(lettersAndNumbersLearn.getLetters() + ", H");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("I.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void GoHome_fromI(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setLetters(lettersAndNumbersLearn.getLetters() + ", I");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    // when click the right choies
    public void HandleRightImageClicked(MouseEvent event) {
        nextButton.setDisable(false);
        WrongChoiesMessage1.setText("");
        WrongChoiesMessage2.setText("Correct!");

    }

    // when wrong display try again message 
    public void HandleWrongImageClicked1(MouseEvent event) {
        WrongChoiesMessage1.setText("Wrong try again!");
        nextButton.setDisable(true);

    }

    public void HandleWrongImageClicked2(MouseEvent event) {
        WrongChoiesMessage2.setText("Wrong try again!");
        nextButton.setDisable(true);

    }

}
