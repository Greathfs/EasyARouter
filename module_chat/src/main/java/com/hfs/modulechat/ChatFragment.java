package com.hfs.modulechat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hfs.libcommon.utils.RouteUtils;

/**
 *
 * @author HuangFusheng
 * @date 2018/12/13
 * @description ChatFragment
 */
@Route(path = RouteUtils.CHAT_FRAGMENT_MAIN)
public class ChatFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}