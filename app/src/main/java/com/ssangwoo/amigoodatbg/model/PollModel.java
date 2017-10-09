package com.ssangwoo.amigoodatbg.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonIgnore;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Created by ssangwoo on 2017-09-15.
 */

@JsonObject
public class PollModel{
    @JsonField
    private String question;

    @JsonField(name = "choice")
    private List<ChoiceModel> choiceList;

    @JsonIgnore
    private int userChoice = -1;

    public PollModel() {}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<ChoiceModel> getChoiceList() {
        return choiceList;
    }

    public ChoiceModel getChoice(int index) {
        return choiceList.get(index);
    }

    public void setChoiceList(List<ChoiceModel> choiceList) {
        this.choiceList = choiceList;
    }

    public int getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }
}
