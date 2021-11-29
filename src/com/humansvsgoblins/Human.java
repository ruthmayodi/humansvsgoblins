package com.humansvsgoblins;

import java.util.Arrays;

public class Human extends Main {
    private double health, armor;
    private boolean isAlive;
    int attack;

    public Human(int[] currentLocation) {
        this.formOf = formOf.HUMAN;
        this.location = currentLocation;
        this.health = 100;
        this.attack = 10;
        this.armor = 5;
        this.icon = ANSI_BLUE + "H" + ANSI_RESET;
        isAlive = true;
        System.out.println(ANSI_BLUE + "\t\tNew Human created!" + ANSI_RESET);
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Human{" +
                "location=" + Arrays.toString(location) +
                ", icon='" + icon + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                ", isAlive=" + isAlive +
                '}';
    }
}

