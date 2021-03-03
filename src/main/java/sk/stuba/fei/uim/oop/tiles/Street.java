package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Street extends Property {

    public Street(int propertyPrice, int paymentAmount, String name) {
        super(propertyPrice, paymentAmount, name);
    }

    @Override
    public void activate(Player player) {
        super.activate(player);
        if (this.owner == null) {
            super.wantBuyProperty(player);
        } else if (player == this.owner) {
            System.out.println("You stand on your own property!");
        } else {
            player.payMoney(this.paymentAmount, this.owner);
        }
    }
}
