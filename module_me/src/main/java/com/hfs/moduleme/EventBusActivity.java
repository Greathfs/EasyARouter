package com.hfs.moduleme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hfs.libcommon.data.bean.EventBusBean;
import com.hfs.libcommon.data.event.TestEvent;
import com.hfs.libcommon.utils.RouteUtils;

import org.greenrobot.eventbus.EventBus;

import java.text.MessageFormat;

/**
 *
 * @author HuangFusheng
 * @date 2018/12/13
 * @description EventBusActivity
 */
@Route(path = RouteUtils.ME_EVENT_BUS)
public class EventBusActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * eventBus数据接收页面
     */
    private TextView mTextView;
    /**
     * eventBus返回数据
     */
    private Button mBtnBackData;

    private String name;

    private long age;

    private EventBusBean eventbus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        ARouter.getInstance().inject(this);
        initData();
        initView();
    }

    private void initData() {
        name = getIntent().getStringExtra("name");
        age = getIntent().getLongExtra("age", 0);
        eventbus = getIntent().getParcelableExtra("eventbus");
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.textView);
        mBtnBackData = (Button) findViewById(R.id.btn_back_data);
        mBtnBackData.setOnClickListener(this);
        mTextView.setText(MessageFormat.format("name={0},\tage={1},\teventName={2}", name, age, eventbus.getEventName()));
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_back_data) {
            EventBus.getDefault().post(new TestEvent("这是一个测试的Event"));
            finish();
        } else {
        }
    }
}
