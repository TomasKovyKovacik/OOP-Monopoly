package sk.stuba.fei.uim.oop.player;

import java.util.Random;

public class Player {
    private int money;
    private int position;
    private boolean active;

    private Random dice;

    public Player() {
        this.money = 20000;
        this.position = 0;
        this.dice = new Random();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int throwDice(int tileLength) {
        this.position += 1 + dice.nextInt(6);
        this.position %= tileLength;
        return position;
    }
}
