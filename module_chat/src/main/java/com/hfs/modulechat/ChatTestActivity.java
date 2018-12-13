package com.hfs.modulechat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hfs.libcommon.utils.RouteUtils;

/**
 * @author HuangFusheng
 * @date 2018/12/13
 * @description ChatTestActivity
 */
@Route(path = RouteUtils.CHAT_TEST)
public class ChatTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_test);

        String extra = getIntent().getStringExtra("extra");
        Toast.makeText(this, extra, Toast.LENGTH_SHORT).show();
    }
}
