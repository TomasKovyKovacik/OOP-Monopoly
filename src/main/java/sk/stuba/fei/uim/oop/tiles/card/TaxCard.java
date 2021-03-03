package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.player.Player;

public class TaxCard extends Card {
    @Override
    public void activate(Player player) {
        System.out.println("You need to pay 20% of your money as taxes!");
        player.payMoney((int) (player.getMoney() * 0.2));
    }
}
