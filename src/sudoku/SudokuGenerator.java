package sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import boardgame.Position;

public class SudokuGenerator {

    private static final int GRID_SIZE = 9;
    private static final int EMPTY_CELL = 0;

    public static List<List<Position>> generateSudoku(Difficulty difficulty) {
        int[][] board = generateSolvedBoard();
        int[][] puzzle = generatePuzzle(board, difficulty);
        return convertToPositionList(puzzle);
    }

    private static int[][] generateSolvedBoard() {
        int[][] board = new int[GRID_SIZE][GRID_SIZE];
        solveSudoku(board);
        return board;
    }

    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == EMPTY_CELL) {
                    List<Integer> numbers = new ArrayList<>();
                    for (int i = 1; i <= GRID_SIZE; i++) {
                        numbers.add(i);
                    }
                    Collections.shuffle(numbers);
                    for (int number : numbers) {
                        if (isValid(board, row, col, number)) {
                            board[row][col] = number;
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[row][col] = EMPTY_CELL;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int number) {
        for (int i = 0; i < GRID_SIZE; i++) {
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

    private static int[][] generatePuzzle(int[][] solvedBoard, Difficulty difficulty) {
        int[][] puzzle = new int[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            System.arraycopy(solvedBoard[i], 0, puzzle[i], 0, GRID_SIZE);
        }
        int cellsToRemove = getCellsToRemove(difficulty);
        Random random = new Random();
        while (cellsToRemove > 0) {
            int row = random.nextInt(GRID_SIZE);
            int col = random.nextInt(GRID_SIZE);
            if (puzzle[row][col] != EMPTY_CELL) {
                int temp = puzzle[row][col];
                puzzle[row][col] = EMPTY_CELL;
                if (hasUniqueSolution(puzzle)) {
                    cellsToRemove--;
                } else {
                    puzzle[row][col] = temp;
                }

            }
        }
        return puzzle;
    }

    private static boolean hasUniqueSolution(int[][] puzzle) {
        int[][] copy = new int[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            System.arraycopy(puzzle[i], 0, copy[i], 0, GRID_SIZE);
        }
        List<int[][]> solutions = new ArrayList<>();
        solveSudokuAndStoreSolutions(copy, solutions);
        return solutions.size() == 1;
    }

    private static boolean solveSudokuAndStoreSolutions(int[][] board, List<int[][]> solutions) {
        int[][] solution = new int[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            System.arraycopy(board[i], 0, solution[i], 0, GRID_SIZE);
        }
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == EMPTY_CELL) {
                    for (int number = 1; number <= GRID_SIZE; number++) {
                        if (isValid(board, row, col, number)) {
                            board[row][col] = number;
                            if (solveSudokuAndStoreSolutions(board, solutions)) {
                                return true;
                            } else {
                                board[row][col] = EMPTY_CELL;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        solutions.add(solution);
        return true;
    }

    private static int getCellsToRemove(Difficulty difficulty) {
        return switch (difficulty) {
            case EASY -> 1;
            case MEDIUM -> 50;
            case HARD -> 60;
        };
    }

    private static List<List<Position>> convertToPositionList(int[][] board) {
        List<List<Position>> positionList = new ArrayList<>();
        for (int row = 0; row < GRID_SIZE; row++) {
            List<Position> rowList = new ArrayList<>();
            for (int col = 0; col < GRID_SIZE; col++) {
                int value = board[row][col];
                rowList.add(new Position(row, col, value == EMPTY_CELL ? null : value));
            }
            positionList.add(rowList);
        }
        return positionList;
    }

    public enum Difficulty {
        EASY, MEDIUM, HARD
    }
}