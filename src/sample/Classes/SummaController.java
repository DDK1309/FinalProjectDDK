package sample.Classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SummaController {
    @FXML
    private MenuItem USD;
    @FXML
    private MenuItem RUB;
    @FXML
    private MenuItem KZT;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton ValutaStavki;

    @FXML
    private TextField SummaStavki;

    @FXML
    private CheckBox VozrastStavki;

    @FXML
    private Button KnopkaNextStavki;

    @FXML
    void initialize() {

        SummaStavki.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                char c = ke.getCharacter().charAt(0);
                if ((( c < '0' ) || (c>'9'))&& (c!=java.awt.event.KeyEvent.VK_PERIOD)){
                    ke.consume();
                }
            }
        });

        ArrayList<String> currency = new ArrayList<>();
        USD.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("YOU CHOSE USD");
                currency.add("USD");

            }
        });
        RUB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("YOU CHOSE RUB");
                currency.add("RUB");
            }
        });
        KZT.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("YOU CHOSE KZT");
                currency.add("KZT");
            }
        });

        KnopkaNextStavki.setOnAction((ActionEvent event) -> {
            String SummaBet = SummaStavki.getText().trim();
            if (!SummaBet.equals("")&& VozrastStavki.isSelected()!= false) {
                SummaDeneg(SummaBet);

                KnopkaNextStavki.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/FXML/CreditCard.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                File myFile = new File("TextStore.txt");
                try {
                    FileWriter writer1 = new FileWriter(myFile);

                    writer1.write(SummaStavki.getText()+currency);

                    writer1.close();

                }
                catch (IOException ex){
                    ex.printStackTrace();
                }

            }else System.out.println("Please, indicate your bet and your age");
        });






    }



    private void SummaDeneg(String summaBet) {
    }
}
