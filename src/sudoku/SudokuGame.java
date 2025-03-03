package sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import boardgame.Board;
import boardgame.Position;

public class SudokuGame {
    private Board board;
    private boolean finished;

    public SudokuGame() {
        board = new Board(9, 9);
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
        // verify lines
        for (var line : getPositions()) {
            var set = new HashSet<>(
                    line.stream().filter(c -> c.getValue() != null && c.getValue() >= 1 && c.getValue() <= 9)
                            .map(c -> c.getValue()).toList());
            if (set.size() != 9)
                return true;
        }

        // verify column
        var set = new HashSet<Integer>();
        for (int i = 0; i < 9; i++) {
            for (var line : getPositions()) {
                set.add(line.get(i).getValue());
            }
        }
        if (set.size() != 9)
            return true;

        // veryfy 00 quadrant
        set = new HashSet<Integer>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.add(getPositions().get(i).get(j).getValue());
            }
        }
        if (set.size() != 9)
            return true;

        // veryfy 01 quadrant
        set = new HashSet<Integer>();
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                set.add(getPositions().get(i).get(j).getValue());
            }
        }
        if (set.size() != 9)
            return true;

        // veryfy 02 quadrant
        set = new HashSet<Integer>();
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                set.add(getPositions().get(i).get(j).getValue());
            }
        }
        if (set.size() != 9)
            return true;

        // veryfy [1][0] quadrant
        set = new HashSet<Integer>();
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                set.add(getPositions().get(i).get(j).getValue());
            }
        }
        if (set.size() != 9)
            return true;

        // veryfy [1][1] quadrant
        set = new HashSet<Integer>();
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                set.add(getPositions().get(i).get(j).getValue());
            }
        }
        if (set.size() != 9)
            return true;

        // veryfy [1][2] quadrant
        set = new HashSet<Integer>();
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                set.add(getPositions().get(i).get(j).getValue());
            }
        }
        if (set.size() != 9)
            return true;

        // veryfy [2][0] quadrant
        set = new HashSet<Integer>();
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                set.add(getPositions().get(i).get(j).getValue());
            }
        }
        if (set.size() != 9)
            return true;

        // veryfy [2][1] quadrant
        set = new HashSet<Integer>();
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                set.add(getPositions().get(i).get(j).getValue());
            }
        }
        if (set.size() != 9)
            return true;

        // veryfy [2][2] quadrant
        set = new HashSet<Integer>();
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                set.add(getPositions().get(i).get(j).getValue());
            }
        }
        if (set.size() != 9)
            return true;

        return false;
    }

}
