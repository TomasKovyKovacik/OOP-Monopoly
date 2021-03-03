package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.player.Player;

public class Start extends Tile {

    @Override
    public void activate(Player player) {
        System.out.println("Im standing on Start, give me my money!");
    }
}
