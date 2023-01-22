package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.GameBoard;
import logic.Players;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Multiplayer {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text lbl_Turn;
    @FXML
    private GridPane gp_GameBoard;
    @FXML
    private Button btn_C1;
    @FXML
    private Button btn_C2;
    @FXML
    private Button btn_C3;
    @FXML
    private Button btn_C4;
    @FXML
    private Button btn_C5;
    @FXML
    private Button btn_C6;
    @FXML
    private Button btn_C7;

    public void initialize()
    {
        lbl_Turn.setText(p.getName() + "'s turn");
    }



    static Players p = new Players("Spieler",'O');
    static Players p2 = new Players("Spieler2",'X');
    GameBoard gb = new GameBoard(p,p2);

    int roundCounter = 1; //counts the amount of "rounds" - every time a player places a tick the counter increases

    public void MainMenuView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainMenu.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //region button actions - sets tic at demanded place and checks if the game is won/tied and looks if a column is filled
    public void Button1Pressed()
    {
        if (lbl_Turn.getText().equals(p.getName() + "'s turn"))
        {
            gb.placeOnGameBoard(p,0);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p))
            {
                gameWon(p);
            }
            else
            {
                lbl_Turn.setText(p2.getName() + "'s turn");

            }
            if (!gb.lookAtGameBoard(0))
            {
                btn_C1.setDisable(true);
            }
        }
        else {
            gb.placeOnGameBoard(p2, 0);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p2)) {
                gameWon(p2);
            } else {
                lbl_Turn.setText(p.getName() + "'s turn");

            }
            if (!gb.lookAtGameBoard(0))
            {
                btn_C1.setDisable(true);
            }
        }


    }

    public void Button2Pressed()
    {
        if (lbl_Turn.getText().equals(p.getName() + "'s turn"))
        {
            gb.placeOnGameBoard(p,1);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p))
            {
                gameWon(p);
            }
            else
            {
                lbl_Turn.setText(p2.getName() + "'s turn");

            }
            if (!gb.lookAtGameBoard(1))
            {
                btn_C2.setDisable(true);
            }
        }
        else {
            gb.placeOnGameBoard(p2, 1);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p2)) {
                gameWon(p2);
            } else {
                lbl_Turn.setText(p.getName() + "'s turn");

            }
            if (!gb.lookAtGameBoard(1))
            {
                btn_C2.setDisable(true);
            }
        }

    }

    public void Button3Pressed()
    {
        if (lbl_Turn.getText().equals(p.getName() + "'s turn"))
        {
            gb.placeOnGameBoard(p,2);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p))
            {
                gameWon(p);
            }
            else
            {
                lbl_Turn.setText(p2.getName() + "'s turn");

            }
            if (!gb.lookAtGameBoard(2))
            {
                btn_C3.setDisable(true);
            }
        }
        else {
            gb.placeOnGameBoard(p2, 2);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p2)) {
                gameWon(p2);
            } else {
                lbl_Turn.setText(p.getName() + "'s turn");

            }
            if (!gb.lookAtGameBoard(2))
            {
                btn_C3.setDisable(true);
            }
        }

    }

    public void Button4Pressed()
    {
        if (lbl_Turn.getText().equals(p.getName() + "'s turn"))
        {
            gb.placeOnGameBoard(p,3);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p))
            {
                gameWon(p);
            }
            else
            {
                lbl_Turn.setText(p2.getName() + "'s turn");

            }
            if (!gb.lookAtGameBoard(3))
            {
                btn_C4.setDisable(true);
            }
        }
        else {
            gb.placeOnGameBoard(p2, 3);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p2)) {
                gameWon(p2);
            } else {
                lbl_Turn.setText(p.getName() + "'s turn");

            }
            if (!gb.lookAtGameBoard(3))
            {
                btn_C4.setDisable(true);
            }
        }

    }

    public void Button5Pressed()
    {
        if (lbl_Turn.getText().equals(p.getName() + "'s turn"))
        {
            gb.placeOnGameBoard(p,4);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p))
            {
                gameWon(p2);
            }
            else
            {
                lbl_Turn.setText(p2.getName() + "'s turn");

            }
            if (!gb.lookAtGameBoard(4))
            {
                btn_C5.setDisable(true);
            }
        }
        else {
            gb.placeOnGameBoard(p2, 4);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p2)) {
                gameWon(p);
            } else {
                lbl_Turn.setText(p.getName() + "'s turn");

            }
            if (!gb.lookAtGameBoard(4))
            {
                btn_C5.setDisable(true);
            }
        }

    }

    public void Button6Pressed()
    {
        if (lbl_Turn.getText().equals(p.getName() + "'s turn"))
        {
            gb.placeOnGameBoard(p,5);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p))
            {
                gameWon(p);
            }
            else
            {
                lbl_Turn.setText(p2.getName() + "'s turn");

            }

            if (!gb.lookAtGameBoard(5))
            {
                btn_C6.setDisable(true);
            }
        }
        else {
                gb.placeOnGameBoard(p2, 5);
                roundCounter++;
                gb.printFX(gp_GameBoard);

                if(roundCounter > 42)
                {
                    gameTied();
                }

                if (gb.checkIfWon(p2)) {
                    gameWon(p2);
                } else {


                    lbl_Turn.setText(p.getName() + "'s turn");

                }
            if (!gb.lookAtGameBoard(5))
            {
                btn_C6.setDisable(true);
            }



        }
    }

    public void Button7Pressed()
    {
        if (lbl_Turn.getText().equals(p.getName() + "'s turn"))
        {
            gb.placeOnGameBoard(p,6);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p))
            {
                gameWon(p);
            }
            else
            {
                lbl_Turn.setText(p2.getName() + "'s turn");

            }

            if (!gb.lookAtGameBoard(6))
            {
                btn_C7.setDisable(true);
            }
        }
        else {
            gb.placeOnGameBoard(p2, 6);
            roundCounter++;
            gb.printFX(gp_GameBoard);

            if(roundCounter > 42)
            {
                gameTied();
            }

            if (gb.checkIfWon(p2)) {
                gameWon(p2);
            } else {


                lbl_Turn.setText(p.getName() + "'s turn");

            }
            if (!gb.lookAtGameBoard(6))
            {
                btn_C7.setDisable(true);
            }



        }
    }
    //endregion

    public void gameWon(Players player) //show this when somebody won
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(player.getName() + " WON");
        alert.setContentText(player.getName() + " won the game!");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });

        btn_C1.setDisable(true);
        btn_C2.setDisable(true);
        btn_C3.setDisable(true);
        btn_C4.setDisable(true);
        btn_C5.setDisable(true);
        btn_C6.setDisable(true);
        btn_C7.setDisable(true);
    }

    public void gameTied() //show this when the game has tied
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("GAME TIED");
        alert.setContentText("The game tied!");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });


        btn_C1.setDisable(true);
        btn_C2.setDisable(true);
        btn_C3.setDisable(true);
        btn_C4.setDisable(true);
        btn_C5.setDisable(true);
        btn_C6.setDisable(true);
        btn_C7.setDisable(true);
    }
}