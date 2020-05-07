package sample.Classes;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.animations.Shaker;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button LoginSignin;
    @FXML
    private Button RegistrationButton;
    @FXML
    private AnchorPane content;

    @FXML
    void initialize() {
        RegistrationButton.setOnAction(event -> {
            RegistrationButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/Registration.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        });
        ExitButton.setOnAction(event -> {
            System.exit(0);
        });
        LoginSignin.setOnAction(event -> {

            String LoginText = LoginField.getText().trim();
            String PasswordText = PasswordField.getText().trim();
            if(!LoginText.equals("")&& !PasswordText.equals("")){
                loginUser(LoginText, PasswordText);


            }
            else System.out.println("Please, fill in the fields");




        });


    }









    private void loginUser(String loginText, String passwordText) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(passwordText);
        ResultSet result =  dbHandler.getUser(user);
        int counter = 0;
        try {
            while(result.next()){
                counter++;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (counter>=1){
            System.out.println("Success authorization!");
            LoginSignin.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/MainBook.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();}
        else {
            Shaker userLoginAnimation = new Shaker(LoginField);
            Shaker userPassAnimation = new Shaker(PasswordField);
            userLoginAnimation.PlayAnimation();
            userPassAnimation.PlayAnimation();
            System.out.println("Please, register");
        }

    }
}

