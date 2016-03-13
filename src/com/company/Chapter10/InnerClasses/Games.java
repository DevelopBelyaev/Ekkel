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

    private Checkers() {

    }

    private int moves = 0;
    public static final int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("Checkers moves = " + moves);
        return ++moves != MOVES;
    }
    public static GameFactory factory = () -> new Checkers();
}

class Chess implements Game {

    private Chess(){}
    private int moves = 0;
    public static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Ches moves = "  + moves);
        return ++moves != MOVES;
    }
    public static GameFactory factory = () -> new Chess();
}

public class Games {
    public static void playGame(GameFactory factory) {
        Game game = factory.getGame();
        while (game.move());
    }

    public static void main(String[] args) {
        playGame(Checkers.factory);
        playGame(Chess.factory);
    }
}
