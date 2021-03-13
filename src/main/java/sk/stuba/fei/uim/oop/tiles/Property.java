package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public abstract class Property extends Tile {
    protected Player owner;
    protected final int propertyPrice;
    protected final int paymentAmount;
    protected final String name;

    public Property(int propertyPrice, int paymentAmount, String name) {
        this.propertyPrice = propertyPrice;
        this.paymentAmount = paymentAmount;
        this.name = name;
    }

    @Override
    public void activate(Player player) {
        System.out.println("You stand on property: " + this.name);
        System.out.println("Property price: " + this.propertyPrice);
        System.out.println("Payment: " + this.paymentAmount);
        if (this.owner == null) {
            System.out.println("Nobody own this property!");
        } else {
            System.out.println("Player " + this.owner.getName() + " owns this property!");
        }
    }

    protected void wantBuyProperty(Player player) {
        if (this.propertyPrice < player.getMoney()) {
            System.out.println("Do you want to buy this property ?");
            System.out.println("Your account state: " + player.getMoney());
            int input = ZKlavesnice.readInt("1 for YES and 0 for NO");
            if (input == 1) {
                this.owner = player;
                player.addProperty(this);
                player.payMoney(this.propertyPrice);
            }
        } else {
            System.out.println("You don't have enough money for buy this property!");
        }
    }

    public void removeOwner() {
        this.owner = null;
    }
}
