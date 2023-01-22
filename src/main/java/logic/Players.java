package logic;

import java.util.Random;
import java.util.Scanner;


public class Players {
    private String name;
    private char symbol;


    public Players(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void place(GameBoard gameBoard) //places players symbole on selected col (on the gameboard) - multiplayer
    {
        Scanner sc = new Scanner(System.in);
        int selected; //selected column
        boolean loop = true; //needed for loop below
        do {
            System.out.print("Enter a number between 1 and 7: ");
            selected = sc.nextInt(); //input from user
            if(selected >= 1 && selected <= 7) //check selected number 1-7
            {
                if(gameBoard.placeOnGameBoard(this,selected-1)) //returns true if placement on gameboard was successful
                {
                    loop = false;
                }
            }
        } while (loop); //loops until it was able to place on gameboard and selected number was between 1-7
    }
    public void place(GameBoard gameBoard, boolean bot) //bot = true means a bot is placing on the gameboard - singleplayer
    {
        if (bot)
        {
            Random random = new Random();
            int selected = random.nextInt(7) + 1; //gets a number between 1-7
            boolean loop = true;
            do {
                if(gameBoard.placeOnGameBoard(this,selected-1)) //checks if selected col has free spot, return true if placement was successful
                {
                    System.out.println("Selected: " + selected); //tells the other player, what the bot has selected
                    loop = false;
                }
                selected = random.nextInt(7) + 1; //gets a new random number for the next loop

            } while (loop);
        }
        else //if it is not a bot and someone uses this methode than it will still function with this!
        {
            place(gameBoard);
        }

    }
}