package com.cslaker.study.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cslaker.study.R;

/**
 * Created by CSLaker on 2017/3/24.
 */

public class BookFragment extends Fragment {

    private static BookFragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        return view;
    }

    public BookFragment(){
    }

    public static BookFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString("text", text);
        if (fragment == null) {
            fragment = new BookFragment();
        }
        fragment.setArguments(args);
        return fragment;
    }

}
