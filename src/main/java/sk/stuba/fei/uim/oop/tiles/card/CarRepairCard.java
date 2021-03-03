package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.player.Player;

public class CarRepairCard extends Card {
    @Override
    public void activate(Player player) {
        System.out.println("Your car is broken! You need to pay for repair 2000!");
        player.payMoney(2000);
    }
}
