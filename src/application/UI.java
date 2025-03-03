package application;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import boardgame.Position;

public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() throws InterruptedException, IOException {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.flush();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Position readPosition(Scanner sc, List<List<Position>> positions) {
        try {
            var s = sc.nextLine();
            var column = s.charAt(0) - 'a';
            var row = s.charAt(1) - '0' - 1;
            var p = new Position(row, column);
            for (var line : positions) {
                for (var position : line) {
                    if (position.equals(p))
                        return position;
                }
            }
            throw new Exception();
        } catch (Exception e) {
            throw new InputMismatchException("Error reading Position. Valid values are from a1 to i9.");
        }

    }

    public static void printBoard(List<List<Position>> positions, Position highlight) {
        int i = 1;
        for (var line : positions) {

            System.out.print(i++ + " ");
            int j = 0;
            for (var position : line) {
                if (j != 0 && j % 3 == 0)
                    System.out.print("|");
                printPosition(position, highlight);
                j++;
            }
            System.out.println();
            if ((i - 1) % 3 == 0 && i < 9)
                System.out.println("  " + "---".repeat(positions.get(0).size()) + "--");
        }
        System.out.print("  ");
        for (var j = 0; j < positions.size(); j++) {
            if (j != 0 && j % 3 == 0)
                System.out.print(" ");
            System.out.printf(" %c ", 'a' + j);
        }
        System.out.println();
    }

    public static void printPosition(Position position, Position highlight) {
        if (highlight != null && position.equals(highlight)) {
            if (highlight.getValue() == null) {
                System.out.print(" ");
                System.out.print(ANSI_YELLOW_BACKGROUND);
                System.out.print(ANSI_WHITE + "-" + ANSI_RESET);
                System.out.print(" ");
            } else {
                System.out.print(" ");
                System.out.print(ANSI_YELLOW_BACKGROUND);
                System.out.print(ANSI_WHITE + position.getValue() + ANSI_RESET);
                System.out.print(" ");
            }
        } else if (highlight != null && highlight.getValue() != null && position.getValue() == highlight.getValue()) {
            System.out.print(" ");
            System.out.print(ANSI_BLUE_BACKGROUND);
            System.out.print(ANSI_WHITE + highlight.getValue() + ANSI_RESET);
            System.out.print(" ");
        } else if (position.getValue() != null && !position.getChangeble()) {
            System.out.print(" ");
            System.out.print(ANSI_BLUE + position.getValue() + ANSI_RESET);
            System.out.print(" ");
        } else if (position.getValue() != null && position.getChangeble()) {
            System.out.print(" ");
            System.out.print(ANSI_YELLOW + position.getValue() + ANSI_RESET);
            System.out.print(" ");

        } else {
            System.out.print(position.getValueToString());
        }
    }
}
