package com.hfs.libcommon;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hfs.libcommon.utils.UIUtils;


/**
 *
 * @author HuangFusheng
 * @date 2018/12/13
 * @description EasyApplication
 */
public class EasyApplication extends Application {
    /**
     * 上下文
     */
    private static EasyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initRouter(this);
    }

    public static Context getInstance() {
        return instance;
    }

    private void initRouter(EasyApplication application) {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (UIUtils.isApkInDebug(instance)) {
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！
            //线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(application);


    }
}
