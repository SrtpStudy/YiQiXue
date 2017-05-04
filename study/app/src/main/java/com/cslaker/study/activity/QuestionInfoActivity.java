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
import com.cslaker.study.tools.RecyclerViewDivider;
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
