package com.cslaker.study.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.cslaker.study.R;
import com.cslaker.study.adapter.ReplayAdapter;
import com.cslaker.study.bean.Replay;
import com.cslaker.study.utils.OkHttpUtil;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class ReplayActivity extends BaseActivity {

    private PullToRefreshListView mPullToRefreshLV;
    private ReplayAdapter mReplayAdapter;
    private List<Replay> mReplayList;

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initParms(Bundle parms) {
        if (mReplayList == null) {
            Replay replay = new Replay();
            replay.setUser("华仔");
            replay.setContens("这答案厉害了！谁写的这么棒！");
            replay.setTime("2017-01-01");
            replay.setLikeNumbers(666);

            mReplayList = new ArrayList<>();
            for (int i = 0; i < 10; i ++) {
                mReplayList.add(replay);
            }
        }
        if (mReplayAdapter == null) {
            mReplayAdapter = new ReplayAdapter(mReplayList);
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_replay;
    }

    @Override
    public void initView(View view) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("评论");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPullToRefreshLV = $(R.id.pull_to_refresh_lv);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void doBusiness(Context mContext) {
        initPullToRefreshLV();
    }

    private void initPullToRefreshLV() {
        mPullToRefreshLV.setAdapter(mReplayAdapter);
        mPullToRefreshLV.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshLV.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                mPullToRefreshLV.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpUtil okHttpUtil = OkHttpUtil.getinstance();
                        okHttpUtil.get("http://www.baidu.com", new BaseCallback<String>() {
                            @Override
                            public void onRequestBefore() {
                                Log.d("onRequestBefore", "之前");
                            }

                            @Override
                            public void onFailure(Request request, Exception e) {
                                Log.d("onFailure", "失败");
                            }

                            @Override
                            public void onSuccess(Response response, String o) {
                                Log.d("onSuccess", "成功");
                            }

                            @Override
                            public void onError(Response response, int errorCode, Exception e) {
                                Log.d("onError", "错误");
                            }
                        });

                        mPullToRefreshLV.onRefreshComplete();//上拉加载更多结束，上拉加载头复位
                    }
                }, 1200);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                mPullToRefreshLV.postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        mPullToRefreshLV.onRefreshComplete();//上拉加载更多结束，上拉加载头复位
                    }
                }, 1200);
            }
        });
        // 设置PullRefreshListView上提加载时的加载提示
        mPullToRefreshLV.getLoadingLayoutProxy(false,true).setPullLabel("上拉加载更多.");
        mPullToRefreshLV.getLoadingLayoutProxy(false,true).setRefreshingLabel("正在加载数据...");
        mPullToRefreshLV.getLoadingLayoutProxy(false,true).setReleaseLabel("松开加载更多...");
        // 设置PullRefreshListView下拉加载时的加载提示
        mPullToRefreshLV.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新...");
        mPullToRefreshLV.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
        mPullToRefreshLV.getLoadingLayoutProxy(true,false).setReleaseLabel("松开刷新...");
    }

    @Override
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

}
