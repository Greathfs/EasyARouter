package com.hfs.modulehome;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hfs.libcommon.data.bean.EventBusBean;
import com.hfs.libcommon.data.bean.JavaBean;
import com.hfs.libcommon.data.event.TestEvent;
import com.hfs.libcommon.provider.IChatModuleService;
import com.hfs.libcommon.route_service.ModuleRouteService;
import com.hfs.libcommon.utils.RouteUtils;
import com.hfs.libcommon.utils.UIUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Route(path = RouteUtils.HOME_FRAGMENT_MAIN)
public class HomeFragment extends Fragment implements View.OnClickListener {

    /**
     * 登录（跨模块跳转Activity）
     */
    private Button mBtnGotoLogin;
    /**
     * 使用eventBus跨模块通信
     */
    private Button mBtnEventbus;
    /**
     * 模块间服务调用
     */
    private Button mBtnUseOtherModule;

    /**
     * 使用Uri应用内跳转
     */
    private Button mBtnUri;
    /**
     * 旧版本转场动画
     */
    private Button mOldVersionAnim;
    /**
     * 新版本转场动画
     */
    private Button mNewVersionAnim;
    /**
     * 通过URL跳转（webview）
     */
    private Button mNavByUrl;
    /**
     * 拦截器操作
     */
    private Button mInterceptor;
    /**
     * 依赖注入
     */
    private Button mAutoInject;
    /**
     * 模块间通过路径名称调用服务
     */
    private Button mBtnUseOtherModuleByName;
    /**
     * 模块间通过类名调用服务
     */
    private Button mBtnUseOtherModuleByType;
    /**
     * 跳转失败
     */
    private Button mFailNav;
    /**
     * 测试拦截器
     */
    private Button mBtnTestInterceptor;
    private View view;
    /**
     * 拦截器操作(利用原有分组)
     */
    private Button mInterceptor1;
    /**
     * 拦截器操作(绿色通道，跳过拦截器)
     */
    private Button mInterceptor2;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);
        EventBus.getDefault().register(this);
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    private void initView(View view) {
        mBtnGotoLogin = (Button) view.findViewById(R.id.btn_goto_login);
        mBtnGotoLogin.setOnClickListener(this);
        mBtnEventbus = (Button) view.findViewById(R.id.btn_eventbus);
        mBtnEventbus.setOnClickListener(this);
        mBtnUseOtherModule = (Button) view.findViewById(R.id.btn_use_other_module);
        mBtnUseOtherModule.setOnClickListener(this);
        mBtnUri = (Button) view.findViewById(R.id.btn_uri);
        mBtnUri.setOnClickListener(this);
        mOldVersionAnim = (Button) view.findViewById(R.id.oldVersionAnim);
        mOldVersionAnim.setOnClickListener(this);
        mNewVersionAnim = (Button) view.findViewById(R.id.newVersionAnim);
        mNewVersionAnim.setOnClickListener(this);
        mNavByUrl = (Button) view.findViewById(R.id.navByUrl);
        mNavByUrl.setOnClickListener(this);
        mAutoInject = (Button) view.findViewById(R.id.autoInject);
        mAutoInject.setOnClickListener(this);
        mBtnUseOtherModuleByName = (Button) view.findViewById(R.id.btn_use_other_module_by_name);
        mBtnUseOtherModuleByName.setOnClickListener(this);
        mBtnUseOtherModuleByType = (Button) view.findViewById(R.id.btn_use_other_module_by_type);
        mBtnUseOtherModuleByType.setOnClickListener(this);
        mFailNav = (Button) view.findViewById(R.id.failNav);
        mFailNav.setOnClickListener(this);
        mInterceptor2 = (Button) view.findViewById(R.id.interceptor_green);
        mInterceptor2.setOnClickListener(this);
        mBtnTestInterceptor = view.findViewById(R.id.btn_test_interceptor);
        mBtnTestInterceptor.setOnClickListener(this);
    }

    /**
     * 记住这里要使用常量表达式，因为ADT14以后在library中，去掉了final修饰，
     * google建议使用if-else代替，不用纠结
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_goto_login) {
            ARouter.getInstance().build(RouteUtils.ME_LOGIN).navigation();
        } else if (id == R.id.btn_test_interceptor) {
            ARouter.getInstance().build(RouteUtils.CHAT_TEST).navigation();
        } else if (id == R.id.interceptor_green) {
            //拦截器操作(绿色通道，跳过拦截器)
            ARouter.getInstance().build(RouteUtils.CHAT_TEST)
                    .withString("extra", "我是绿色通道直接过来的，不经过拦截器")
                    .greenChannel()
                    .navigation();

        } else if (id == R.id.btn_eventbus) {
            EventBusBean eventBusBean = new EventBusBean();
            eventBusBean.setEventName("android");

            ARouter.getInstance().build(RouteUtils.ME_EVENT_BUS)
                    .withString("name", "Jack")
                    .withLong("age", 25)
                    .withParcelable("eventbus", eventBusBean)
                    .navigation();
        } else if (id == R.id.btn_uri) {
            EventBusBean eventBusBean = new EventBusBean();
            eventBusBean.setEventName("android");

            Uri uri = Uri.parse("arouter://com.hfs.easyarouter/me/main/EventBus");
            ARouter.getInstance().build(uri)
                    .withString("name", "Jack")
                    .withLong("age", 25)
                    .withParcelable("eventbus", eventBusBean)
                    .navigation();
        }else if (id == R.id.oldVersionAnim) {
            //旧版本转场动画
            ARouter.getInstance()
                    .build(RouteUtils.ME_TEST)
                    .withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                    //context上下文不传无效果
                    .navigation(getContext());

        } else if (id == R.id.newVersionAnim) {
            //新版本转场动画
            ActivityOptionsCompat compat = ActivityOptionsCompat.
                    makeScaleUpAnimation(v, v.getWidth() / 2, v.getHeight() / 2, 0, 0);
            ARouter.getInstance()
                    .build(RouteUtils.ME_TEST)
                    .withOptionsCompat(compat)
                    .navigation();
        }else if (id == R.id.navByUrl) {
            //通过URL跳转（webview）
            ARouter.getInstance()
                    .build(RouteUtils.ME_WEB_VIEW)
                    .withString("url", "file:///android_asset/schame-test.html")
                    .navigation();
        }else if (id == R.id.autoInject) {
            /**
             * 序列化过得
             * 必须先初始化JsonServiceImpl实现SerializationService
             */
            EventBusBean eventBusBean = new EventBusBean();
            eventBusBean.setEventName("android");
            /**
             * 普通的javaBean
             */
            JavaBean javaBean = new JavaBean();
            javaBean.setName("hfs");
            javaBean.setAge(25);

            List<JavaBean> objList = new ArrayList<>();
            objList.add(javaBean);

            Map<String, List<JavaBean>> map = new HashMap<>();
            map.put("testMap", objList);

            ARouter.getInstance().build(RouteUtils.ME_INJECT)
                    .withString("name", "老王")
                    .withInt("age", 18)
                    .withBoolean("boy", true)
                    .withLong("high", 180)
                    .withString("url", "https://www.baidu.com")
                    .withParcelable("pac", eventBusBean)
                    .withObject("obj", javaBean)
                    .withObject("objList", objList)
                    .withObject("map", map)
                    .navigation();
        } else if (id == R.id.btn_use_other_module) {
            //模块间服务调用
            //例如home模块调用chat模块的方法
            String userName = ModuleRouteService.getUserName("userId");
            UIUtils.showToast(userName);
        } else if (id == R.id.btn_use_other_module_by_name) {
            //模块间通过路径名称调用服务
            String userName = ((IChatModuleService) ARouter.getInstance()
                    .build(RouteUtils.SERVICE_CHAT)
                    .navigation())
                    .getUserName("userid");
            UIUtils.showToast(userName);
        } else if (id == R.id.btn_use_other_module_by_type) {
            //模块间通过类名调用服务
            String userName = ARouter.getInstance()
                    .navigation(IChatModuleService.class)
                    .getUserName("userid");
            UIUtils.showToast(userName);
        } else if (id == R.id.failNav) {
            //跳转失败
            ARouter.getInstance().build("/xxx/xxx").navigation(getContext(), new NavCallback() {
                @Override
                public void onFound(Postcard postcard) {
                    UIUtils.showToast("找到了");
                }

                @Override
                public void onLost(Postcard postcard) {
                    UIUtils.showToast("找不到了");
                }

                @Override
                public void onArrival(Postcard postcard) {
                    UIUtils.showToast("跳转完了");
                }

                @Override
                public void onInterrupt(Postcard postcard) {
                    UIUtils.showToast("被拦截了");
                }
            });
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTestEvent(TestEvent testEvent) {
        Toast.makeText(getActivity(), testEvent.msg, Toast.LENGTH_SHORT).show();
    }

}