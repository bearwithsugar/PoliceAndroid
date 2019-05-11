package com.demo.mayixuan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout my_daiban_work;
    private LinearLayout my_already_work;
    private LinearLayout my_apply;
    private LinearLayout my_message;
    private LinearLayout search;
    private LinearLayout set_up_btn;
    Bundle bundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        init();
    }

    public void init(){
        my_daiban_work=findViewById( R.id.main_my_daiban_work );
        my_already_work=findViewById( R.id.main_my_already_work );
        my_message=findViewById( R.id.main_my_message );
        my_apply=findViewById( R.id.main_my_apply );
        search=findViewById( R.id.main_search);
        set_up_btn=findViewById( R.id.set_up_btn );

        my_daiban_work.setOnClickListener( this );
        my_already_work.setOnClickListener( this );
        my_message.setOnClickListener( this );
        my_apply.setOnClickListener( this );
        search.setOnClickListener( this );
        set_up_btn.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent( MainActivity.this,MessageActivity.class );
        switch (v.getId()){
            case R.id.main_my_daiban_work:
                bundle.putSerializable("flag", "我的代办");
                break;
            case R.id.main_my_already_work:
                bundle.putSerializable("flag", "已办工作");
                break;
            case R.id.main_my_message:
                bundle.putSerializable("flag", "消息");
                break;
            case R.id.main_my_apply:
                bundle.putSerializable("flag", "我的申请");
                break;
            case R.id.main_search:
                bundle.putSerializable("flag", "查询");
                break;
            case R.id.set_up_btn:
                bundle.putSerializable("flag", "设置");
                break;
            default:
                break;
        }
        intent.putExtras(bundle);
        startActivity( intent );
    }
}
