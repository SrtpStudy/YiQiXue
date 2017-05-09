package com.cslaker.study.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cslaker.study.R;

public class MakeDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_date);
        Button plus1=(Button)findViewById(R.id.plus);
        Button yuexuexinxi=(Button)findViewById(R.id.yuexuexinxi);
        plus1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MakeDateActivity.this,BeginStudyActivity.class);
                startActivity(intent);
            }
        });
        yuexuexinxi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MakeDateActivity.this,MakeDateInformationActivity.class);
                startActivity(intent);
            }
        });
        Button back=(Button)findViewById(R.id.title_back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MakeDateActivity.this,OfflineActivity.class);
                startActivity(intent);
            }
        });
    }
}
