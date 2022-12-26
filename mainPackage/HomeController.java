/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author kholud
 */
public class HomeController implements Initializable {

    @FXML
    private ImageView panda;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public Label alert;

    public Button SingUpButton;

    public TextField txUser_id;
    public TextField txName;
    public TextField txEmail;
    public TextField txPassword;
    public ComboBox<String> comboBox;
    public RadioButton rd1;
    public RadioButton rd2;

    public Label Letters;
    public Label Numbers;

    @FXML
    public void handleHomeButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();

    }

    public void handlSignOutButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main");
        stage.show();

    }

    // from main to home
    public void handleCreateAccButtonInMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sign Up");
        stage.show();
    }

    public void handleCreateAccButton(ActionEvent event) throws IOException {
        String get_txUser_id = txUser_id.getText();
        String get_txName = txName.getText();
        String get_txEmail = txEmail.getText();
        String get_txPassword = txPassword.getText();
        String get_age = comboBox.getValue();
        String get_gender;
        
        // to get the gender data 
        
            if (rd1.isSelected()) {
                get_gender = "Boy";
            } else if (rd2.isSelected()) {
                get_gender = "Girl";
            } else {
                get_gender = "Unknown";
            }

        // load the users ids to check if the enterd id is already exist 
        List<Integer> userslist = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select user_id from user");
        userslist = query.list();
        session.close();

        if (get_txUser_id.isEmpty()) {
            alert.setText("You need to enter a id to precced");

        } else if (get_txPassword.isEmpty()) {
            alert.setText("You need to enter a Password to precced");
        } else if (!get_txUser_id.matches("^[0-9]+$")) {
            alert.setText("The id must be a digit only");
        } else {
            global.currentUser = new user(parseInt(get_txUser_id), get_txEmail,
                    get_txPassword, get_age, get_gender,get_txName);

            if (userslist.contains(parseInt(get_txUser_id))) {
                alert.setText("this id is used plese enter another one");

            } else {
                /* ===== imporntat note!!!!!
                  in the next line we are intilizing the lettersAtndNumbersLearned 
                  varible in the user class with the new user id*/
                global.currentUser.getLettersAtndNumbersLearned().setUser_id(parseInt(get_txUser_id));

                session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                session.save(global.currentUser);
                tx.commit();
                session.close();

                global.checkNewUser = true;

                alert.setText("");
                System.out.println("inserted user: " + global.currentUser.getUser_id());

                root = FXMLLoader.load(getClass().getResource("home.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Home");
                stage.show();

            }

        }

    }

    public void handleLoginInButtonInMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Log in");
        stage.show();
    }

    public void handelLoginButton(ActionEvent event) throws IOException {
        String get_txUser_id = txUser_id.getText();
        String get_txPassword = txPassword.getText();

        List<Integer> userslist = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select user_id from user");
        userslist = query.list();
        session.close();

        if (get_txPassword.isEmpty()) {
            alert.setText("You need to enter a Password to precced");
        } else if (!get_txUser_id.matches("^[0-9]+$")) {
            alert.setText("The id must be a digit only");

        } else if (!userslist.contains(parseInt(get_txUser_id))) {
            alert.setText("create an account first !");
        }

        if (userslist.contains(parseInt(get_txUser_id))) {
            String correctPass;
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            user userpass = null;
            userpass = (user) session.get(user.class, parseInt(get_txUser_id));
            correctPass = userpass.getPassword();
            tx.commit();
            session.close();

            if (correctPass.trim().equals(get_txPassword.trim())) {
                global.currentUser = new user(parseInt(get_txUser_id),
                        get_txPassword);
                global.currentUser.getLettersAtndNumbersLearned().setUser_id(parseInt(get_txUser_id));

                root = FXMLLoader.load(getClass().getResource("home.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Home");
                stage.show();
            } else {
                alert.setText("the password is wrong");
            }
        }
    }

    public void add(MouseEvent event) {
        comboBox.getItems().addAll("1", "2", "3", "4", "5", "+6");

        comboBox.getSelectionModel().selectedIndexProperty().addListener(e -> {
            if (comboBox.getValue() == "+6") {
                alert.setText("Sorry, this game is not suitable for your age");
                SingUpButton.setDisable(true);
            } else {
                SingUpButton.setDisable(false);
            }

        }
        );
    }

    // from home to options
    @FXML
    public void handleNextButton_ToLetterA(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        tx.commit();
        session.close();

        String letterLearned;
        String lastLetterLearned;

        try {
            letterLearned = lettersAndNumbersLearn.getLetters();
            lastLetterLearned = letterLearned.substring(letterLearned.length() - 1);
        } catch (NullPointerException e) {
            letterLearned = "1230";
            lastLetterLearned = "0";
        }

        if (lastLetterLearned.equals("0")) {
            root = FXMLLoader.load(getClass().getResource("A.fxml"));
        }
        if (lastLetterLearned.equals("A")) {
            root = FXMLLoader.load(getClass().getResource("B.fxml"));
        }
        if (lastLetterLearned.equals("B")) {
            root = FXMLLoader.load(getClass().getResource("C.fxml"));
        }
        if (lastLetterLearned.equals("C")) {
            root = FXMLLoader.load(getClass().getResource("D.fxml"));
        }
        if (lastLetterLearned.equals("D")) {
            root = FXMLLoader.load(getClass().getResource("E.fxml"));
        }
        if (lastLetterLearned.equals("E")) {
            root = FXMLLoader.load(getClass().getResource("F.fxml"));
        }
        if (lastLetterLearned.equals("F")) {
            root = FXMLLoader.load(getClass().getResource("G.fxml"));
        }
        if (lastLetterLearned.equals("G")) {
            root = FXMLLoader.load(getClass().getResource("H.fxml"));
        }
        if (lastLetterLearned.equals("H")) {
            root = FXMLLoader.load(getClass().getResource("I.fxml"));
        }
        if (lastLetterLearned.equals("I")) {
            root = FXMLLoader.load(getClass().getResource("LearnedAllLetters.fxml"));
        }

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Learn leeters");
        stage.show();
    }

    public void handleNextButton_ToNumber1(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        tx.commit();
        session.close();

        String numbersLearned;
        String lastNumberLearned;

        try {
            numbersLearned = lettersAndNumbersLearn.getNumbers();
            lastNumberLearned = numbersLearned.substring(numbersLearned.length() - 1);
        } catch (NullPointerException e) {
            numbersLearned = "1230";
            lastNumberLearned = "0";
        }

        if (lastNumberLearned.equals("0")) {
            root = FXMLLoader.load(getClass().getResource("1.fxml"));
        }
        if (lastNumberLearned.equals("1")) {
            root = FXMLLoader.load(getClass().getResource("2.fxml"));
        }
        if (lastNumberLearned.equals("2")) {
            root = FXMLLoader.load(getClass().getResource("3.fxml"));
        }
        if (lastNumberLearned.equals("3")) {
            root = FXMLLoader.load(getClass().getResource("4.fxml"));
        }
        if (lastNumberLearned.equals("4")) {
            root = FXMLLoader.load(getClass().getResource("5.fxml"));
        }
        if (lastNumberLearned.equals("5")) {
            root = FXMLLoader.load(getClass().getResource("6.fxml"));
        }
        if (lastNumberLearned.equals("6")) {
            root = FXMLLoader.load(getClass().getResource("LearnedAllNumbers.fxml"));
        }

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Learn numbers");
        stage.show();
    }

    public void handleNextButton_ToMyPorgress(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MyProgress.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("My Progress");
        stage.show();

    }

    public void ShowMeLetters(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        tx.commit();
        session.close();

        if (lettersAndNumbersLearn.getLetters() == null) {
            Letters.setText("There is no letters stored");
        } else {
            Letters.setText(lettersAndNumbersLearn.getLetters());
        }

    }

    public void ShowMeNumbers(ActionEvent event) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        lettersAndNumbers lettersAndNumbersLearn = null;
        lettersAndNumbersLearn = (lettersAndNumbers) session.get(lettersAndNumbers.class, global.currentUser.getUser_id());
        tx.commit();
        session.close();

        if (lettersAndNumbersLearn.getNumbers() == null) {
            Numbers.setText("There is no numbers stored");
        } else {
            Numbers.setText(lettersAndNumbersLearn.getNumbers());
        }

    }

    public void handleNextButton_ToVideo(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("video.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sing Along");
        stage.show();
    }
    
public void handlExportFile(ActionEvent event) throws IOException{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            user currentUser_toBePrinted = null;
            currentUser_toBePrinted = (user) session.get(user.class, global.currentUser.getUser_id());
            tx.commit();
            session.close();

            String print_user_id = Integer.toString(currentUser_toBePrinted.getUser_id());
            String print_name = currentUser_toBePrinted.getName();
            String print_numbers = currentUser_toBePrinted.lettersAndNumbersLearned.getNumbers();
            String print_letters = currentUser_toBePrinted.lettersAndNumbersLearned.getLetters();
    
       try {
            FileWriter fw = new FileWriter("myPorgressData.txt");
         
                fw.write("your ID: " + print_user_id + " \n ");
                fw.write("your name: " + print_name + " \n ");
                 fw.write("your learned the following letters: " + print_letters + " \n ");
                fw.write("your learned the following numbers: " + print_numbers + " \n ");
            
            fw.close();
               System.out.println("================= Printing Succeessed =================");
        } 
       
       catch (IOException e) {
           System.out.println("================= Printing Falied =================");
        }

}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(panda);
        translate.setDuration(Duration.millis(1800));
        translate.setByX(290);
        translate.play();
    }

}
