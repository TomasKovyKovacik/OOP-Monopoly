package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.player.Player;

public class Prison extends Tile {
    @Override
    public void activate(Player player) {
        System.out.println("Im here to visit prisoners");
    }
}
