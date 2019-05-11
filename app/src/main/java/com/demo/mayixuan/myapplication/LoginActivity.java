package com.demo.mayixuan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        getSupportActionBar().hide();
        setContentView( R.layout.activity_login );

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        String s="屏幕的分辨率为："+dm.widthPixels+"*"+dm.heightPixels;

        init();

        // Toast.makeText(getApplicationContext(), "字体大小是："+sizeOflogin,Toast.LENGTH_SHORT).show();
         Toast.makeText(getApplicationContext(), "分辨率大小是"+s,Toast.LENGTH_SHORT).show();


    }
    public void init(){
        loginbtn=findViewById( R.id.login_login);

        loginbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( LoginActivity.this,MainActivity.class );
                startActivity( intent );


            }
        } );
    }
}
