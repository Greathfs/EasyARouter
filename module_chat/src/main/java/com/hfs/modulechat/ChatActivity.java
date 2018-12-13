package com.hfs.modulechat;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
/**
 *
 * @author HuangFusheng
 * @date 2018/12/13
 * @description ChatActivity
 */
public class ChatActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initView();
    }
    private void initView() {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_main, new ChatFragment())
                .commitAllowingStateLoss();
    }
}
