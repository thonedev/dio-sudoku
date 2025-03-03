package application;

import java.util.Scanner;

import sudoku.SudokuGame;
import sudoku.SudokuGenerator;

public class App {
    public static void main(String[] args) throws Exception {
        var sc = new Scanner(System.in);
        SudokuGame sudokuGame = null;

        int level;

        do {
            System.out.println("Bem-vindo ao Jogo de Sudoku!");
            System.out.println("1. Muito Fácil");
            System.out.println("2. Fácil");
            System.out.println("3. Médio");
            System.out.println("4. Difícil");
            System.out.println("0. Sair");
            System.out.print("Escolha a dificuldade: ");

            level = sc.nextInt();
            sc.nextLine();

            switch (level) {
                case 1:
                    sudokuGame = new SudokuGame(SudokuGenerator.Difficulty.VERY_EASY);
                    break;
                case 2:
                    sudokuGame = new SudokuGame(SudokuGenerator.Difficulty.EASY);
                    break;
                case 3:
                    sudokuGame = new SudokuGame(SudokuGenerator.Difficulty.MEDIUM);
                    break;
                case 4:
                    sudokuGame = new SudokuGame(SudokuGenerator.Difficulty.HARD);
                    break;
                case 0:
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        } while (level < 1 && level > 4);

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
