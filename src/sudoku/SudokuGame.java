package sudoku;

import java.util.List;

import boardgame.Board;
import boardgame.Position;

public class SudokuGame {
    private Board board;

    public SudokuGame(SudokuGenerator.Difficulty level) {
        board = new Board(9, 9, level);
    }

    public Board getBoard() {
        return board;
    }

    public List<List<Position>> getPositions() {
        return board.getPositions();
    }

    public boolean isFinished() {
        return allHasValue() && !hasErrors();
    }

    public void makeMove(Position position, int value) {
        if (position.getChangeble()) {
            position.setValue(value);
        }
    }

    private boolean allHasValue() {
        for (var line : getPositions()) {
            for (var position : line) {
                if (position.getValue() == null) {

                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasErrors() {
        int[][] board = convertToMatrix();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int number = board[row][col];

                if (number != 0) {
                    board[row][col] = 0;

                    if (!isValid(board, row, col, number)) {
                        return true;
                    }

                    board[row][col] = number;
                }
            }
        }
        return false;
    }

    private int[][] convertToMatrix() {
        int[][] matrix = new int[9][9];
        List<List<Position>> positions = getPositions();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Integer value = positions.get(row).get(col).getValue();
                matrix[row][col] = (value == null) ? 0 : value;
            }
        }
        return matrix;
    }

    private boolean isValid(int[][] board, int row, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

}
