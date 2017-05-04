package com.cslaker.study.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cslaker.study.R;
import com.cslaker.study.bean.Answer;
import com.cslaker.study.bean.Replay;

import java.util.List;

/**
 * Created by CSLaker on 2017/3/25.
 */

public class ReplayAdapter extends RecyclerView.Adapter<ReplayAdapter.ViewHolder> {

    private List<Replay> mDatas = null;

    public ReplayAdapter(List<Replay> datas) {
        this.mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_replay_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mUserTV.setText(mDatas.get(position).getUser());
        viewHolder.mContentsTV.setText(mDatas.get(position).getContens());
        viewHolder.mTimeTV.setText(mDatas.get(position).getTime());
        viewHolder.mLikeTV.setText(mDatas.get(position).getLikeNumbers() + "");
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mUserTV;
        public TextView mContentsTV;
        public TextView mTimeTV;
        public TextView mLikeTV;

        public ViewHolder(View view) {
            super(view);
            mUserTV = (TextView) view.findViewById(R.id.tv_replay_user);
            mContentsTV = (TextView) view.findViewById(R.id.tv_replay_contents);
            mTimeTV = (TextView) view.findViewById(R.id.tv_replay_time);
            mLikeTV = (TextView) view.findViewById(R.id.tv_replay_like);
        }

    }

}
