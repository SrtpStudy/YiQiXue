package com.cslaker.study.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cslaker.study.R;
import com.cslaker.study.bean.Question;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by CSLaker on 2017/3/25.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private List<Question> mDatas = null;

    public QuestionAdapter(List<Question> datas) {
        this.mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_question, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mSubjectsTV.setText(mDatas.get(position).getSubject());
        viewHolder.mTitleTV.setText(mDatas.get(position).getTitle());
        viewHolder.mContentsTV.setText(mDatas.get(position).getContens());
        viewHolder.mAnswerTV.setText("回答：" + mDatas.get(position).getAnswerNumbers() + "");
        viewHolder.mLikeTV.setText("赞：" + mDatas.get(position).getLikeNumbers() + "");
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mSubjectsTV;
        public TextView mTitleTV;
        public TextView mContentsTV;
        public TextView mAnswerTV;
        public TextView mLikeTV;

        public ViewHolder(View view){
            super(view);
            mSubjectsTV = (TextView) view.findViewById(R.id.tv_subject);
            mTitleTV = (TextView) view.findViewById(R.id.tv_question_title);
            mContentsTV = (TextView) view.findViewById(R.id.tv_question_contents);
            mAnswerTV = (TextView) view.findViewById(R.id.tv_question_answer);
            mLikeTV = (TextView) view.findViewById(R.id.tv_question_like);
        }

    }

}
