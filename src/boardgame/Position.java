package boardgame;

import java.util.ArrayList;
import java.util.List;

public class Position {

    private int row;
    private int column;

    private Boolean changeble = true;

    private List<Integer> possibleMoves = new ArrayList<>();
    private Integer value;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Position(int row, int column, Integer value) {
        this.row = row;
        this.column = column;
        this.value = value;
        this.changeble = !(value != null);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public String getValueToString() {
        return value == null ? " - " : String.format(" %d ", value);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Position position))
            return false;

        if (getRow() != position.getRow())
            return false;
        return getColumn() == position.getColumn();
    }

    @Override
    public int hashCode() {
        int result = getRow();
        result = 31 * result + getColumn();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%d, %d", this.row, this.column);
    }

    public Boolean getChangeble() {
        return changeble;
    }

    public List<Integer> getPossibleMoves() {
        return possibleMoves;
    }

}
