package com.demo.mayixuan.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by mayixuan on 2018/7/29.
 */

public class ApprovalFragment extends Fragment {

    private EditText hint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate( R.layout.fragment_approval, container, false );
        init(view);
        return view;
    }

    private void init(View view) {
        hint=(EditText) view.findViewById(R.id.approve_edit);
        // 新建一个可以添加属性的文本对象
        SpannableString ss = new SpannableString("输入审批意见或批注！");
        // 新建一个属性对象,设置文字的大小
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(15,true);
        // 附加属性到文本
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置hint
        hint.setHint(new SpannedString(ss)); // 一定要进行转换,否则属性会消失
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

    }
}
