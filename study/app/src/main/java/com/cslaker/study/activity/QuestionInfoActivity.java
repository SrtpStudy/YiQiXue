package com.cslaker.study.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cslaker.study.R;
import com.cslaker.study.adapter.AnswerAdapter;
import com.cslaker.study.bean.Answer;
import com.cslaker.study.tools.RecyclerViewDivider;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class QuestionInfoActivity  extends AppCompatActivity {

    private static RecyclerViewDivider dividerLine;
    private RecyclerView mRecyclerView;
    private AnswerAdapter mAnswerAdapter;
    private List<Answer> mAnswerList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (mAnswerList == null) {
            initDatas();
        }
        if (mAnswerAdapter == null) {
            mAnswerAdapter = new AnswerAdapter(mAnswerList);
        }
        if (dividerLine == null) {
            dividerLine = new RecyclerViewDivider(RecyclerViewDivider.VERTICAL);
            dividerLine.setSize(10);
            dividerLine.setColor(Color.LTGRAY);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(dividerLine);
        mRecyclerView.setAdapter(mAnswerAdapter);
    }

    private void initDatas() {
        Answer answer = new Answer();
        answer.setUser("华仔");
        answer.setContens("可导一定连续,连续不一定可导  证明：（1）可导一定连续  设y=f(x)在x0处可导,f'(x0)=A  由可导的充分必要条件有  f(x)=f(x0)+A(x-x0)+o（│...");
        answer.setTime("2017-01-01");
        answer.setReplayNumbers(66);
        answer.setLikeNumbers(999);

        mAnswerList = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            mAnswerList.add(answer);
        }
    }


}
