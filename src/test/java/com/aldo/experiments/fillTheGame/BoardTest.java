package com.aldo.experiments.fillTheGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board;

    @Before
    public void setup(){
        board = new Board(10);
    }

    @Test
    public void padLeftTest(){
        Assert.assertEquals("  0", board.padLeft("0"));
        Assert.assertEquals(" 10", board.padLeft("10"));
        Assert.assertEquals("210", board.padLeft("210"));
    }

    @Test
    public void toStringTest(){
        System.out.println( board.toString());
    }

    @Test
    public void nextTest(){
        Board b = new Board(4);

        System.out.println(b.next());
    }

    @Test
    public void testSolution(){
        new Game().solve(6);
    }

}
