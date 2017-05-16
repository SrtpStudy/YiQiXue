package com.cslaker.study.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.cslaker.study.R;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class AnswerInfoActivity extends BaseActivity {

    @Override
    public void initData(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_answer_info;
    }

    @Override
    public void initView(View view) {
        Toolbar toolbar = $(R.id.toolbar);
        toolbar.setTitle("答案");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
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

}
