package com.example.srtp;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OfflineActivity extends AppCompatActivity {
    private List<Users> usersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Offline);
        initDigit();
        UsersAdapter adapter = new UsersAdapter(OfflineActivity.this, R.layout.users_item,usersList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);


    }

    private void initDigit() {
        for (int i = 0; i < 10; i++) {
            Users one = new Users("好好学习，天天向上快来。。。", R.drawable.profle);
            usersList.add(one);
        }
    }

}
