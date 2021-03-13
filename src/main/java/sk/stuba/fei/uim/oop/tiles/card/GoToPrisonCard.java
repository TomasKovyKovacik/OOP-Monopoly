package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.player.Player;

public class GoToPrisonCard extends Card {

    private int prisonPosition;

    public GoToPrisonCard(int prisonPosition) {
        this.prisonPosition = prisonPosition;
    }

    @Override
    public void activate(Player player) {
        System.out.println("Go to PRISON for 3 rounds!");
        player.setTurnsInPrison(3, this.prisonPosition);
    }
}
