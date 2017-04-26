package com.cslaker.study.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.cslaker.study.R;

/**
 * Created by CSLaker on 2017/3/24.
 */

public class UserFragment extends Fragment {

    private static UserFragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        return view;
    }

    public UserFragment(){}

    public static UserFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString("text", text);
        if (fragment == null) {
            fragment = new UserFragment();
        }
        fragment.setArguments(args);
        return fragment;
    }

}
