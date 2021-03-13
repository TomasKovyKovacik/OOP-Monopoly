package sk.stuba.fei.uim.oop.monopoly;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.*;
import sk.stuba.fei.uim.oop.tiles.card.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import java.util.List;

public class Monopoly {
    private final Player[] players;
    private Tile[] board;
    private int currentPlayer;
    private int roundCounter;

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
        List<Card> chanceCards = List.of(
                new BirthdayCard(),
                new CarRepairCard(),
                new GoToPrisonCard(6),
                new TaxCard(),
                new CompetitionWinnerCard()
        );
        Chance chance = new Chance(chanceCards);
        this.board = new Tile[] {
                new Start(),
                new Street(5000, 1000, "Red Street"),
                new Street(5500, 1100, "Blue Street"),
                chance,
                new Street(6000, 1200, "Green Street"),
                new Street(6500, 1300, "Yellow Street"),
                new Prison(),
                new Street(6000, 1200, "West Street"),
                new Street(6500, 1300, "East Street"),
                chance,
                new Street(7000, 1400, "South Street"),
                new Street(7500, 1500, "North Street"),
                new IncomeTax(2000),
                new Street(7500, 1500, "Morning Street"),
                new Street(8000, 1600, "Noon Street"),
                chance,
                new Street(8500, 1700, "Evening Street"),
                new Street(9000, 1800, "Midnight Street"),
                new Police(6),
                new Street(10000, 2000, "Typescript Street"),
                new Street(12000, 2500, "C++ Street"),
                chance,
                new Street(14000, 3000, "Python Street"),
                new Street(16000, 3500, "Java Street")
        };
    }

    private void startGame() {

        System.out.println("--- GAME STARTED ---");
        for (this.currentPlayer = 0;getNumberActivePlayers() > 1;this.incrementCounter()) {
            if (this.currentPlayer == 0) {
                System.out.println("--- ROUND " + (this.roundCounter / this.players.length + 1) + " STARTS ---");
            }
            Player activePlayer = this.players[this.currentPlayer];
            if (!activePlayer.isActive()) {
                continue;
            }
            System.out.println("--- PLAYER " + activePlayer.getName() + " STARTS TURN ---");
            System.out.println("Players money: " + activePlayer.getMoney());
            if (activePlayer.inPrison()) {
                activePlayer.decrementPrison();
                endTurn(activePlayer);
                continue;
            }
            this.board[activePlayer.throwDice(this.board.length)].activate(activePlayer);
            endTurn(activePlayer);
        }
        System.out.println("--- GAME FINISHED ---");
        System.out.println("And the WINNER is " + getWinner().getName());
    }

    private void incrementCounter() {
        this.currentPlayer++;
        this.currentPlayer %= this.players.length;
        this.roundCounter++;
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

    private void endTurn(Player activePlayer) {
        System.out.println("--- PLAYER " + activePlayer.getName() + " ENDS TURN ---\n");
        ZKlavesnice.readString("Press Enter To Continue");
    }
}
