package com.ssangwoo.amigoodatbg.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.ssangwoo.amigoodatbg.R;

/**
 * Created by ssangwoo on 2017-10-05.
 */
@JsonObject
public class ResultModel {

    @JsonField
    private String name;

    @JsonField
    private String content;

    @JsonField(name = "min_score")
    private int minScore;

    @JsonField(name = "image_name")
    private String imageName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMinScore() {
        return minScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
