package com.aldo.experiments.fillTheGame;

import java.util.HashSet;
import java.util.Set;

public class Board {
    private int[][] board;
    private Position position;
    private int value;


    public Board(int size) {
        this(new int[size][size], new Position(0, 0), 1);
    }

    private Board(int[][] board, Position position, int value) {
        this.board = board;
        this.position = position;
        this.value = value;
        this.board[position.row][position.col] = value;
    }

    public Set<Board> next() {
        HashSet<Board> nextBoards = new HashSet<>();

        move(position.n(), nextBoards);
        move(position.s(), nextBoards);
        move(position.e(), nextBoards);
        move(position.w(), nextBoards);
        move(position.ne(), nextBoards);
        move(position.se(), nextBoards);
        move(position.nw(), nextBoards);
        move(position.sw(), nextBoards);

        return nextBoards;
    }

    private void move(Position p, Set<Board> s) {
        if (inBound(p)) {
            s.add(new Board(clone(board), p, value + 1));
        }
    }

    private boolean inBound(Position p) {
        return p.row >= 0 && p.row < board.length &&
                p.col >= 0 && p.col < board.length &&
                board[p.row][p.col] == 0;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int[] row : board) {
            sb.append(" | ");
            for (int i : row) {
                sb.append(padLeft(String.valueOf(i)) + " | ");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    String padLeft(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3 - s.length(); i++) {
            sb.append(" ");
        }

        sb.append(s);
        return sb.toString();
    }

    private int[][] clone(int[][] a) {
        int[][] b = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i].clone();
        }

        return b;
    }

    @Override
    public boolean equals(Object obj) {
        Board other = (Board) obj;
        boolean eq = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if( (board[i][j]==0 && other.board[i][j]!=0)
                     ||   (board[i][j]!=0 && other.board[i][j]==0))
                    eq = false;
            }
        }

        return eq && position.equals(other.position);
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }
}
