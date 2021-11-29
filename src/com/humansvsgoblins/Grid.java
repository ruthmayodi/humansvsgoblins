package com.humansvsgoblins;
import java.util.Arrays;

public class Grid {
    private int width;
    private int height;
    private Main[][] gridItems;

    // This code block sets up the grid. I did not come up with this code. I googled it but my starting point was this video https://www.youtube.com/watch?v=844Q40XXKXc

    public Grid(int height, int width) {
        this.width = width;
        this.height = height;
        //this.gridItems = new Main[][][height][width]
        this.makeLand();
    }

    public void createItem(Main itemToBeAdded, int[] location) {
        int row = location[0];
        int column = location[1];
        this.gridItems[row][column] = itemToBeAdded;
    }

    public void moveMain(Main item_to_move, Direction d) {

        System.out.println("Moving " + item_to_move.getClass() + " : " + d);
        int currentLocationY = item_to_move.getLocation()[0];
        int currentLocationX = item_to_move.getLocation()[1];
        int[] oldLocation = item_to_move.getLocation();
        System.out.println("current position: " + Arrays.toString(item_to_move.getLocation()));


        switch (d) {
            case RIGHT:
                item_to_move.setLocation(new int[]{currentLocationY, currentLocationX + 1});
                break;
            case LEFT:
                item_to_move.setLocation(new int[]{currentLocationY, currentLocationX - 1});
                break;
            case DOWN:
                item_to_move.setLocation(new int[]{currentLocationY + 1, currentLocationX});
                break;
            case UP:
                item_to_move.setLocation(new int[]{currentLocationY - 1, currentLocationX});
                break;
        }

        this.gridItems[currentLocationY][currentLocationX] = new Land(oldLocation);

        int newLocationY = item_to_move.getLocation()[0];
        int newLocationX = item_to_move.getLocation()[1];
        this.gridItems[newLocationY][newLocationX] = item_to_move;
        System.out.println("Position after " + d + ": " + Arrays.toString(item_to_move.getLocation()));
    }

    public void drawGrid() {
        System.out.println();
        for (int i = 0; i < this.height; i++) {
            System.out.print("\t\t");
            for (int j = 0; j < this.width; j++) {
                if (this.gridItems[i][j].formOf == FormOf.LAND) {
                    System.out.print(this.gridItems[i][j].icon);
                } else {
                    System.out.print(this.gridItems[i][j].icon);
                }
            }
            System.out.println();
        }
    }

    public void makeLand() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.gridItems[i][j] = new Land(new int[]{i, j});
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Main[][] getWorldItems() {
        return gridItems;
    }

    public void setWorldItems(Main[][] worldItems) {
        this.gridItems = worldItems;
    }
}
