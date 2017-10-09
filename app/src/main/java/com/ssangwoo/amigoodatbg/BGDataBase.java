package com.ssangwoo.amigoodatbg;

import com.ssangwoo.amigoodatbg.model.PollModel;
import com.ssangwoo.amigoodatbg.model.ResultModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssangwoo on 2017-09-20.
 */

public class BGDataBase {

    private List<PollModel> pollModels;
    private List<ResultModel> resultModels;

    public void initPolls(List<PollModel> pollModels) {
        this.pollModels = pollModels;
    }
    public void initResults(List<ResultModel> resultModels) {
        this.resultModels = resultModels;
    }

    public PollModel getPoll(int index) {
        return pollModels.get(index);
    }

    public int getMaxPage() {
        return pollModels.size() - 1;
    }

    public int getResult() {
        int result = 0;
        for (int i = 0; i < pollModels.size(); i++) {
            result += getPoll(i).getChoice(getPoll(i).getUserChoice()).getScore();
        }

        return result;
    }

    public String[] getResultStrings() {
        int result = getResult();
        String[] resultStrings = new String[3];
        for(ResultModel resultModel: resultModels) {
            if(result >= resultModel.getMinScore()) {
                resultStrings[0] = resultModel.getName();
                resultStrings[1] = resultModel.getContent();
                resultStrings[2] = resultModel.getImageName();
                break;
            }
        }
        return resultStrings;
    }

    public int getUserChoice(int index) {
        return pollModels.get(index).getUserChoice();
    }

    public void setUserChoice(int page, int userChoicePosition) {
        PollModel bufferPoll = pollModels.get(page);
        bufferPoll.setUserChoice(userChoicePosition);
        pollModels.set(page, bufferPoll);
    }

    public static BGDataBase getInstance() {
        return Singleton.INSTANCE;
    }

    private static class Singleton {
        private static final BGDataBase INSTANCE = new BGDataBase();
    }
    private BGDataBase() {}
}
