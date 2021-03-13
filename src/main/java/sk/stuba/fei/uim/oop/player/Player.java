package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.tiles.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private final String name;
    private int money;
    private int position;
    private boolean active;
    private int turnsInPrison;
    private List<Property> properties;

    private Random dice;

    public Player(String name) {
        this.name = name;
        this.money = 20000;
        this.position = 0;
        this.dice = new Random();
        this.properties = new ArrayList<>();
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean inPrison() {
        return turnsInPrison != 0;
    }

    public void decrementPrison() {
        System.out.println("Player spend time in prison for another " + this.turnsInPrison + " turns");
        this.turnsInPrison--;
    }

    public void setTurnsInPrison(int turnsInPrison, int prisonPosition) {
        this.turnsInPrison = turnsInPrison;
        this.position = prisonPosition;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int throwDice(int tileLength) {
        int roll = 1 + dice.nextInt(6);
        System.out.println("You rolled: " + roll);
        this.position += roll;
        if (this.position >= tileLength) {
            System.out.println("You get 500 money for passing trought START tile!");
            this.money += 500;
        }
        this.position %= tileLength;
        return position;
    }

    public void payMoney(int amount, Player receiver) {
        System.out.println(this.name + " must pay amount " + amount + " to " + (receiver != null ? receiver.getName() : "THE BANK"));
        if (this.money < amount) {
            System.out.println("Don't have enough money for pay! YOU LOSE");
            this.active = false;
            this.removeProperties();
            if (receiver != null) {
                receiver.addMoney(this.money);
            }
        } else {
            this.money -= amount;
            if (receiver != null) {
                receiver.addMoney(amount);
            }
        }
    }

    public void payMoney(int amount) {
        this.payMoney(amount, null);
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public void addProperty(Property property) {
        this.properties.add(property);
    }

    private void removeProperties() {
        this.properties.forEach(Property::removeOwner);
        this.properties.clear();
    }
}
