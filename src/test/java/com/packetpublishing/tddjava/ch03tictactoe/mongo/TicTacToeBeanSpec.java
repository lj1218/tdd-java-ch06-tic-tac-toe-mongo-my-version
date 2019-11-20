package com.packetpublishing.tddjava.ch03tictactoe.mongo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lj1218.
 * Date: 2019/11/20
 */
public class TicTacToeBeanSpec {

    private TicTacToeBean bean;
    private static final int turn = 17;
    private static final int x = 2;
    private static final int y = 3;
    private static final char player = 'X';

    @Before
    public void before() {
        bean = new TicTacToeBean(turn, x, y, player);
    }

    @Test
    public void whenInstantiatedThenIdIsStored() {
        assertEquals(turn, bean.getTurn());
    }

    @Test
    public void whenInstantiatedThenXIsStored() {
        assertEquals(x, bean.getX());
    }

    @Test
    public void whenInstantiatedThenYIsStored() {
        assertEquals(y, bean.getY());
    }

    @Test
    public void whenInstantiatedThenPlayerIsStored() {
        assertEquals(player, bean.getPlayer());
    }

}
