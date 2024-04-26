package com.neel;


import com.neel.controllers.GameController;
import com.neel.exceptions.InvalidMoveException;
import com.neel.Models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {

        System.out.println("Welcome to Tic-Tac-Toe Game!");
//        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        int dimension = 3;
        List<Player> players = List.of(
                new Player("Neel", new Symbol('1'), PlayerType.HUMAN),
                new Bot("DC", new Symbol('0'), PlayerType.BOT, BotDifficultyLevel.HARD)

        );

        Game game = gameController.startGame(dimension, players);
        //gameController.printBoard(game);

        while (game.getGameState().equals(GameState.IN_PROGRESS)) {
            //1. print the board.
            gameController.printBoard(game);

            //2. Player's turn
            gameController.makeMove(game);
        }

        if (!gameController.checkState(game).equals(GameState.ENDED)) {
            game.setGameState(GameState.DRAW);
            System.out.println("Game DRAW");
        } else {
            gameController.printBoard(game);
            System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");
        }
    }

}