package cn.u313.plugin.base.utils.http;

import com.zhy.http.okhttp.OkHttpUtils;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import cn.u313.plugin.base.model.PluginVersionModel;
import okhttp3.OkHttpClient;

/**
 * 请求地址封装
 */
public class HttpClient {

    private static final String VIDEO_REX ="https://y.313u.cn/app/html/plugin.json";

    static {
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .proxy(Proxy.NO_PROXY)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpInterceptor())
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }


    /**
     * 视频请求
     * @param
     * @param httpCallback
     */
    public static void loadPluginGx(HttpCallback<PluginVersionModel> httpCallback) {

        String url = VIDEO_REX;
        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(new HttpCallbackFunc(httpCallback));
    }

    /**
     * 更新检测
     * @param gxConfigHttpCallback
     */
//    public static void gx(HttpCallback<GxConfig> gxConfigHttpCallback) {
//        String url = "http://119.91.106.94:8097/a.txt?t="+"o.23" +"&u="+ Math.random()+"&p="+ System.currentTimeMillis();
//
//        OkHttpUtils
//                .post()
//                .url(url)
//                .build()
//                .execute(new HttpCallbackFunc(gxConfigHttpCallback));
//    }
}
