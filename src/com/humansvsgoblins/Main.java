package com.humansvsgoblins;


    public class Main {
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";

        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";

        int [] location = new int[2];
        String icon;
        public FormOf formOf;
        public Main(){

        }

        public int[] getLocation() {
            return location;
        }

        public void setLocation(int[] location) {
            this.location = location;
        }
    }

