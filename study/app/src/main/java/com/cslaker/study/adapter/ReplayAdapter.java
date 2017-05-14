package com.cslaker.study.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cslaker.study.R;
import com.cslaker.study.bean.Replay;
import com.cslaker.study.utils.MyApplication;

import java.util.List;

/**
 * Created by CSLaker on 2017/3/25.
 */

public class ReplayAdapter extends BaseAdapter {

    private List<Replay> mDatas = null;

    public ReplayAdapter(List<Replay> datas) {
        this.mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(MyApplication.getContext(), R.layout.item_replay_list, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mUserTV.setText(mDatas.get(i).getUser());
        viewHolder.mContentsTV.setText(mDatas.get(i).getContens());
        viewHolder.mTimeTV.setText(mDatas.get(i).getTime());
        viewHolder.mLikeTV.setText(mDatas.get(i).getLikeNumbers() + "");
        return view;
    }

    class ViewHolder {

        public TextView mUserTV;
        public TextView mContentsTV;
        public TextView mTimeTV;
        public TextView mLikeTV;

        public ViewHolder(View view) {
            mUserTV = (TextView) view.findViewById(R.id.tv_replay_user);
            mContentsTV = (TextView) view.findViewById(R.id.tv_replay_contents);
            mTimeTV = (TextView) view.findViewById(R.id.tv_replay_time);
            mLikeTV = (TextView) view.findViewById(R.id.tv_replay_like);
        }

    }

}
