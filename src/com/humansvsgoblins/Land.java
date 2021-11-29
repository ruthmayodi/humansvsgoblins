package com.humansvsgoblins;

public class Land extends Main{

    public Land(int []currentLocation){
        this.formOf = FormOf.LAND;
        this.location = currentLocation;
        this.icon = ANSI_GREEN + "-" + ANSI_RESET  ;
    }
}
