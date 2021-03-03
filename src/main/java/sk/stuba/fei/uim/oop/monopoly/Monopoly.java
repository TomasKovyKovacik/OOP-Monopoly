package sk.stuba.fei.uim.oop.monopoly;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Monopoly {
    private Player[] players;
    private Tile[] board;

    public Monopoly() {
        System.out.println("Welcome to FEI MONOPOLY");
        int numberPlayers = ZKlavesnice.readInt("Enter number of players: ");
        this.players = new Player[numberPlayers];
        for (int i = 0; i < numberPlayers; i++) {
            this.players[i] = new Player();
        }
        initializeBoard();
        startGame();
    }

    private void initializeBoard() {
        this.board = new Tile[] {
                new Start(), new Street(), new Street(), new Chance(), new Street(), new Street(),
                new Prison(), new Street(), new Street(), new Chance(), new Street(), new Street(),
                new Prison(), new Street(), new Street(), new Chance(), new Street(), new Street(),
                new Police(), new Street(), new Street(), new Chance(), new Street(), new Street()
        };
    }

    private void startGame() {
        while(getNumberActivePlayers() > 1) {

        }
    }

    private int getNumberActivePlayers() {
        int count = 0;
        for (int i = 0; i < this.players.length; i++) {
            if (players[i].isActive()) {
                count++;
            }
        }
        return count;
    }
}
