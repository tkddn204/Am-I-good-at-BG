package com.ssangwoo.amigoodatbg.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ssangwoo.amigoodatbg.BGDataBase;
import com.ssangwoo.amigoodatbg.R;
import com.ssangwoo.amigoodatbg.controller.adapters.PollChoiceAdapter;
import com.ssangwoo.amigoodatbg.model.PollModel;

public class ReactionRateFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CURRENT_PAGE = "currentPage";

    private int currentPage;
    private PollModel poll;

    private OnFragmentInteractionListener mListener;

    public ReactionRateFragment() { }

    public static PollChoiceFragment newInstance(int currentPage) {
        PollChoiceFragment fragment = new PollChoiceFragment();
        Bundle args = new Bundle();
        args.putInt(CURRENT_PAGE, currentPage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentPage = getArguments().getInt(CURRENT_PAGE);
        }
        poll = BGDataBase.getInstance().getPoll(currentPage);
    }

    RecyclerView recyclerView;
    TextView textQuestion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_poll_choice, container, false);


        textQuestion = view.findViewById(R.id.text_question);

        recyclerView = view.findViewById(R.id.poll_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        if(poll != null) {
            textQuestion.setText(poll.getQuestion());
            recyclerView.setAdapter(new PollChoiceAdapter(currentPage));
        }

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
