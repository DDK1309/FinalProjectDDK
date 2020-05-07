package sample.Classes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField FisrtName;

    @FXML
    private TextField LastName;

    @FXML
    private TextField UserName;

    @FXML
    private TextField Email;

    @FXML
    private PasswordField PasswordReg;

    @FXML
    private Button SignUpButton;
    @FXML
    private Button Nazad;

    @FXML
    void initialize() {

        SignUpButton.setOnAction(event -> {
            SignUpNewUser();





            String Fn = FisrtName.getText().trim();
            String Ln = LastName.getText().trim();
            String Un = UserName.getText().trim();
            String En = Email.getText().trim();
            String Pn = PasswordReg.getText().trim();
            if (!Fn.equals("")&& !Ln.equals("")&& !Un.equals("") && !En.equals("")&& !Pn.equals("")){
                RegInfo(Fn,Ln,Un,En,Pn);
                SignUpButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/FXML/sample.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
            else System.out.println("Be sure to fill in the fields");
        });
        Nazad.setOnAction(event -> {
            Nazad.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/sample.fxml"));
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

    }

    private void SignUpNewUser() {

        DatabaseHandler dbHandler = new DatabaseHandler();
        String firstname = FisrtName.getText();
        String lastname = LastName.getText();
        String username = UserName.getText();
        String email = Email.getText();
        String password = PasswordReg.getText();
        User user = new User(firstname,lastname,username,email,password);


        dbHandler.signupUser(user);
    }

    private void RegInfo(String fn, String ln, String un, String en, String pn) {
    }
}
