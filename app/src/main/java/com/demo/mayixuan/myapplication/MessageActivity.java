package com.demo.mayixuan.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView listView;
    private ApplypeopleFragment applypeopleFragment;
    private My_already_workFragment my_already_workFragment;
    private My_applyFragment my_applyFragment;
    private SearchFragment searchFragment;
    private ApprovalFragment approvalFragment;
    private MessagedetailsFragment messagedetailsFragment;
    private ApprovalprocessFragment approvalprocessFragment;
    private AppCompatImageView return_btn;
    private TextView title;
    private String[] set_up = {"系统更新", "登录手势"};
    List<Message> messages = new ArrayList<>();
    List<Apply> applies = new ArrayList<>();
    Bundle bundle = null;
    String flag = null;


    private int mCurrentPos = -1;
    GeneralListAdapter messageListAdapter;
    MyapplyListAdapter myapplyListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_message );
        init();
        transform();

    }

    private void init() {

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        listView = findViewById( R.id.list_view );
        return_btn = findViewById( R.id.return_btn );
        title = findViewById( R.id.title );

        my_already_workFragment = new My_already_workFragment();
        my_applyFragment = new My_applyFragment();
        searchFragment = new SearchFragment();

        applypeopleFragment = new ApplypeopleFragment();
        approvalprocessFragment = new ApprovalprocessFragment();
        messagedetailsFragment = new MessagedetailsFragment();
        approvalFragment = new ApprovalFragment();

        //listView.setOnItemClickListener( this );
        return_btn.setOnClickListener( this );

    }

    public void transform() {

        bundle = getIntent().getExtras();
        flag = (String) bundle.get( "flag" );

        if (flag.equals( "设置" )) {
            set_up();
        } else if (flag.equals( "我的代办" )) {
            my_daiban_work();
        } else if (flag.equals( "已办工作" )) {
            my_already_work();
        } else if (flag.equals( "我的申请" )) {
            my_apply();
        } else if (flag.equals( "消息" )) {
            my_message();
        } else if (flag.equals( "查询" )) {
            search();
        }
        title.setText( flag );
        listView.setOnItemClickListener( this );
    }

    public void my_daiban_work() {
        //此处从数据库获取代办工作信息
        Message message1 = new Message( "标题1", "申请人：张三", "" );
        Message message2 = new Message( "标题2", "申请人：张三", "" );
        messages.add( message1 );
        messages.add( message2 );
        messageListAdapter = new GeneralListAdapter( messages, this );
        listView.setAdapter( messageListAdapter );
    }

    public void set_up() {
        SetupListAdapter setupListAdapter = new SetupListAdapter( set_up, this );
        listView.setAdapter( setupListAdapter );
    }

    public void my_already_work() {
        getFragmentManager().beginTransaction().add( R.id.on_the_listview, my_already_workFragment ).commitAllowingStateLoss();
        Message message1 = new Message( "标题1", "2018.3.8 18:25 审批", "" );
        Message message2 = new Message( "标题2", "2018.3.8 18:25 审批", "" );
        messages.add( message1 );
        messages.add( message2 );
        messageListAdapter = new GeneralListAdapter( messages, this );
        listView.setAdapter( messageListAdapter );
    }

    public void my_apply() {
        getFragmentManager().beginTransaction().add( R.id.on_the_listview, my_applyFragment ).commitAllowingStateLoss();
        Apply apply1 = new Apply( "我的申请1", "待xx局长审批审批", "", 1 );
        Apply apply2 = new Apply( "我的申请1", "待xx局长审批审批", "", 1 );
        applies.add( apply1 );
        applies.add( apply2 );
        myapplyListAdapter = new MyapplyListAdapter( applies, this );
        listView.setAdapter( myapplyListAdapter );
    }

    public void my_message() {
        Message message1 = new Message( "流程：您提交的申请...", "流程编号：201803080122", "" );
        Message message2 = new Message( "系统：请于3月8日前...", "", "" );
        messages.add( message1 );
        messages.add( message2 );
        messageListAdapter = new GeneralListAdapter( messages, this );
        listView.setAdapter( messageListAdapter );
    }

    public void search() {
        getFragmentManager().beginTransaction().add( R.id.on_the_listview, searchFragment ).commitAllowingStateLoss();
        Message message1 = new Message( "标题1", "2018.3.8 18:25 审批", "" );
        Message message2 = new Message( "标题2", "2018.3.8 18:25 审批", "" );
        messages.add( message1 );
        messages.add( message2 );
        messageListAdapter = new GeneralListAdapter( messages, this );
        listView.setAdapter( messageListAdapter );
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (!applypeopleFragment.isAdded()) {
            getFragmentManager().beginTransaction().add( R.id.fl_container, applypeopleFragment ).commitAllowingStateLoss();
            getFragmentManager().beginTransaction().add( R.id.message_details_container, messagedetailsFragment ).commitAllowingStateLoss();

            if (flag.equals( "设置" )) {

            } else if (flag.equals( "我的代办" )) {
                getFragmentManager().beginTransaction().add( R.id.approval_container, approvalFragment ).commitAllowingStateLoss();
            } else if (flag.equals( "已办工作" )) {

            } else if (flag.equals( "我的申请" )) {
                getFragmentManager().beginTransaction().add( R.id.approval_process_container, approvalprocessFragment ).commitAllowingStateLoss();
            } else if (flag.equals( "消息" )) {

            } else if (flag.equals( "查询" )) {

            }

        }
        // 更新当前被选中的位置
        mCurrentPos = position;
        // 刷新listview
        if(!flag.equals( "我的申请" )){
            messageListAdapter.notifyDataSetChanged();
        }else {
            myapplyListAdapter.notifyDataSetChanged();
        }



    }

    @Override
    public void onClick(View v) {
        bundle.remove( "flag" );
        finish();
    }

    class GeneralListAdapter extends BaseAdapter {


        List<Message> messages;
        LayoutInflater inflater = null;

        public GeneralListAdapter(List<Message> messages, Context context) {
            this.messages = messages;
            inflater = LayoutInflater.from( context );
        }

        @Override
        public int getCount() {
            return messages.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            //System.out.println("before: "+messages.get(position)+"-------  "+convertView);
            view = inflater.inflate( R.layout.daiban_list_item, null );
            TextView title =  view.findViewById( R.id.tv_title );
            TextView from = view.findViewById( R.id.tv_from );
            TextView time=view.findViewById( R.id.tv_time );
            title.setText( messages.get( position ).getTitle() );
            from.setText( messages.get( position ).getFrom() );

            // 只有当更新的位置等于当前位置时，更改颜色
//        if(mCurrentPos == position){
//            background.setBackgroundColor(Color.rgb(35, 154, 237));
//        } else {
//            background.setBackgroundColor( Color.TRANSPARENT);
//        }
//        System.out.println("2..mCurrentPos的值是"+mCurrentPos  );
            if (mCurrentPos == position) {
                title.setEnabled( true );
                time.setEnabled( true );
                from.setEnabled( true );
            } else {
                title.setEnabled( false );
                from.setEnabled( false );
                time.setEnabled( false );
            }


            return view;

        }
    }

    class MyapplyListAdapter extends BaseAdapter {

        List<Apply> applies;
        LayoutInflater inflater = null;

        public MyapplyListAdapter(List<Apply> applies, Context context) {
            this.applies = applies;
            inflater = LayoutInflater.from( context );
        }

        @Override
        public int getCount() {
            return applies.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = null;
            view = inflater.inflate( R.layout.apply_list_item, null );
            TextView title = view.findViewById( R.id.tv_title );
            TextView process = view.findViewById( R.id.process );
            TextView time=view.findViewById( R.id.tv_time );
            title.setText( applies.get( position ).getTitle() );
            process.setText( applies.get( position ).getProcess() );


            if (mCurrentPos == position) {
                title.setEnabled( true );
                time.setEnabled( true );
                //process.setEnabled( true );
            } else {
                title.setEnabled( false );
                //process.setEnabled( false );
                time.setEnabled( false );
            }

            return view;

        }

    }
}

