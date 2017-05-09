package com.cslaker.study.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cslaker.study.bean.Users;
import com.cslaker.study.R;
import java.util.List;

public class UsersAdapter extends ArrayAdapter<Users> {

    public int resourceId;

    public UsersAdapter(Context context, int textviewResourceId, List<Users> objects){
        super(context,textviewResourceId,objects);
        resourceId=textviewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Users Users = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView digitImage = (ImageView) view.findViewById(R.id.users_image);
        TextView digitName = (TextView) view.findViewById(R.id.users_name);
        digitImage.setImageResource(Users.getImageId());
        digitName.setText(Users.getName());

        return view;
    }

}
