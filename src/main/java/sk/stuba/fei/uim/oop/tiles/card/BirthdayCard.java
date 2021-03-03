package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.player.Player;

public class BirthdayCard extends Card {

    @Override
    public void activate(Player player) {
        System.out.println("You have birthday TODAY, you get 1000.");
        player.addMoney(1000);
    }
}
