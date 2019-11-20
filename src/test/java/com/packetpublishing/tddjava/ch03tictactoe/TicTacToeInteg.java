package com.packetpublishing.tddjava.ch03tictactoe;

import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;

/**
 * Created by lj1218.
 * Date: 2019/11/20
 */
public class TicTacToeInteg {

    @Test
    public void givenMongoDbIsRunningWhenPlayThenNoException() throws UnknownHostException {
        TicTacToe ticTacToe = new TicTacToe();
        assertEquals(TicTacToe.NO_WINNER, ticTacToe.play(1, 1));
    }

}
