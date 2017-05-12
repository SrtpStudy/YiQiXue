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
        mQuestionList = new ArrayList<>();
        Question question1 = new Question();
        question1.setSubject("公共基础：高等数学");
        question1.setTitle("如何证明：可导一定连续,连续不一定可导？");
        question1.setContens("(1）可导一定连续  设y=f(x)在x0处可导,f'(x0)=A由可导的充分必要条件有f(x)=f(x0)"
                + "+A(x-x0)+o（│x-x0│）,当x→x0时,f(x)=f(x0)+o（│x-x0│）(2）再...");
        question1.setAnswerNumbers(66);
        question1.setLikeNumbers(999);
        mQuestionList.add(question1);

   /*     Question question2 = new Question();
        question2.setSubject("专业选修：计算机网络");
        question2.setTitle(" TCP/IP的核心思想(理念)是什么？");
        question2.setContens("TCP/IP的核心思想就是“网络互联”，将使用不同低层协议的异构网络，" +
                "在传输层、网络层建立一个统一的虚拟逻辑网络，以此来屏蔽所有物理网络的硬件差异，从而实现网络的互联.");
        question2.setAnswerNumbers(15);
        question2.setLikeNumbers(156);
        mQuestionList.add(question2);

        Question question3 = new Question();
        question3.setSubject("专业必修：Java程序设计");
        question3.setTitle("面向对象和面向过程的区别？");
        question3.setContens("面向过程就是分析出解决问题所需要的步骤，然后用函数把这些步骤一步一步实现，使用的时候一个一个依次调用就可以了。 \n" +
                "面向对象是把构成问题事务分解成各个对象，建立对象的目的不是为了完成一个步骤，而是为了描叙某个事物在整个解决问题的步骤中的行为。");
        question3.setAnswerNumbers(9);
        question3.setLikeNumbers(40);
        mQuestionList.add(question3);*/

        for (int i = 0; i < 10; i ++) {
            mQuestionList.add(question1);
        }
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
