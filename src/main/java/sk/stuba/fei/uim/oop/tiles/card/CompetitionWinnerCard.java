package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.player.Player;

public class CompetitionWinnerCard extends Card {

    @Override
    public void activate(Player player) {
        System.out.println("You WIN in LOL competition, you get 3000.");
        player.addMoney(3000);
    }
}
