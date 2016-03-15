package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 12.03.16.
 */
interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {

    public static final int MOVES = 3;
    public static GameFactory factory = () -> new Checkers();
    private int moves = 0;

    private Checkers() {

    }

    @Override
    public boolean move() {
        System.out.println("Checkers moves = " + moves);
        return ++moves != MOVES;
    }
}

class Chess implements Game {

    public static final int MOVES = 4;
    public static GameFactory factory = () -> new Chess();
    private int moves = 0;

    private Chess() {
    }

    @Override
    public boolean move() {
        System.out.println("Ches moves = " + moves);
        return ++moves != MOVES;
    }
}

public class Games {
    public static void playGame(GameFactory factory) {
        Game game = factory.getGame();
        while (game.move()) ;
    }

    public static void main(String[] args) {
        playGame(Checkers.factory);
        playGame(Chess.factory);
    }
}
