package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.player.Player;

public class GoToPrisonCard extends Card {

    @Override
    public void activate(Player player) {
        System.out.println("Go to PRISON for 3 rounds!");
        player.setTurnsInPrison(3);
    }
}
