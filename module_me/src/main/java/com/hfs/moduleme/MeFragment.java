package com.hfs.moduleme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hfs.libcommon.utils.RouteUtils;

@Route(path = RouteUtils.Me_Fragment_Main)
public class MeFragment extends Fragment implements View.OnClickListener {

    /**
     * 依赖注入
     */
    private Button mAutoInject;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container,false);
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initView(View view) {
        mAutoInject = (Button) view.findViewById(R.id.autoInject);
        mAutoInject.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.autoInject) {
        }
    }
}