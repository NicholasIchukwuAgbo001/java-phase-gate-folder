package TicTacToeGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        CurrentState currentPlayer = CurrentState.X;
        Scanner userInputCollection = new Scanner(System.in);

        System.out.println("""
         \nWelcome to Tic-Tac-Toe Game🤣🤗🤗!
        """);

        while (true) {

            System.out.println("====================");
            game.printBoard();
            System.out.println("====================");

            int position;
            while(true) {
                try {
                    System.out.print("\nPlayer " + currentPlayer + ", enter position (1-9): ");
                    position = userInputCollection.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input");
                }
            }

            try {
                game.moves(currentPlayer, position);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (game.checkWinner() != CurrentState.EMPTY) {
                game.printBoard();
                System.out.println("\nPlayer " + currentPlayer + " wins!");
                break;
            }

            if(game.isFull() != CurrentState.EMPTY) {
                game.printBoard();
                System.out.println("\nTIE");
                break;
            }


            if (currentPlayer == CurrentState.X) {
                currentPlayer = CurrentState.O;

            } else {
                currentPlayer = CurrentState.X;
            }

        }
    }


}


