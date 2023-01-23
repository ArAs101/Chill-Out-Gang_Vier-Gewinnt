package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainMenu.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Vier Gewinnt");
            //stage.getIcons().add(new Image("file:C:\\Users\\Hamza\\IdeaProjects\\Chill-Out-Gang_Vier-Gewinnt\\src\\main\\java\\com\\example\\javafx\\Icon.png"));
            stage.resizableProperty().setValue(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}