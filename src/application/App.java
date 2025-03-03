package application;

import java.util.Scanner;

import sudoku.SudokuGame;

public class App {
    public static void main(String[] args) throws Exception {
        var sc = new Scanner(System.in);
        var sudokuGame = new SudokuGame();

        while (!sudokuGame.isFinished()) {
            try {
                UI.clearScreen();
                UI.printBoard(sudokuGame.getPositions(), null);
                System.out.println();
                System.out.print("Position: ");
                var position = UI.readPosition(sc, sudokuGame.getPositions());

                UI.clearScreen();
                UI.printBoard(sudokuGame.getPositions(), position);
                if (position.getChangeble()) {
                    System.out.print("New Value: ");
                    var v = sc.nextInt();
                    sc.nextLine();
                    sudokuGame.makeMove(position, v);
                    if (sudokuGame.hasErrors())
                        System.err.println("err");
                } else {
                    sc.nextLine();
                }

            } catch (Exception e) {
                System.err.println(e.getMessage());
                sc.nextLine();
            }

        }
        UI.clearScreen();
        UI.printBoard(sudokuGame.getPositions(), null);

        System.out.println("Parabéns você venceu");

    }
}
