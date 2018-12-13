package com.hfs.libcommon.interceptor;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hfs.libcommon.EasyApplication;
import com.hfs.libcommon.utils.PreferenceUtil;
import com.hfs.libcommon.utils.RouteUtils;


/**
 *
 * 添加拦截器的时候，建议clean再打包运行，不然会出现，无效的情况
 * <p>
 * 切记一个项目里面priority的值保证唯一，不然会出毛病
 */
@Interceptor(priority = 1, name = "重新分组进行拦截")
public class LoginInterceptor implements IInterceptor {

    private static final String TAG = "LoginInterceptor";

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if ("needLogin".equals(postcard.getGroup())) {
            boolean isLogin=PreferenceUtil.getBoolean("login", false);
            if (isLogin) {
                postcard.withString("extra", "我是在拦截器中附加的参数");
                callback.onContinue(postcard);
            }else {
                callback.onInterrupt(null);
                ARouter.getInstance().build(RouteUtils.ME_LOGIN)
                        .withString("path", postcard.getPath()).navigation();
            }

        } else {
            postcard.withString("extra", "我是在拦截器中附加的参数");
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }
}
