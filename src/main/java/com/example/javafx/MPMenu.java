package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.Players;

import java.io.IOException;
import java.util.Objects;

public class MPMenu {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button btn_Start;
    @FXML
    private TextField tf_Name1;
    @FXML
    private TextField tf_Name2;
    @FXML
    private TextField tf_Symbol1;
    @FXML
    private TextField tf_Symbol2;
    @FXML
    private Button btn_Menu;

    public void initialize(){
        btn_Start.setDisable(true);
    }

    public void MainMenuView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainMenu.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MultiPlayerView(ActionEvent event) throws IOException {
        Multiplayer.p = new Players(tf_Name1.getText(),tf_Symbol1.getText().charAt(0));
        Multiplayer.p2 = new Players(tf_Name2.getText(),tf_Symbol2.getText().charAt(0));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Multiplayer.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void load() //checks input of textfields
    {
        btn_Start.setDisable(true);

        boolean isDisabled1 = tf_Name1.getText().isEmpty() || tf_Symbol1.getText().isEmpty() || tf_Name1.getText().trim().isEmpty() || tf_Symbol1.getText().trim().isEmpty();
        boolean isDisabled2 = tf_Name2.getText().isEmpty() || tf_Symbol2.getText().isEmpty() || tf_Name2.getText().trim().isEmpty() || tf_Symbol2.getText().trim().isEmpty();
        if(isDisabled1 == false && isDisabled2 == false && tf_Symbol1.getText().length() == 1 && tf_Symbol2.getText().length() == 1 && !Objects.equals(tf_Symbol1.getText(), tf_Symbol2.getText()) && !Objects.equals(tf_Name1.getText(), tf_Name2.getText()))
        {
            btn_Start.setDisable(false);
        }

    }


}