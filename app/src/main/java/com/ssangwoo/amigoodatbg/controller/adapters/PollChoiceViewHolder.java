package com.ssangwoo.amigoodatbg.controller.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ssangwoo.amigoodatbg.R;

/**
 * Created by ssangwoo on 2017-09-19.
 */

public class PollChoiceViewHolder extends RecyclerView.ViewHolder {

    public TextView textChoice;

    public PollChoiceViewHolder(View itemView) {
        super(itemView);
        textChoice = itemView.findViewById(R.id.text_choice);
    }

}
