package com.aldo.experiments.fillTheGame;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Game {
    public void solve(int size) {
        Queue<Board> solutions = new LinkedList<>();
        solutions.add(new Board(size));
        int steps = size * size;

        while (--steps > 0) {
            System.out.println(steps);
            Queue<Board> s = new LinkedList<>();
            Set<Board> set = new HashSet<>();

            while (!solutions.isEmpty()) {
                s.addAll(solutions.poll().next());
            }
            //s.addAll(set);
            solutions = s;
            System.out.println(s.size());
            System.out.println("---------------------------");
        }

        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println(solutions.size());
        while (!solutions.isEmpty()) {
            System.out.println("---------------------------");
            System.out.println(solutions.poll());
            System.out.println("---------------------------");
        }
    }
}
