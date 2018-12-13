package com.hfs.moduleme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hfs.libcommon.utils.RouteUtils;

/**
 * @author HuangFusheng
 * @date 2018/12/13
 * @description MeWebActivity
 */

@Route(path = RouteUtils.ME_WEB_VIEW)
public class MeWebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
    }

    private void initView() {
        WebView webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl(getIntent().getStringExtra("url"));
    }
}
