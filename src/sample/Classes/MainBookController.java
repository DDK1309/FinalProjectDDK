package sample.Classes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainBookController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button MancityWin;

    @FXML
    private Button MancityNeproigraet;

    @FXML
    private Button MancityFora;

    @FXML
    private Button MancityTotalBolshe;

    @FXML
    private Button MancityTotalMenshe;

    @FXML
    private Button LiverWins;

    @FXML
    private Button LiverNeProigraet;

    @FXML
    private Button LiverFora;

    @FXML
    private Button LiverTotalBolshe;

    @FXML
    private Button LiverTotalMenshe;
    @FXML
    private Button NazadAuth;

    @FXML
    void initialize() {
        MancityWin.setOnAction(event -> {
            openNewScene("/sample/FXML/SummaOplaty.fxml");
            System.out.println("You chose ManCity victory");
        });
        MancityFora.setOnAction(event -> {
            openNewScene("/sample/FXML/SummaOplaty.fxml");
            System.out.println("You chose ManCity handicap");
        });
        MancityTotalMenshe.setOnAction(event -> {
            openNewScene("/sample/FXML/SummaOplaty.fxml");
            System.out.println("You chose ManCity Total less 1.5");
        });
        MancityTotalBolshe.setOnAction(event -> {
            openNewScene("/sample/FXML/SummaOplaty.fxml");
            System.out.println("You chose ManCity Total more 1.5");
        });
        MancityNeproigraet.setOnAction(event -> {
            openNewScene("/sample/FXML/SummaOplaty.fxml");
            System.out.println("You chose ManCity does not lose");
        });
        LiverWins.setOnAction(event -> {
            openNewScene("/sample/FXML/SummaOplaty.fxml");
            System.out.println("You chose impossible thing");
        });
        LiverFora.setOnAction(event -> {
            openNewScene("/sample/FXML/SummaOplaty.fxml");
            System.out.println("You chose Liver handicap");
        });
        LiverNeProigraet.setOnAction(event -> {
            openNewScene("/sample/FXML/SummaOplaty.fxml");
            System.out.println("You chose Liver does not lose");
        });
        LiverTotalBolshe.setOnAction(event -> {
            openNewScene("/sample/FXML/SummaOplaty.fxml");
            System.out.println("You chose Liver Total more 1.5");
        });
        LiverTotalMenshe.setOnAction(event -> {
            openNewScene("/sample/FXML/SummaOplaty.fxml");
            System.out.println("You chose Liver Total less 1.5");
        });
        NazadAuth.setOnAction(event -> {
            NazadAuth.getScene().getWindow().hide();
            FXMLLoader loader1 = new FXMLLoader ();
            loader1.setLocation(getClass().getResource("/sample/FXML/sample.fxml"));
            try {
                loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root1 = loader1.getRoot();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        });



    }
    public void openNewScene(String window){
        MancityWin.getScene().getWindow().hide();
        MancityFora.getScene().getWindow().hide();
        MancityTotalBolshe.getScene().getWindow().hide();
        MancityNeproigraet.getScene().getWindow().hide();
        MancityTotalMenshe.getScene().getWindow().hide();
        LiverWins.getScene().getWindow().hide();
        LiverFora.getScene().getWindow().hide();
        LiverNeProigraet.getScene().getWindow().hide();
        LiverTotalBolshe.getScene().getWindow().hide();
        LiverTotalMenshe.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("/sample/FXML/SummaOplaty.fxml"));
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


    }




