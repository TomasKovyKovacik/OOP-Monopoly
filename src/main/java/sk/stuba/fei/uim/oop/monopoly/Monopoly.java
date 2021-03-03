package sk.stuba.fei.uim.oop.monopoly;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Monopoly {
    private Player[] players;
    private Tile[] board;
    private int currentPlayer;

    public Monopoly() {
        System.out.println("Welcome to FEI MONOPOLY");
        int numberPlayers = ZKlavesnice.readInt("Enter number of players: ");
        this.players = new Player[numberPlayers];
        for (int i = 0; i < numberPlayers; i++) {
            this.players[i] = new Player(ZKlavesnice.readString("Enter PLAYER " + (i + 1) + " name:"));
        }
        this.initializeBoard();
        this.startGame();
    }

    private void initializeBoard() {
        this.board = new Tile[] {
                new Start(),
                new Street(5000, 1000, "Red Street"),
                new Street(5500, 1100, "Blue Street"),
                new Chance(),
                new Street(6000, 1200, "Green Street"),
                new Street(6500, 1300, "Yellow Street"),
                new Prison(),
                new Street(6000, 1200, "West Street"),
                new Street(6500, 1300, "East Street"),
                new Chance(),
                new Street(7000, 1400, "South Street"),
                new Street(7500, 1500, "North Street"),
                new IncomeTax(),
                new Street(7500, 1500, "Morning Street"),
                new Street(8000, 1600, "Noon Street"),
                new Chance(),
                new Street(8500, 1700, "Evening Street"),
                new Street(9000, 1800, "Midnight Street"),
                new Police(),
                new Street(10000, 2000, "Typescript Street"),
                new Street(12000, 2500, "C++ Street"),
                new Chance(),
                new Street(14000, 3000, "Python Street"),
                new Street(16000, 3500, "Java Street")
        };
    }

    private void startGame() {
        System.out.println("--- GAME STARTED ---");
        for (this.currentPlayer = 0;getNumberActivePlayers() > 1;this.incrementCounter()) {
            Player activePlayer = this.players[this.currentPlayer];
            if (!activePlayer.isActive()) {
                continue;
            }
            System.out.println("--- PLAYER " + activePlayer.getName() + " ---");
            System.out.println("Players money " + activePlayer.getMoney());
            if (activePlayer.inPrison()) {
                activePlayer.decrementPrison();
                continue;
            }
            this.board[activePlayer.throwDice(this.board.length)].activate(activePlayer);
            System.out.println("--- PLAYER " + activePlayer.getName() + " ENDS TURN ---");
//            ZKlavesnice.readString("Press Any Key To Continue");
        }
        System.out.println("--- GAME FINISHED ---");
        System.out.println("And the winner is " + getWinner().getName());
    }

    private void incrementCounter() {
        this.currentPlayer++;
        this.currentPlayer %= this.players.length;
    }

    private int getNumberActivePlayers() {
        int count = 0;
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i].isActive()) {
                count++;
            }
        }
        return count;
    }

    private Player getWinner() {
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i].isActive()) {
                return this.players[i];
            }
        }
        return null;
    }
}
