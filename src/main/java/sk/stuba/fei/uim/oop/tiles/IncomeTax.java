package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.player.Player;

public class IncomeTax extends Tile {
    private final int tax;

    public IncomeTax(int tax) {
        this.tax = tax;
    }

    @Override
    public void activate(Player player) {
        System.out.println("You need to pay taxes!");
        player.payMoney(this.tax);
    }
}
