package com.hfs.modulechat.module_service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hfs.libcommon.provider.IChatModuleService;
import com.hfs.libcommon.utils.RouteUtils;
import com.hfs.modulechat.net.ChatService;


/**
 *
 * @author HuangFusheng
 * @date 2018/12/13
 * @description ChatModuleService
 */
@Route(path = RouteUtils.SERVICE_CHAT)
public class ChatModuleService implements IChatModuleService {

    @Override
    public String getUserName(String userId) {
        return ChatService.getUserName();
    }

    @Override
    public void init(Context context) {

    }
}
