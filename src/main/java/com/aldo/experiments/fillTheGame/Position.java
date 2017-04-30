package com.aldo.experiments.fillTheGame;

public class Position {
    public final int row;
    public final int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position n() {
        return new Position(row - 3, col);
    }

    public Position s() {
        return new Position(row + 3, col);
    }

    public Position e() {
        return new Position(row, col + 3);
    }

    public Position w() {
        return new Position(row, col - 3);
    }

    //---------------------------------------

    public Position ne() {
        return new Position(row - 2, col + 2);
    }

    public Position se() {
        return new Position(row + 2, col + 2);
    }

    public Position nw() {
        return new Position(row - 2, col - 2);
    }

    public Position sw() {
        return new Position(row + 2, col - 2);
    }

    @Override
    public boolean equals(Object obj) {
        Position other = (Position) obj;
        return row == other.row && col == other.col;
    }

    @Override
    public int hashCode() {
        return row * 1000 * col;
    }
}
