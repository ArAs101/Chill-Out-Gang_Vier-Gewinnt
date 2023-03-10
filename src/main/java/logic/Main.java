package logic;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void MainMenu() {
        Players p1 = new Players("", (char) 0);
        Players p2 = new Players("", (char) 0);
        System.out.println("Chill-Out Gang presents:");
        System.out.println("Vier gewinnt!!");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Main Menu");
        Scanner scanner = new Scanner(System.in);
        char modechoice = 0;
        while (modechoice != 'S' && modechoice != 'M') {
            System.out.print("Please enter 'S' for Singleplayer mode or 'M' for Multiplayer mode: ");
            modechoice = scanner.next().charAt(0);

            if (modechoice == 'S' || modechoice == 'M') {           //The user will choose their desired gamemode...
                System.out.print("Please enter the name of Player 1: ");
                scanner.nextLine();
                p1.setName(scanner.nextLine());
            } else {
                System.out.println("Invalid input");                // Error handling
            }
        }
        if (modechoice == 'S') {
            do {
                System.out.print("Please choose a symbol for Player 1 (as long as it isn't 'x' or 'X', which is reserved for the AI): ");
                p1.setSymbol(scanner.next().charAt(0));
                if (p1.getSymbol() == 'X' || p1.getSymbol() == 'x') {
                    System.out.println("'" + p1.getSymbol() + "' isn't allowed as symbol for Player 1!");
                }
            } while (p1.getSymbol() == 0 || p1.getSymbol() == 'X' || p1.getSymbol() == 'x');
            // In Singleplayer mode, only Player 1 can be "customized"...
            p2.setName("COM");
            p2.setSymbol('X');
        }
        if (modechoice == 'M') {
            // All that's left to do is to pick a symbol for Player 1 since their name is already set
            System.out.print("Please choose a symbol for Player 1: ");
            p1.setSymbol(scanner.next().charAt(0));

            do {
                System.out.print("Please enter the name of Player 2: ");
                scanner.nextLine();
                p2.setName(scanner.next());
                if (Objects.equals(p1.getName(), p2.getName())) {           // Error handling...
                    System.out.println("The player names must be different!");
                }
            } while (Objects.equals(p1.getName(), p2.getName()) || Objects.equals(p2.getName(), ""));

            do {
                System.out.print("Please choose a symbol for Player 2: ");
                p2.setSymbol(scanner.next().charAt(0));

                if (p1.getSymbol() == p2.getSymbol()) {
                    System.out.println("The players' symbols must be different!");
                }
            } while (p2.getSymbol() == 0 || p1.getSymbol() == p2.getSymbol());
        }

        System.out.println();
        System.out.println("_________________________________________________________________________________________");
        System.out.println("Summary of Players:");
        System.out.println("Player 1:");
        System.out.println("Name: " + p1.getName());
        System.out.println("Symbol: " + p1.getSymbol());
        System.out.println("Player 2:");
        System.out.println("Name: " + p2.getName());
        System.out.println("Symbol: " + p2.getSymbol());

        System.out.println("The game will start soon :)");
        System.out.println("_________________________________________________________________________________________");

        // Finally, the game can start! :)
        if (modechoice == 'S')
        {
            playGameSingleplayer(p1,p2);
        }
        else {
            playGameMultiplayer(p1,p2);
        }
    }

    public static void playGameMultiplayer(Players p1, Players p2)
    {
        GameBoard gameBoard = new GameBoard(p1,p2); //creates a gameboard with p1,p2
        boolean win = false;
        double round = 1;
        System.out.println("Game starting....");
        while(!win && round < 43) //if win = false and rounds are not above max 42
        {
            gameBoard.print(); //prints the gameboard
            System.out.println("Player " + gameBoard.p1.getName() + " turn:");
            gameBoard.p1.place(gameBoard); //player 1 place on the gameboard
            round++;
            win = gameBoard.checkIfWon(p1);
            if (win) //if win = true, means player 1 won
            {
                gameBoard.print();
                System.out.println("Player " + gameBoard.p1.getName() + " wins!");
                break;
            }
            gameBoard.print();
            System.out.println("Player " + gameBoard.p2.getName() + " turn:");
            gameBoard.p2.place(gameBoard);
            round++;
            win = gameBoard.checkIfWon(p2);
            if (win)
            {
                gameBoard.print();
                System.out.println("Player " + gameBoard.p2.getName() + " wins!");
                break;
            }
        }
        if (!win) //if it goes over max round and win is still false
        {
            gameBoard.print();
            System.out.println("Nobody wins!");
        }

    }

    public static void playGameSingleplayer(Players p1, Players p2)
    {
        GameBoard gameBoard = new GameBoard(p1, p2); //similar to playGameMultiplayer
        boolean win = false;
        double round = 1;
        System.out.println("Game starting....");
        while (!win && round < 43) {
            gameBoard.print();
            System.out.println("Player " + gameBoard.p1.getName() + " turn:");
            gameBoard.p1.place(gameBoard);
            round++;
            win = gameBoard.checkIfWon(p1);
            if (win) {
                gameBoard.print();
                System.out.println("Player " + gameBoard.p1.getName() + " wins!");
                break;
            }
            gameBoard.print();
            System.out.println("Player " + gameBoard.p2.getName() + " turn:");
            gameBoard.p2.place(gameBoard, true); //Player 2 is a bot so we use the place Methode with bot = true
            round++;
            win = gameBoard.checkIfWon(p2);
            if (win) {
                gameBoard.print();
                System.out.println("Player " + gameBoard.p2.getName() + " wins!");
                break;
            }
        }
        if (!win) {
            gameBoard.print();
            System.out.println("Nobody wins!");
        }

    }


    public static void main(String[] args) {
        char eingabe;
        Scanner sc = new Scanner(System.in);
        do{
            MainMenu();
            System.out.println("Nochmal spielen? Ja = j, Nein = n");
            eingabe = sc.next().charAt(0);
            System.out.println();
        }while(eingabe != 'n');
    }
}