package com.packetpublishing.tddjava.ch03tictactoe.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;

/**
 * Created by lj1218.
 * Date: 2019/11/20
 */
public class TicTacToeCollection {

    private MongoCollection mongoCollection;

    public TicTacToeCollection() throws UnknownHostException {
        DB db = new MongoClient().getDB("tic-tac-toe");
        mongoCollection = new Jongo(db).getCollection("game");
    }

    protected MongoCollection getMongoCollection() {
        return mongoCollection;
    }

    public boolean saveMove(TicTacToeBean bean) {
        try {
            getMongoCollection().save(bean);
        } catch (MongoException ex) {
            return false;
        }
        return true;
    }

    public boolean drop() {
        try {
            getMongoCollection().drop();
        } catch (MongoException ex) {
            return false;
        }
        return true;
    }

}
