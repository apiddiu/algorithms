package com.aldo.experiments.algorithms;

import java.util.HashSet;
import java.util.Set;

public class Maze {

    public static int findMinNumSteps(int[][] maze, int rows, int columns, int exitRow, int exitCol
    ) {
        int steps = 0;
        Set<Position> positions = new HashSet<>();
        positions.add(new Position(0, 0));
        Position exit = new Position(exitRow, exitCol);

        while (true) {
            if(positions.stream().anyMatch(p->p.equals(exit))) return steps;

            int availableMoves = positions.size();
            moves(maze, rows, columns, positions);

            if(positions.size()<=availableMoves)
                break;
            ++steps;
        }


        return -1;
    }

    private static void moves(int[][] maze, int rows, int columns, Set<Position> positions) {
        Set<Position> newpositions = new HashSet<>();

        for (Position p : positions) {
            handlePosition(maze, rows, columns, newpositions, p.up());
            handlePosition(maze, rows, columns, newpositions, p.down());
            handlePosition(maze, rows, columns, newpositions, p.left());
            handlePosition(maze, rows, columns, newpositions, p.right());
        }

        positions.addAll(newpositions);
    }

    private static void handlePosition(int[][] maze, int rows, int columns,
        Set<Position> newpositions, Position p
    ) {
        if (inBounds(p, rows, columns) && allowedPosition(p, maze)) {
            newpositions.add(p);
        }
    }

    private static boolean allowedPosition(Position p, int[][] maze) {
        return maze[p.row][p.col] == 0;
    }

    private static boolean inBounds(Position p, int rows, int columns) {
        return (p.row >= 0 && p.row < rows) && (p.col >= 0 && p.col < columns);
    }

    static class Position {
        public int row;
        public int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Position p = (Position) o;

            return row == p.row && col == p.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }

        public Position up() {
            return new Position(row - 1, col);
        }

        public Position down() {
            return new Position(row + 1, col);
        }

        public Position left() {
            return new Position(row, col - 1);
        }

        public Position right() {
            return new Position(row, col + 1);
        }
    }
}
