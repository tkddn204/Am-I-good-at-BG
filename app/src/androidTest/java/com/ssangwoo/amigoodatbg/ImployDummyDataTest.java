package com.ssangwoo.amigoodatbg;

import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import com.ssangwoo.amigoodatbg.view.activities.PollActivity;
import com.ssangwoo.amigoodatbg.view.fragments.PollChoiceFragment;

import static org.junit.Assert.assertEquals;

/**
 * Created by ssangwoo on 2017-09-19.
 */

@RunWith(AndroidJUnit4.class)
public class ImployDummyDataTest {

    PollActivity pollActivity;
    PollChoiceFragment pollChoiceFragment;
    RecyclerView recyclerView;

    //ArrayList<DummyData> dummyDatas;

    @Rule
    public ActivityTestRule<PollActivity> pollActivityTestRule =
            new ActivityTestRule<>(PollActivity.class, true);

    @Rule
    public UiThreadTestRule uiThreadTestRule = new UiThreadTestRule();

    @Before
    public void beforeWork() throws Exception {
        // datas!
//        dummyDatas = new ArrayList<>();
//        for(int i = 0; i < 10; i++) {
//            dummyDatas.add(new DummyData(false, String.valueOf(i)));
//        }
    }

    @Test
    public void inputDataListTest() throws Throwable {
        // Activity!
        pollActivity = pollActivityTestRule.launchActivity(null);

        // Fragment!
        pollChoiceFragment = PollChoiceFragment.newInstance(0);

        // RecyclerView!
//        recyclerView = pollChoiceFragment.getView().findViewById(R.id.poll_recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(pollActivity));
//        recyclerView.setAdapter(new PollChoiceAdapter(dummyDatas));
//        pollActivity.getSupportFragmentManager()
//                .beginTransaction()
//                .add(pollChoiceFragment, null)
//                .commit();
    }

}
