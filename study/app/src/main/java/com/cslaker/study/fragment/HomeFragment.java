package com.cslaker.study.fragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cslaker.study.R;
import com.cslaker.study.adapter.QuestionAdapter;
import com.cslaker.study.tools.RecyclerViewDivider;

/**
 * Created by CSLaker on 2017/3/24.
 */

public class HomeFragment extends Fragment {

    private static HomeFragment fragment;
    private static RecyclerViewDivider dividerLine;
    private RecyclerView mRecyclerView;
    private QuestionAdapter mAdapter;
    private String[] mdatas = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mdatas == null) {
            initDatas();
        }
        if (mAdapter == null) {
            mAdapter = new QuestionAdapter(mdatas);
        }
        if (dividerLine == null) {
            dividerLine = new RecyclerViewDivider(RecyclerViewDivider.VERTICAL);
            dividerLine.setSize(3);
            dividerLine.setColor(Color.LTGRAY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(dividerLine);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    public HomeFragment(){
    }

    public static HomeFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString("text", text);
        if (fragment == null) {
            fragment = new HomeFragment();
        }
        fragment.setArguments(args);
        return fragment;
    }

    private void initDatas() {
        mdatas = new String[20];
        for (int i = 0; i < 20; i ++) {
            mdatas[i] = "Hello world!";
        }
    }

}
