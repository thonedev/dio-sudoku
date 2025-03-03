package boardgame;

import java.util.ArrayList;
import java.util.List;

import sudoku.SudokuGenerator;

public class Board {
    private int rows;
    private int columns;
    private List<List<Position>> positions;

    public Board(int rows, int columns, SudokuGenerator.Difficulty level) {

        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }

        this.rows = rows;
        this.columns = columns;

        positions = SudokuGenerator.generateSudoku(level);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<List<Position>> getPositions() {
        return positions;
    }
}
