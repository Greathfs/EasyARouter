package com.hfs.modulehome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hfs.libcommon.utils.RouteUtils;

@Route(path = RouteUtils.Home_Fragment_Main)
public class HomeFragment extends Fragment implements View.OnClickListener {

    /**
     * 登录（跨模块跳转Activity）
     */
    private Button mBtnGotoLogin;
    /**
     * 使用eventBus夸模块通信
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
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
        mInterceptor = (Button) view.findViewById(R.id.interceptor);
        mInterceptor.setOnClickListener(this);
        mAutoInject = (Button) view.findViewById(R.id.autoInject);
        mAutoInject.setOnClickListener(this);
        mBtnUseOtherModuleByName = (Button) view.findViewById(R.id.btn_use_other_module_by_name);
        mBtnUseOtherModuleByName.setOnClickListener(this);
        mBtnUseOtherModuleByType = (Button) view.findViewById(R.id.btn_use_other_module_by_type);
        mBtnUseOtherModuleByType.setOnClickListener(this);
        mFailNav = (Button) view.findViewById(R.id.failNav);
        mFailNav.setOnClickListener(this);
        mInterceptor1 = (Button) view.findViewById(R.id.interceptor1);
        mInterceptor1.setOnClickListener(this);
        mInterceptor2 = (Button) view.findViewById(R.id.interceptor2);
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
            //登录（跨模块跳转Activity）
            ARouter.getInstance().build(RouteUtils.Me_Login).navigation();
        }
    }

}