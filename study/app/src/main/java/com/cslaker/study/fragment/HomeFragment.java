package com.cslaker.study.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cslaker.study.R;
import com.cslaker.study.activity.NewQuestionActivity;
import com.cslaker.study.adapter.QuestionAdapter;
import com.cslaker.study.bean.Question;
import com.cslaker.study.tools.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CSLaker on 2017/3/24.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{

    private static HomeFragment fragment;
    private static RecyclerViewDivider dividerLine;
    private RecyclerView mRecyclerView;
    private QuestionAdapter mQuestionAdapter;
    private List<Question> mQuestionList;
    private ImageButton mNewQuestion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mQuestionList == null) {
            initDatas();
        }
        if (mQuestionAdapter == null) {
            mQuestionAdapter = new QuestionAdapter(mQuestionList);
        }
        if (dividerLine == null) {
            dividerLine = new RecyclerViewDivider(RecyclerViewDivider.VERTICAL);
            dividerLine.setSize(10);
            dividerLine.setColor(Color.LTGRAY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mNewQuestion = (ImageButton) view.findViewById(R.id.ib_new_question);
        mNewQuestion.setOnClickListener(this);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(dividerLine);
        mRecyclerView.setAdapter(mQuestionAdapter);
        return view;
    }

    public HomeFragment(){}

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
        Question question = new Question();
        question.setSubject("公共基础课：高等数学");
        question.setTitle("如何证明：可导一定连续,连续不一定可导？");
        question.setContens("(1）可导一定连续  设y=f(x)在x0处可导,f'(x0)=A由可导的充分必要条件有f(x)=f(x0)"
                + "+A(x-x0)+o（│x-x0│）,当x→x0时,f(x)=f(x0)+o（│x-x0│）(2）再由定理：当x...");
        question.setAnswerNumbers(66);
        question.setLikeNumbers(999);

        mQuestionList = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            mQuestionList.add(question);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_new_question: {
                Intent intent = new Intent(getActivity(), NewQuestionActivity.class);
                startActivity(intent);
            }
        }
    }
}
