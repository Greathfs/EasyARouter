package com.hfs.libcommon.utils;

/**
 *
 * @author HuangFusheng
 * @date 2018/12/13
 * @description RouteUtils
 */

public class RouteUtils {
    /**
     * 获得home模块fragment
     */
    public static final String HOME_FRAGMENT_MAIN = "/home/main";
    /**
     * 获得chat模块fragment
     */
    public static final String CHAT_FRAGMENT_MAIN = "/chat/main";
    /**
     * 获得Recom模块fragment
     */
    public static final String RECOM_FRAGMENT_MAIN = "/recom/main";
    /**
     * 获得Recom模块测试拦截器fragment
     */
    public static final String RECOM_FRAGMENT_TEST_INTER = "/recom/test_inter";
    /**
     * 获得Me模块fragment
     */
    public static final String ME_FRAGMENT_MAIN = "/me/main";
    /**
     * 跳转到登录页面
     */
    public static final String ME_LOGIN = "/me/main/login";
    /**
     * 跳转到eventBus数据接收页面
     */
    public static final String ME_EVENT_BUS = "/me/main/EventBus";
    /**
     * 跳转到TextOne数据接收页面
     */
    public static final String ME_TEXT_ONE = "/me/main/TextOne";
    /**
     * 跳转到Test公用页面
     */
    public static final String ME_TEST = "/me/main/Test";
    /**
     * 路由拦截
     */
    public static final String ME_TEST2 = "/me/main/Test2";
    /**
     * 跳转到webview页面
     */
    public static final String ME_WEB_VIEW = "/me/main/WebView";
    /**
     * 跳转到依赖注入页面
     */
    public static final String ME_INJECT = "/me/main/Inject";
    /**
     * 依赖注入使用，注意：必须实现SerializationService进行注册，
     */
    public static final String Home_Json_Service = "/huangxiaoguo/json";
    /**
     * 跳转ForResult
     */
    public static final String CHAT_FOR_RESULT = "/chat/main/ForResult";
    /**
     * 模块间服务调用，调用chat模块的接口
     */
    public static final String SERVICE_CHAT = "/chat/service";
    /**
     * 路由拦截
     */
    public static final String CHAT_INTERCEPTOR = "/chat/main/Interceptor";

    /**
     * 专门的分组，这里就叫做needLogin组，凡是在这个组下的，都会进行登录验证
     */
    public static final String CHAT_TEST = "/needLogin/test";

}
