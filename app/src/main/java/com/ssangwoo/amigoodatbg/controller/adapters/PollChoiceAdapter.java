package com.ssangwoo.amigoodatbg.controller.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssangwoo.amigoodatbg.BGDataBase;
import com.ssangwoo.amigoodatbg.R;
import com.ssangwoo.amigoodatbg.model.PollModel;

/**
 * Created by ssangwoo on 2017-09-19.
 */

public class PollChoiceAdapter extends RecyclerView.Adapter<PollChoiceViewHolder>{

    private PollModel poll;
    private int page;

    public PollChoiceAdapter(int currentPage) {
        this.page = currentPage;
        poll = BGDataBase.getInstance().getPoll(currentPage);
    }

    @Override
    public PollChoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_poll_choice, parent, false);
        return new PollChoiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PollChoiceViewHolder holder, int position) {
        holder.textChoice.setText(poll.getChoiceList().get(position).getItem());
        if (poll.getUserChoice() == holder.getAdapterPosition()) {
            holder.itemView.setBackgroundColor(
                    holder.itemView.getResources()
                            .getColor(R.color.colorPageSelected));
        } else {
            holder.itemView.setBackgroundColor(
                    holder.itemView.getResources()
                            .getColor(R.color.colorBackground));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int BeforeChoice = poll.getUserChoice();
                BGDataBase.getInstance()
                        .setUserChoice(page, holder.getAdapterPosition());
                notifyItemChanged(BeforeChoice);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return poll.getChoiceList().size();
    }
}
