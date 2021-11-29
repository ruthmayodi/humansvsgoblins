package com.humansvsgoblins;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Goblin extends Main {
    private double health, armor;
    private boolean isAlive;
    int attack;

    Goblin(int[] currentLocation) {
        this.formOf = formOf.GOBLIN;
        this.location = currentLocation;
        this.health = 100;
        this.attack = 10;
        this.armor = 5;

        this.icon = ANSI_YELLOW + "G" + ANSI_RESET;
        this.isAlive = true;
        System.out.println(ANSI_YELLOW + "\t\tNew Goblin created!!" + ANSI_RESET);
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

    public void attack(Human human) throws InterruptedException {
        int roundCount = 0;
        while (true) {
            System.out.println("\tROUND: " + roundCount++);

            int goblinHit = new Random().nextInt(this.getAttack() + 1);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Goblin attacks for: " + goblinHit);
            human.setHealth(human.getHealth() - goblinHit);
            System.out.println("Player Health: "+human.getHealth());
            if (human.getHealth() <=0){
                System.out.println("YOU DIED !!!");
                human.setAlive(false);
                break;
            }

            int playerHit = new Random().nextInt(human.getAttack() + 1);
            System.out.println("Player Attacks for: " + playerHit);
            this.setHealth(this.getHealth()-playerHit);
            System.out.println("Goblin Health: "+this.getHealth());
            if (this.getHealth() <= 0){
                System.out.println("Enemy Defeated");
                this.setAlive(false);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Goblin{" +
                "location=" + Arrays.toString(location) +
                ", icon='" + icon + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                ", isAlive=" + isAlive +
                '}';
    }
}
