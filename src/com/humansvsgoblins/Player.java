package com.humansvsgoblins;


import java.util.Scanner;

public class Player {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_YELLOW = "\u001B[33m";


    public static void main(String[] args) throws InterruptedException {

        Human human = new Human(new int[]{1, 2});
        Goblin goblin1 = new Goblin(new int[]{3, 3});

        Grid grid = new Grid(8, 24);
        grid.createItem(goblin1, goblin1.getLocation());
        grid.createItem(human, human.getLocation());
        grid.drawGrid();

        Direction moveDirection;
        Direction goblinMoveDirection;
        while (true) {


            moveDirection = selectMove();
            Grid.moveMain(human, moveDirection);
            Grid.drawGrid();
//
            if (checkFight(Grid, human, goblin1)) {
                goblin1.attack(human);
                if ((!goblin1.isAlive()) || (!human.isAlive())) {
                    System.out.println("LETS DO THIS ANOTHER TIME");
                    break;
                }
            }
        }

    }

    //public static void MenuItems(Grid grid) {
        //System.out.println("-------------------------------------------------");
        //System.out.println("                        MENU                     ");
        //System.out.println("                      1. Move                    ");
        //System.out.println("                                                 ");
        //System.out.println("-------------------------------------------------");

    //}

    public static Direction selectMove() {
//
        System.out.println();
        System.out.println("Which direction would you like to move? :");
        System.out.println(ANSI_YELLOW + "\t\t\t (U)p ");
        System.out.println("\t\t\t (D) ");
        System.out.println("\t\t\t (R) ");
        System.out.println("\t\t\t (L) ");
        System.out.println("\t\t\t (S)" + ANSI_RESET);
        Scanner in = new Scanner(System.in);
        String reply = in.next().toUpperCase();
        switch (reply) {
            case "U":
                return Direction.UP;
            case "D":
                return Direction.DOWN;
            case "L":
                return Direction.LEFT;
            case "R":
                return Direction.RIGHT;
            default:
                return null;
        }
    }

    public static boolean checkFight(Grid grid, Human human, Goblin goblin) {
        int humanPositionA = human.getLocation()[1];
        int humanPositionB = human.getLocation()[0];

        int goblinPosX = goblin.getLocation()[1];
        int goblinPosY = goblin.getLocation()[0];

        if ((goblinPosY == humanPositionB) && ((goblinPosX + 1 == humanPositionA) || (goblinPosX - 1 == humanPositionA))) {
            System.out.println("Fight Started");
            return true;
        }
        if ((goblinPosX == humanPositionA) && ((goblinPosY + 1 == humanPositionB) || (goblinPosY - 1 == humanPositionB))) {
            System.out.println("Fight Started");
            return true;
        }
        return false;
    }

    public static Direction goblinMove(Grid grid, Human human, Goblin goblin) {

        Direction playerMove;

        int humanPosX = human.getLocation()[1];
        int humanPosY = human.getLocation()[0];
        int goblinPosX = goblin.getLocation()[1];
        int goblinPosY = goblin.getLocation()[0];

        if ((goblinPosY > humanPosY) || (goblinPosY < humanPosY)) {
            if (((goblinPosY + 1 == humanPosY) || (goblinPosY - 1 == humanPosY)) && (goblinPosX == humanPosX)) {
                System.out.println("GOBLIN ATTACK INITIATED");
                playerMove = Direction.ATTACK;
            } else {

                if (goblinPosY < humanPosY) {
                    playerMove = Direction.DOWN;
                } else {
                    playerMove = Direction.UP;
                }
            }
        } else {
            if ((goblinPosX + 1 == humanPosX) || (goblinPosX - 1 == humanPosX)) {
                System.out.println("GOBLIN ATTACK INITIATED");
                playerMove = Direction.ATTACK;
            } else {
                if (goblinPosX > humanPosX) {
                    playerMove = Direction.LEFT;
                } else {
                    playerMove = Direction.RIGHT;
                }
            }
        }
        return playerMove;
    }
}