package com.aldo.experiments.algorithms;

import org.junit.Test;

public class MazeTest {

    @Test
    public void testMaze(){
        int maze[][] = new int[][] {{0,0,0}, {0,1,0}, {1,0,1}};

        System.out.println(Maze.findMinNumSteps(maze, 3,3,2,1));
    }

    @Test
    public void testMaze1(){
        int maze[][] = new int[][] {
            {0,0,0},
            {0,1,0},
            {1,0,0}
        };

        System.out.println(Maze.findMinNumSteps(maze, 3,3,2,1));
    }

    @Test
    public void testMaze2(){
        int maze[][] = new int[][] {
            {0,0,0,1,0,0,0,0,0,0,0},
            {0,1,0,1,0,0,0,0,1,1,1},
            {0,1,0,0,1,1,1,0,0,0,0},
            {0,0,1,0,0,0,0,1,1,1,0},
            {1,1,1,1,1,1,0,1,0,0,0},
            {0,0,0,1,0,0,0,1,0,1,1},
            {0,1,0,1,0,1,1,0,0,0,0},
            {0,1,0,0,0,0,1,0,1,1,0},
            {0,1,0,1,1,1,1,0,0,1,0},
            {0,0,1,0,0,0,1,0,0,1,0},
            {1,0,0,0,1,0,0,0,1,0,0},
        };

        System.out.println(Maze.findMinNumSteps(maze, 11,11,0,10));
    }
}
