package com.example.sportiveapp;

import java.util.Date;

public class Match {

    private String username;
    private Date dateMatch;
    private int wol;

    public Match(String username, Date dateMatch, int wol) {
        this.username = username;
        this.dateMatch = dateMatch;
        this.wol = wol;
    }

    public String winOrlose() {
        if (this.wol == 1)
            return "Won";
        else
            return "Lost";
    }

    public String toString() {
        return "You (" +this.username + ") played on the " + dateMatch + " and " + this.winOrlose();
    }
}
