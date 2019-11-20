package com.packetpublishing.tddjava.ch03tictactoe;

import com.packetpublishing.tddjava.ch03tictactoe.mongo.TicTacToeBean;
import com.packetpublishing.tddjava.ch03tictactoe.mongo.TicTacToeCollection;

import java.net.UnknownHostException;

/**
 * Created by lj1218.
 * Date: 2019/11/18
 */
public class TicTacToe {

    private static final int SIZE = 3;

    public static final String NO_WINNER = "No winner";

    public static final String RESULT_DRAW = "The result is draw";

    private char[][] board;

    private char lastPlayer;

    private int turn;

    private TicTacToeCollection ticTacToeCollection;

    public TicTacToe() throws UnknownHostException {
        this(new TicTacToeCollection());
    }

    protected TicTacToe(TicTacToeCollection collection) {
        ticTacToeCollection = collection;
        board = new char[3][3];
        if (!ticTacToeCollection.drop()) {
            throw new RuntimeException("Dropping DB collection failed");
        }
    }

    public TicTacToeCollection getTicTacToeCollection() {
        return ticTacToeCollection;
    }

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(new TicTacToeBean(turn, x, y, lastPlayer));
        if (isWin(x, y)) {
            return lastPlayer + " is the winner";
        } else if (isDraw()) {
            return RESULT_DRAW;
        }
        return NO_WINNER;
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("Axis is outside board");
        }
    }

    private void setBox(TicTacToeBean bean) {
        if (board[bean.getX() - 1][bean.getY() - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        }
        board[bean.getX() - 1][bean.getY() - 1] = lastPlayer;
        if (!getTicTacToeCollection().saveMove(bean)) {
            throw new RuntimeException("Save to DB failed");
        }
    }

    char nextPlayer() {
        ++turn;
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

    private boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * 3;
        int horizontal = 0;
        int vertical = 0;
        int diagonal1 = 0;
        int diagonal2 = 0;
        for (int i = 0; i < SIZE; i++) {
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }
        return horizontal == playerTotal || vertical == playerTotal
                || diagonal1 == playerTotal || diagonal2 == playerTotal;
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
}
