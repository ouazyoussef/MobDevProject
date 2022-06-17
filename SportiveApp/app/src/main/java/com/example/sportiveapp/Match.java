package com.example.sportiveapp;

import java.util.Date;

public class Match {

    private String username;
    private String dateMatch;
    private String wol;

    public Match(String username, String dateMatch, String wol) {
        this.username = username;
        this.dateMatch = dateMatch;
        this.wol = wol;
    }



    public String winOrlose() {
        if (this.wol.equals("1"))
            return "Won";
        else {
            if (this.wol.equals("2"))
                return "is comming";
            else
                return "Lost";
        }
    }

    public String toString() {
        return "You (" +this.username + ") played on the " + dateMatch + " and " + this.winOrlose();
    }
}
