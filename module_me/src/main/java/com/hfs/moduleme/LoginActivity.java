package com.hfs.moduleme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hfs.libcommon.utils.PreferenceUtil;
import com.hfs.libcommon.utils.RouteUtils;

/**
 * @author HuangFusheng
 * @date 2018/12/13
 * @description LoginActivity
 */
@Route(path =RouteUtils.ME_LOGIN)
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_login)
                .setOnClickListener(this);

        findViewById(R.id.btn_login_out)
                .setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            PreferenceUtil.putBoolean("login",true);
        } else if (v.getId() == R.id.btn_login_out) {
            PreferenceUtil.putBoolean("login",false);
        }
    }
}
