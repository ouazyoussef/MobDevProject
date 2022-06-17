package com.example.sportiveapp;

import android.annotation.SuppressLint;
import android.content.res.Resources;

public class Match {

    private final Resources res;
    private final String username;
    private final String dateMatch;
    private final String wol;

    public Match(Resources res, String username, String dateMatch, String wol) {
        this.res = res;
        this.username = username;
        this.dateMatch = dateMatch;
        this.wol = wol;
    }

    public String winOrLose() {
        if (this.wol.equals("1"))
            return res.getString(R.string.match_won);
        else if (this.wol.equals("2"))
                return res.getString(R.string.match_not_finished);
        return res.getString(R.string.match_lost);
    }

    @SuppressLint("StringFormatInvalid")
    public String toString() {
        return String.format(res.getString(R.string.match_played), this.username, this.dateMatch, this.winOrLose());
    }
}
