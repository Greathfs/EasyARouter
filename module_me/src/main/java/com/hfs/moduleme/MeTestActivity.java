package com.hfs.moduleme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hfs.libcommon.utils.RouteUtils;

/**
 * @author HuangFusheng
 * @date 2018/12/13
 * @description MeTestActivity
 */
@Route(path = RouteUtils.ME_TEST)
public class MeTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}
