package com.ssangwoo.amigoodatbg.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by ssangwoo on 2017-09-15.
 */

@JsonObject
public class ChoiceModel {
    @JsonField
    private String item;

    @JsonField
    private int score;

    public ChoiceModel() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
