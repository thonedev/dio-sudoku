package boardgame;

import java.util.ArrayList;
import java.util.List;

import sudoku.SudokuGenerator;

public class Board {
    private int rows;
    private int columns;
    private List<List<Position>> positions;

    public Board(int rows, int columns) {

        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }

        this.rows = rows;
        this.columns = columns;
        positions = List.of(
                List.of(
                        new Position(0, 0, 8),
                        new Position(0, 1, 3),
                        new Position(0, 2),
                        new Position(0, 3),
                        new Position(0, 4, 6),
                        new Position(0, 5),
                        new Position(0, 6),
                        new Position(0, 7, 2),
                        new Position(0, 8, 1)),
                List.of(
                        new Position(1, 0),
                        new Position(1, 1),
                        new Position(1, 2, 1),
                        new Position(1, 3, 8),
                        new Position(1, 4),
                        new Position(1, 5),
                        new Position(1, 6, 9),
                        new Position(1, 7),
                        new Position(1, 8)),
                List.of(
                        new Position(2, 0),
                        new Position(2, 1, 6),
                        new Position(2, 2, 4),
                        new Position(2, 3, 1),
                        new Position(2, 4),
                        new Position(2, 5),
                        new Position(2, 6, 5),
                        new Position(2, 7, 7),
                        new Position(2, 8)),
                List.of(
                        new Position(3, 0),
                        new Position(3, 1),
                        new Position(3, 2),
                        new Position(3, 3, 6),
                        new Position(3, 4),
                        new Position(3, 5, 3),
                        new Position(3, 6, 8),
                        new Position(3, 7, 5),
                        new Position(3, 8)),
                List.of(
                        new Position(4, 0, 3),
                        new Position(4, 1),
                        new Position(4, 2),
                        new Position(4, 3),
                        new Position(4, 4),
                        new Position(4, 5),
                        new Position(4, 6),
                        new Position(4, 7),
                        new Position(4, 8, 7)),
                List.of(
                        new Position(5, 0),
                        new Position(5, 1, 5),
                        new Position(5, 2, 8),
                        new Position(5, 3, 7),
                        new Position(5, 4),
                        new Position(5, 5, 1),
                        new Position(5, 6),
                        new Position(5, 7),
                        new Position(5, 8)),
                List.of(
                        new Position(6, 0),
                        new Position(6, 1, 8),
                        new Position(6, 2, 3),
                        new Position(6, 3),
                        new Position(6, 4),
                        new Position(6, 5, 6),
                        new Position(6, 6, 1),
                        new Position(6, 7, 9),
                        new Position(6, 8)),
                List.of(
                        new Position(7, 0),
                        new Position(7, 1),
                        new Position(7, 2, 6),
                        new Position(7, 3),
                        new Position(7, 4),
                        new Position(7, 5, 5),
                        new Position(7, 6, 2),
                        new Position(7, 7),
                        new Position(7, 8)),
                List.of(
                        new Position(8, 0, 4),
                        new Position(8, 1, 2),
                        new Position(8, 2),
                        new Position(8, 3),
                        new Position(8, 4, 1),
                        new Position(8, 5),
                        new Position(8, 6),
                        new Position(8, 7, 6),
                        new Position(8, 8, 5)));

        positions = SudokuGenerator.generateSudoku(SudokuGenerator.Difficulty.EASY);

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

    // public Piece piece(int row, int column) {
    // if (!positionExists(row, column)) {
    // throw new BoardException("Position not on the board!");
    // }

    // return pieces[row][column];
    // }

    // public Piece piece(Position position) {
    // if (!positionExists(position.getRow(), position.getColumn())) {
    // throw new BoardException("Position not on the board!");
    // }

    // return pieces[position.getRow()][position.getColumn()];
    // }

    // public void placePiece(Piece piece, Position position) {
    // if (thereIsAPiece(position)) {
    // throw new BoardException("There is already a piece on position: " +
    // position);
    // }

    // pieces[position.getRow()][position.getColumn()] = piece;
    // piece.position = position;
    // }

    // public Piece removePiece(Position position) {
    // if (!positionExists(position)) {
    // throw new BoardException("Position not on the board!");
    // }

    // var piece = piece(position);
    // if (piece == null)
    // return null;
    // piece.position = null;
    // pieces[position.getRow()][position.getColumn()] = null;
    // return piece;
    // }

    // public boolean positionExists(Position position) {
    // return positionExists(position.getRow(), position.getColumn());
    // }

    // public boolean thereIsAPiece(Position position) {
    // if (!positionExists(position)) {
    // throw new BoardException("Position not on the board!");
    // }

    // return piece(position) != null;
    // }

    // private boolean positionExists(int row, int column) {
    // return row >= 0 && row < rows && column >= 0 && column < columns;
    // }
}
