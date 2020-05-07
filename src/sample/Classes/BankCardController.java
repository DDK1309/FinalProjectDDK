package sample.Classes;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class BankCardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField CardNumberVVOD;

    @FXML
    private DatePicker DataCarty;

    @FXML
    private TextField SecurityCodeCarty;

    @FXML
    private TextField FullNameCarty;

    @FXML
    private CheckBox PrivacyPolicyCarty;

    @FXML
    private Button PayCarty;
    @FXML
    private Button OtmenaOplaty;
    @FXML
    private TextField CardNumberVVOD1;
    @FXML
    private TextField CardNumberVVOD2;
    @FXML
    private TextField CardNumberVVOD3;





    @FXML
    void initialize() {
        PayCarty.setOnAction(event -> {
            String numbCarty = CardNumberVVOD.getText().trim();
            String SecCode = SecurityCodeCarty.getText().trim();
            if(!numbCarty.equals("")&&!SecCode.equals("")&&PrivacyPolicyCarty.isSelected()== true && CardNumberVVOD.getCharacters().length()>3&&  CardNumberVVOD1.getCharacters().length()>3&& CardNumberVVOD2.getCharacters().length()>3&& CardNumberVVOD3.getCharacters().length()>3&& SecurityCodeCarty.getCharacters().length()>2){

            Kodi(numbCarty, SecCode);
            PayCarty.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader ();
            loader.setLocation(getClass().getResource("/sample/FXML/MainBook.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            try {
                FileReader  Myfile = new FileReader("TextStore.txt");
                BufferedReader textReader = new BufferedReader(Myfile);
                System.out.println("Your Bet successfully accepted");
                System.out.println("Bet:"+ textReader.readLine());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

                SaveCardinfo();





            }
            else System.out.println("Please, indicate card information correctly");
        });

        CardNumberVVOD.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                char c = ke.getCharacter().charAt(0);
                if ((( c < '0' ) || (c>'9'))&& (c!=java.awt.event.KeyEvent.VK_PERIOD)){
                    ke.consume();
                }
            }

        });
        CardNumberVVOD.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(CardNumberVVOD.getCharacters().length()==4  )
                    e.consume();

            }
        });

        CardNumberVVOD1.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                char c = ke.getCharacter().charAt(0);
                if ((( c < '0' ) || (c>'9'))&& (c!=java.awt.event.KeyEvent.VK_PERIOD)){
                    ke.consume();
                }
            }

        });
        CardNumberVVOD1.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(CardNumberVVOD1.getCharacters().length()==4  )
                    e.consume();
            }
        });
        CardNumberVVOD2.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                char c = ke.getCharacter().charAt(0);
                if ((( c < '0' ) || (c>'9'))&& (c!=java.awt.event.KeyEvent.VK_PERIOD)){
                    ke.consume();
                }
            }

        });
        CardNumberVVOD2.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(CardNumberVVOD2.getCharacters().length()==4  )
                    e.consume();
            }
        });
        CardNumberVVOD3.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                char c = ke.getCharacter().charAt(0);
                if ((( c < '0' ) || (c>'9'))&& (c!=java.awt.event.KeyEvent.VK_PERIOD)){
                    ke.consume();
                }
            }

        });
        CardNumberVVOD3.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(CardNumberVVOD3.getCharacters().length()==4  )
                    e.consume();
            }
        });

        SecurityCodeCarty.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                char c = ke.getCharacter().charAt(0);
                if ((( c < '0' ) || (c>'9'))&& (c!=java.awt.event.KeyEvent.VK_PERIOD)){
                    ke.consume();
                }

            }

        });
         SecurityCodeCarty.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(SecurityCodeCarty.getCharacters().length()==3)
                    e.consume();
            }
        });
        OtmenaOplaty.setOnAction(event -> {
            OtmenaOplaty.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader ();
            loader.setLocation(getClass().getResource("/sample/FXML/MainBook.fxml"));
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

    private void Kodi(String numbCarty, String secCode) {
    }
    public void SaveCardinfo() {
        String cardInfo = "Number of the Card:" + CardNumberVVOD.getText() + "-" + CardNumberVVOD1.getText() + "-" + CardNumberVVOD2.getText() + "-" + CardNumberVVOD3.getText();
        String NameInfo = "Name of the Card:" + FullNameCarty.getText();
        String CVVinfo = "CVV2/CVC2 code:" + SecurityCodeCarty.getText();
        try (Socket socket = new Socket("127.0.0.1", 8000);
             BufferedWriter writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     socket.getOutputStream()));
             BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     socket.getInputStream()));) {
            System.out.println("Successfully connected to server");
            writer.write(cardInfo + "  |||  " + CVVinfo + "  |||  " + NameInfo);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DBHandlerCard dbCard = new DBHandlerCard();
        dbCard.saveCard(cardInfo,CVVinfo,NameInfo);
    }
}
