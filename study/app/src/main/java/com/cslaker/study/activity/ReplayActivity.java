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
import com.cslaker.study.adapter.ReplayAdapter;
import com.cslaker.study.bean.Answer;
import com.cslaker.study.bean.Replay;
import com.cslaker.study.tools.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class ReplayActivity extends AppCompatActivity implements View.OnClickListener {

    private static RecyclerViewDivider dividerLine;
    private RecyclerView mRecyclerView;
    private ReplayAdapter mReplayAdapter;
    private List<Replay> mReplayList;
    private TextView mAnswerTV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replay);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("评论");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (mReplayList == null) {
            initDatas();
        }
        if (mReplayAdapter == null) {
            mReplayAdapter = new ReplayAdapter(mReplayList);
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
        mRecyclerView.setAdapter(mReplayAdapter);
    }

    private void initDatas() {
        Replay replay = new Replay();
        replay.setUser("华仔");
        replay.setContens("这答案厉害了！谁写的这么棒！");
        replay.setTime("2017-01-01");
        replay.setLikeNumbers(666);

        mReplayList = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            mReplayList.add(replay);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menu .findItem(R.id.ab_save).setVisible(false);
        menu .findItem(R.id.ab_search).setVisible(false);
        menu .findItem(R.id.ab_edit).setVisible(true);
        menu .findItem(R.id.ab_share).setVisible(false);
        menu .findItem(R.id.ab_more).setVisible(false);
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
        }
    }
}
