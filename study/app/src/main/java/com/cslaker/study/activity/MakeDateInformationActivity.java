package com.cslaker.study.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cslaker.study.R;

public class MakeDateInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_date_info);
        Button back=(Button)findViewById(R.id.title_back1);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MakeDateInformationActivity.this,MakeDateActivity.class);
                startActivity(intent);
            }
        });
        Button huifu=(Button)findViewById(R.id.huifu);
        huifu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MakeDateInformationActivity.this,RecallActivity.class);
                startActivity(intent);
            }
        });
    }


}
