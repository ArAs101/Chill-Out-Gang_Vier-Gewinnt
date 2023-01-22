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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.GameBoard;
import logic.Players;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Singleplayer {
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


    SPMenu spm;


    static Players p = new Players("Spieler",'O');
    Players cpuPlayer = new Players("CPU",'X');
    GameBoard gb = new GameBoard(p,cpuPlayer);

    int roundCounter = 1; //counts the amount of "rounds" - every time a player places a tick the counter increases


    public void initialize()
    {
        lbl_Turn.setText(p.getName() + "'s turn");
    }
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
        gb.placeOnGameBoard(p,0);
        gb.printFX(gp_GameBoard);
        roundCounter++;

        if (gb.checkIfWon(p))
        {
          gameWon();
        }
        else
        {
            aiMove();
        }
        if (!gb.lookAtGameBoard(0))
        {
            btn_C1.setDisable(true);
        }
    }

    public void Button2Pressed()
    {
        gb.placeOnGameBoard(p,1);
        gb.printFX(gp_GameBoard);
        roundCounter++;
        if (gb.checkIfWon(p))
        {
            gameWon();
        }
        else
        {
            aiMove();
        }
        if (!gb.lookAtGameBoard(1))
        {
            btn_C2.setDisable(true);
        }
    }

    public void Button3Pressed()
    {
        gb.placeOnGameBoard(p,2);
        gb.printFX(gp_GameBoard);
        roundCounter++;
        if (gb.checkIfWon(p))
        {
            gameWon();
        }
        else
        {
            aiMove();
        }
        if (!gb.lookAtGameBoard(2))
        {
            btn_C3.setDisable(true);
        }
    }

    public void Button4Pressed()
    {
        gb.placeOnGameBoard(p,3);
        gb.printFX(gp_GameBoard);
        roundCounter++;
        if (gb.checkIfWon(p))
        {
            gameWon();
        }
        else
        {
            aiMove();
        }
        if (!gb.lookAtGameBoard(3))
        {
            btn_C4.setDisable(true);
        }
    }

    public void Button5Pressed()
    {
        gb.placeOnGameBoard(p,4);
        gb.printFX(gp_GameBoard);
        roundCounter++;
        if (gb.checkIfWon(p))
        {
            gameWon();
        }
        else
        {
            aiMove();
        }
        if (!gb.lookAtGameBoard(4))
        {
            btn_C5.setDisable(true);
        }
    }

    public void Button6Pressed()
    {
        gb.placeOnGameBoard(p,5);
        gb.printFX(gp_GameBoard);
        roundCounter++;
        if (gb.checkIfWon(p))
        {
            gameWon();
        }
        else
        {
            aiMove();
        }
        if (!gb.lookAtGameBoard(5))
        {
            btn_C6.setDisable(true);
        }

    }

    public void Button7Pressed()
    {
        gb.placeOnGameBoard(p,6);
        gb.printFX(gp_GameBoard);
        roundCounter++;
        if (gb.checkIfWon(p))
        {
            gameWon();
        }
        else
        {
            aiMove();
        }
        if (!gb.lookAtGameBoard(6))
        {
            btn_C7.setDisable(true);
        }

    }


    //endregion

    public void gameWon() //show this when game is won
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("YOU WON");
        alert.setContentText("You won the game!");
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

    public void gameLost() //show this when game is lost
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("YOU LOST");
        alert.setContentText("You lost the game!");
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

    public void gameTied() //show this when game has tied
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

    public void aiMove () //random ai movement
    {
        lbl_Turn.setText(cpuPlayer.getName() + "'s turn");

        Random rndm = new Random();
        int rngZahl = rndm.nextInt(7);


        if(gb.placeOnGameBoard(cpuPlayer, rngZahl))
        {
            gb.printFX(gp_GameBoard);

            roundCounter++;

            if(gb.checkIfWon(cpuPlayer))
            {
                gameLost();
            }

            if(roundCounter > 42)
            {
                gameTied();
            }

            lbl_Turn.setText(p.getName() + "'s turn");

            if (!gb.lookAtGameBoard(rngZahl))
            {
                if(rngZahl == 0)
                {
                    btn_C1.setDisable(true);
                }
                else if(rngZahl == 1)
                {
                    btn_C2.setDisable(true);
                }
                else if(rngZahl == 2)
                {
                    btn_C3.setDisable(true);
                }
                else if(rngZahl == 3)
                {
                    btn_C4.setDisable(true);
                }
                else if(rngZahl == 4)
                {
                    btn_C5.setDisable(true);
                }
                else if(rngZahl == 5)
                {
                    btn_C6.setDisable(true);
                }
                else
                {
                    btn_C7.setDisable(true);
                }
            }
        }
        else {
            aiMove();
        }

    }

}
