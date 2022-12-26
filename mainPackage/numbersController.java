/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author munirhkhaled
 */
public class numbersController {

    public Stage stage;
    public Scene scene;
    public Parent root;
    public Button nextButton;
    public TextField textFieldNumber;
    public Label messageLabel;

    /**
     * Initializes the controller class.
     */
    public void handleHomeButton(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("home.fxml")); //change to sene D here
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void handleSignOutButton(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleNextButton_ToNumber2(ActionEvent event) throws IOException {
        
        
       
        if (global.checkNewUser) {

            global.currentUser.getLettersAtndNumbersLearned().setNumbers("1");
     
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
            lettersAndNumbersLearn.setNumbers("1");

            Transaction tx = session.beginTransaction();
            session.save(lettersAndNumbersLearn);
            tx.commit();
            session.close();

        }
    
       
        root = FXMLLoader.load(getClass().getResource("2.fxml")); //change to sene D here
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    public void handleNextButton_ToNumber3(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setNumbers(lettersAndNumbersLearn.getNumbers() + ", 2");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("3.fxml")); //change to sene D here
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleNextButton_ToNumber4(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setNumbers(lettersAndNumbersLearn.getNumbers() + ", 3");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("4.fxml")); //change to sene D here
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleNextButton_ToNumber5(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setNumbers(lettersAndNumbersLearn.getNumbers() + ", 4");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("5.fxml")); //change to sene D here
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleNextButton_ToNumber6(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setNumbers(lettersAndNumbersLearn.getNumbers() + ", 5");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("6.fxml")); //change to sene D here
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    
    
    public void GoHome_from6(ActionEvent event) throws IOException{
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        lettersAndNumbersLearn.setNumbers(lettersAndNumbersLearn.getNumbers() + ", 6");
        session.update(lettersAndNumbersLearn);
        tx.commit();
        session.close();

        root = FXMLLoader.load(getClass().getResource("home.fxml")); //change to sene D here
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
}

    public void HandleRightNumber_1() {
        if (textFieldNumber.getText().isEmpty()) {
            messageLabel.setText("Please Enter A number");
            nextButton.setDisable(true);
        } else if (!textFieldNumber.getText().matches("^[0-9]+$")) {
            messageLabel.setText("This field must be digit only");
            nextButton.setDisable(true);
        } else if (textFieldNumber.getText().matches("^[0-9]+$")
                && parseInt(textFieldNumber.getText().trim()) != 1) {
            messageLabel.setText("Wrong Answer try Again");
            nextButton.setDisable(true);
        } else if (parseInt(textFieldNumber.getText().trim()) == 1) {
            messageLabel.setText("that is right you can move to next!");
            nextButton.setDisable(false);
        }
    }

    public void HandleRightNumber_2() {
        if (textFieldNumber.getText().isEmpty()) {
            messageLabel.setText("Please Enter A number");
            nextButton.setDisable(true);
        } else if (!textFieldNumber.getText().matches("^[0-9]+$")) {
            messageLabel.setText("This field must be digit only");
            nextButton.setDisable(true);
        } else if (textFieldNumber.getText().matches("^[0-9]+$")
                && parseInt(textFieldNumber.getText().trim()) != 2) {
            messageLabel.setText("Wrong Answer try Again");
            nextButton.setDisable(true);
        } else if (parseInt(textFieldNumber.getText().trim()) == 2) {
            messageLabel.setText("that is right you can move to next!");
            nextButton.setDisable(false);
        }
    }

    public void HandleRightNumber_3() {
        if (textFieldNumber.getText().isEmpty()) {
            messageLabel.setText("Please Enter A number");
            nextButton.setDisable(true);
        } else if (!textFieldNumber.getText().matches("^[0-9]+$")) {
            messageLabel.setText("This field must be digit only");
            nextButton.setDisable(true);
        } else if (textFieldNumber.getText().matches("^[0-9]+$")
                && parseInt(textFieldNumber.getText().trim()) != 3) {
            messageLabel.setText("Wrong Answer try Again");
            nextButton.setDisable(true);
        } else if (parseInt(textFieldNumber.getText().trim()) == 3) {
            messageLabel.setText("that is right you can move to next!");
            nextButton.setDisable(false);
        }
    }

    public void HandleRightNumber_4() {
        if (textFieldNumber.getText().isEmpty()) {
            messageLabel.setText("Please Enter A number");
            nextButton.setDisable(true);
        } else if (!textFieldNumber.getText().matches("^[0-9]+$")) {
            messageLabel.setText("This field must be digit only");
            nextButton.setDisable(true);
        } else if (textFieldNumber.getText().matches("^[0-9]+$")
                && parseInt(textFieldNumber.getText().trim()) != 4) {
            messageLabel.setText("Wrong Answer try Again");
            nextButton.setDisable(true);
        } else if (parseInt(textFieldNumber.getText().trim()) == 4) {
            messageLabel.setText("that is right you can move to next!");
            nextButton.setDisable(false);
        }
    }

    public void HandleRightNumber_5() {
        if (textFieldNumber.getText().isEmpty()) {
            messageLabel.setText("Please Enter A number");
            nextButton.setDisable(true);
        } else if (!textFieldNumber.getText().matches("^[0-9]+$")) {
            messageLabel.setText("This field must be digit only");
            nextButton.setDisable(true);
        } else if (textFieldNumber.getText().matches("^[0-9]+$")
                && parseInt(textFieldNumber.getText().trim()) != 5) {
            messageLabel.setText("Wrong Answer try Again");
            nextButton.setDisable(true);
        } else if (parseInt(textFieldNumber.getText().trim()) == 5) {
            messageLabel.setText("that is right you can move to next!");
            nextButton.setDisable(false);
        }
    }

    public void HandleRightNumber_6() {

        if (textFieldNumber.getText().isEmpty()) {
            messageLabel.setText("Please Enter A number");
            nextButton.setDisable(true);
        } else if (!textFieldNumber.getText().matches("^[0-9]+$")) {
            messageLabel.setText("This field must be digit only");
            nextButton.setDisable(true);
        } else if (textFieldNumber.getText().matches("^[0-9]+$")
                && parseInt(textFieldNumber.getText().trim()) != 6) {
            messageLabel.setText("Wrong Answer try Again");
            nextButton.setDisable(true);
        } else if (parseInt(textFieldNumber.getText().trim()) == 6) {
            messageLabel.setText("that is right you can move to next!");
            nextButton.setDisable(false);
        }

    }

}