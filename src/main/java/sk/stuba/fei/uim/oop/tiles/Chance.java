package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chance extends Tile {
    private final List<Card> cards;
    private final List<Card> discard;

    private final Random random;

    public Chance(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
        this.discard = new ArrayList<>();
        this.random = new Random();
    }

    @Override
    public void activate(Player player) {
        System.out.println("You Stand on Chance, you drawing a card...");
        if (this.cards.isEmpty()) {
            this.cards.addAll(this.discard);
            this.discard.clear();
        }
        Card pickedCard = this.cards.remove(this.random.nextInt(this.cards.size()));
        pickedCard.activate(player);
        this.discard.add(pickedCard);
    }
}
