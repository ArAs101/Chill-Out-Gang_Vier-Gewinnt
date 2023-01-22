package logic;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GameBoard {

    private static final int rows = 6;
    private static final int cols = 7;

    private char[][] gameBoard;

    public Players p1;
    public Players p2;

    public GameBoard(Players p1, Players p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.gameBoard = new char[rows][cols];
    }


    public boolean placeOnGameBoard(Players p, int col)
    {
        for(int i = rows-1; i >= 0; i--) //from Bottom-up, if space is available its used, else is sends back false
        {
            if(this.gameBoard[i][col] == '\0')
            {
                this.gameBoard[i][col] = p.getSymbol(); //setting symbol of player on the free spot
                return true;
            }
        }
        return false;
    }


    public boolean checkIfWon(Players p)
    {
        char playerSymbol = p.getSymbol();
        int agileCounter = 0;

        //horizontal checking
        for(int row = 0; row < gameBoard.length; row++)
        {
            agileCounter = 0;

            for(int col = 0; col < gameBoard[0].length; col++)
            {
                if (gameBoard[row][col] == playerSymbol)
                {
                    agileCounter++;

                    if(agileCounter == 4)
                    {
                        return true;
                    }
                }
                else
                {
                    agileCounter = 0;
                }

            }
        }

        //vertical checking
        for(int col = 0; col < gameBoard[0].length ; col++)
        {
            agileCounter = 0;

            for(int row = 0; row < gameBoard.length; row++)
            {
                if (gameBoard[row][col] == playerSymbol)
                {
                    agileCounter++;

                    if(agileCounter == 4)
                    {
                        return true;
                    }
                }
                else
                {
                    agileCounter = 0;
                }
            }
        }

        // check diagonals going from bottom-left to top-right
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (gameBoard[i][j] == playerSymbol && gameBoard[i+1][j+1] == playerSymbol && gameBoard[i+1][j+1] == playerSymbol && gameBoard[i+2][j+2] == playerSymbol && gameBoard[i+2][j+2] == playerSymbol && gameBoard[i+3][j+3] == playerSymbol)
                {
                    return true;
                }
            }
        }

        // check diagonals going from top-right to bottom-left
        for (int i = 0; i < 3; i++)
        {
            for (int j = 3; j < 7; j++)
            {
                if (gameBoard[i][j] == playerSymbol && gameBoard[i+1][j-1] == playerSymbol && gameBoard[i+1][j-1] == playerSymbol && gameBoard[i+2][j-2] == playerSymbol && gameBoard[i+2][j-2] == playerSymbol &&  gameBoard[i+3][j-3] == playerSymbol)
                {
                    return true;
                }
            }
        }

        return false;
    }
    //Nur zum Testen
    public void print()
    {
        System.out.println("|---------------------------|");
        System.out.println("| " + this.gameBoard[0][0] + " | " + this.gameBoard[0][1] + " | " + this.gameBoard[0][2] + " | " + this.gameBoard[0][3] + " | " + this.gameBoard[0][4] + " | " + this.gameBoard[0][5] + " | " + this.gameBoard[0][6] + " | ");
        System.out.println("|---+---+---+---+---+---+---|");
        System.out.println("| " + this.gameBoard[1][0] + " | " + this.gameBoard[1][1] + " | " + this.gameBoard[1][2] + " | " + this.gameBoard[1][3] + " | " + this.gameBoard[1][4] + " | " + this.gameBoard[1][5] + " | " + this.gameBoard[1][6] + " | ");
        System.out.println("|---+---+---+---+---+---+---|");
        System.out.println("| " + this.gameBoard[2][0] + " | " + this.gameBoard[2][1] + " | " + this.gameBoard[2][2] + " | " + this.gameBoard[2][3] + " | " + this.gameBoard[2][4] + " | " + this.gameBoard[2][5] + " | " + this.gameBoard[2][6] + " | ");
        System.out.println("|---+---+---+---+---+---+---|");
        System.out.println("| " + this.gameBoard[3][0] + " | " + this.gameBoard[3][1] + " | " + this.gameBoard[3][2] + " | " + this.gameBoard[3][3] + " | " + this.gameBoard[3][4] + " | " + this.gameBoard[3][5] + " | " + this.gameBoard[3][6] + " | ");
        System.out.println("|---+---+---+---+---+---+---|");
        System.out.println("| " + this.gameBoard[4][0] + " | " + this.gameBoard[4][1] + " | " + this.gameBoard[4][2] + " | " + this.gameBoard[4][3] + " | " + this.gameBoard[4][4] + " | " + this.gameBoard[4][5] + " | " + this.gameBoard[4][6] + " | ");
        System.out.println("|---+---+---+---+---+---+---|");
        System.out.println("| " + this.gameBoard[5][0] + " | " + this.gameBoard[5][1] + " | " + this.gameBoard[5][2] + " | " + this.gameBoard[5][3] + " | " + this.gameBoard[5][4] + " | " + this.gameBoard[5][5] + " | " + this.gameBoard[5][6] + " | ");
        System.out.println("|---------------------------|");
        System.out.println("- 1 | 2 | 3 | 4 | 5 | 6 | 7 -");
    }

    public void printFX(GridPane gp) //prints gameboard in JavaFX
    {
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard[i].length; j++) {
                Label label = new Label(String.valueOf(this.gameBoard[i][j]));
                gp.add(label, j, i);
            }
        }
    }


}
