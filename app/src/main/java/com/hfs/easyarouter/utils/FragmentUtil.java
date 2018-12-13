package com.hfs.easyarouter.utils;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hfs.libcommon.utils.RouteUtils;

/**
 * @author HuangFusheng
 * @date 2018/12/13
 * @description FragmentUtil
 */
public class FragmentUtil {

    public static Fragment getHomeFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteUtils.Home_Fragment_Main).navigation();
        return fragment;
    }

    public static Fragment getChatFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteUtils.Chat_Fragment_Main).navigation();
        return fragment;
    }

    public static Fragment getRecomFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteUtils.Recom_Fragment_Main).navigation();
        return fragment;
    }

    public static Fragment getMeFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteUtils.Me_Fragment_Main).navigation();
        return fragment;
    }
}
