package com.example.javafx;

import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SPMenu {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button btn_Start;
    @FXML
    private TextField tf_Name;
    @FXML
    private TextField tf_Symbol;
    @FXML
    private Button btn_Menu;

    public String name;
    public char symbol;

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

    public void SinglePlayerView(ActionEvent event) throws IOException {

        name = tf_Name.getText();
        symbol = tf_Symbol.getCharacters().charAt(0);


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Singleplayer.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void load() //checks input of textfields
    {
        btn_Start.setDisable(true);

        boolean isDisabled = tf_Name.getText().isEmpty() || tf_Symbol.getText().isEmpty() || tf_Name.getText().trim().isEmpty() || tf_Symbol.getText().trim().isEmpty();

        if(isDisabled == false && tf_Symbol.getText().length() == 1 && !Objects.equals(tf_Symbol.getText(), "X"))
        {
            btn_Start.setDisable(false);
        }




    }

}
