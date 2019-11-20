package com.packetpublishing.tddjava.ch03tictactoe.mongo;

/**
 * Created by lj1218.
 * Date: 2019/11/20
 */
public class TicTacToeBean {
    private int turn;
    private int x;
    private int y;
    private char player;

    public TicTacToeBean(int turn, int x, int y, char player) {
        this.turn = turn;
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public int getTurn() {
        return turn;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getPlayer() {
        return player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicTacToeBean that = (TicTacToeBean) o;
        if (player != that.player) return false;
        if (turn != that.turn) return false;
        if (x != that.x) return false;
        if (y != that.y) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = turn;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + (int) player;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Turn: %d; X: %d; Y: %d; Player: %s", turn, x, y, player);
    }
}
