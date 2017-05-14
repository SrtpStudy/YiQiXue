package com.cslaker.study.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cslaker.study.R;
import com.cslaker.study.adapter.AnswerAdapter;
import com.cslaker.study.bean.Answer;
import com.cslaker.study.utils.RecyclerViewDivider;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class QuestionInfoActivity  extends AppCompatActivity implements View.OnClickListener {

    private static RecyclerViewDivider dividerLine;
    private RecyclerView mRecyclerView;
    private AnswerAdapter mAnswerAdapter;
    private List<Answer> mAnswerList;
    private TextView mAnswerTV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("问题");
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

        mAnswerTV = (TextView) findViewById(R.id.tv_new_answer);
        mAnswerTV.setOnClickListener(this);
    }

    private void initDatas() {
        mAnswerList = new ArrayList<>();
        Answer answer1 = new Answer();
        answer1.setUser("华仔");
        answer1.setContens("可导一定连续,连续不一定可导  证明：（1）可导一定连续  设y=f(x)在x0处可导,f'(x0)=A  由可导的充分必要条件有  f(x)=f(x0)+A(x-x0)+o（│...");
        answer1.setTime("2017-01-01");
        answer1.setReplayNumbers(66);
        answer1.setLikeNumbers(999);
        mAnswerList.add(answer1);

/*        Answer answer2 = new Answer();
        answer2.setUser("隔壁老王");
        answer2.setContens("因为函数可导,根据可导的定义有\n" +
                "limΔy/Δx=A (Δx趋向于0)\n" +
                "所以\n" +
                "Δy/Δx=A+α (α是Δx趋向于0时的无穷小)\n" +
                "从而\n" +
                "Δy=AΔx+αΔx\n" +
                "当Δx趋向于0时,显然limΔy=0\n" +
                "由连续定义有\n" +
                "函数连续.\n" +
                "连续未必可导,比如y=|x|在x=0处连续,但左导数=-1,右导数=1,不可导.");
        answer2.setTime("2017-05-02");
        answer2.setReplayNumbers(30);
        answer2.setLikeNumbers(454);
        mAnswerList.add(answer2);

        Answer answer3 = new Answer();
        answer3.setUser("李紧");
        answer3.setContens("因为函数可导,根据可导的定义有\n" +
                "limΔy/Δx=A (Δx趋向于0)。所以\n" +
                "Δy/Δx=A+α (α是Δx趋向于0时的无穷小)。从而\n" +
                "Δy=AΔx+αΔx\n" +
                "当Δx趋向于0时,显然limΔy=0\n" +
                "由连续定义有：函数连续.\n" +
                "连续未必可导,比如y=|x|在x=0处连续,但左导数=-1,右导数=1,不可导.");
        answer3.setTime("2017-05-02");
        answer3.setReplayNumbers(30);
        answer3.setLikeNumbers(454);
        mAnswerList.add(answer3);*/
        for (int i = 0; i < 10; i ++) {
            mAnswerList.add(answer1);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menu .findItem(R.id.ab_save).setVisible(false);
        menu .findItem(R.id.ab_search).setVisible(false);
        menu .findItem(R.id.ab_edit).setVisible(false);
        menu .findItem(R.id.ab_share).setVisible(true);
        menu .findItem(R.id.ab_more).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.tv_new_answer:
                intent = new Intent(QuestionInfoActivity.this, NewAnswerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
