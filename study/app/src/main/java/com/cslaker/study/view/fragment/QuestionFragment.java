package com.cslaker.study.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.cslaker.study.R;
import com.cslaker.study.activity.NewQuestionActivity;
import com.cslaker.study.adapter.QuestionAdapter;
import com.cslaker.study.bean.QuestionBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by CSLaker on 2017/3/24.
 */

public class QuestionFragment extends Fragment implements View.OnClickListener{

    private static QuestionFragment fragment;
    private RecyclerView mRecyclerView;
    private QuestionAdapter mQuestionAdapter;
    private List<QuestionBean> mQuestionList;
    private QuestionBean[] mQuestions;
    private ImageButton mNewQuestion;
    private SwipeRefreshLayout mSwipeRefresh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mQuestionList == null) {
            initDatas();
        }
        if (mQuestionAdapter == null) {
            mQuestionAdapter = new QuestionAdapter(mQuestionList);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mNewQuestion = (ImageButton) view.findViewById(R.id.fab_new_question);
        mNewQuestion.setOnClickListener(this);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mQuestionAdapter);

        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        mSwipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshDatas();
            }
        });
        return view;
    }

    public QuestionFragment(){}

    public static QuestionFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString("text", text);
        if (fragment == null) {
            fragment = new QuestionFragment();
        }
        fragment.setArguments(args);
        return fragment;
    }

    private void initDatas() {
        mQuestionList = new ArrayList<>();

        mQuestions = new QuestionBean[3];
        mQuestions[0] = new QuestionBean();
        mQuestions[0].setSubject("公共基础：高等数学");
        mQuestions[0].setTitle("如何证明：可导一定连续,连续不一定可导？");
        mQuestions[0].setContens("(1）可导一定连续  设y=f(x)在x0处可导,f'(x0)=A由可导的充分必要条件有f(x)=f(x0)"
                + "+A(x-x0)+o（│x-x0│）,当x→x0时,f(x)=f(x0)+o（│x-x0│）(2）再...");
        mQuestions[0].setAnswerNumbers(66);
        mQuestions[0].setLikeNumbers(999);

        mQuestions[1] = new QuestionBean();
        mQuestions[1].setSubject("专业选修：计算机网络");
        mQuestions[1].setTitle(" TCP/IP的核心思想(理念)是什么？");
        mQuestions[1].setContens("TCP/IP的核心思想就是“网络互联”，将使用不同低层协议的异构网络，" +
                "在传输层、网络层建立一个统一的虚拟逻辑网络，以此来屏蔽所有物理网络的硬件差异，从而实现网络的互联.");
        mQuestions[1].setAnswerNumbers(15);
        mQuestions[1].setLikeNumbers(156);

        mQuestions[2] = new QuestionBean();
        mQuestions[2].setSubject("专业必修：Java程序设计");
        mQuestions[2].setTitle("面向对象和面向过程的区别？");
        mQuestions[2].setContens("面向过程就是分析出解决问题所需要的步骤，然后用函数把这些步骤一步一步实现，使用的时候一个一个依次调用就可以了。 \n" +
                "面向对象是把构成问题事务分解成各个对象，建立对象的目的不是为了完成一个步骤，而是为了描叙某个事物在整个解决问题的步骤中的行为。");
        mQuestions[2].setAnswerNumbers(9);
        mQuestions[2].setLikeNumbers(40);

        for (int i = 0; i < 10; i ++) {
            mQuestionList.add(mQuestions[0]);
        }
    }

    private void refreshDatas() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mQuestionList.clear();
                for (int i = 0; i < 10; i ++) {
                    mQuestionList.add(mQuestions[new Random().nextInt(3)]);
                }
                mQuestionAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
                mSwipeRefresh.setRefreshing(false);
            }
        }, 1200);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_new_question: {
                Intent intent = new Intent(getActivity(), NewQuestionActivity.class);
                startActivity(intent);
            }
        }
    }

}