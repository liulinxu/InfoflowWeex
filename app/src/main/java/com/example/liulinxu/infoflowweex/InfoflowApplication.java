package com.example.liulinxu.infoflowweex;

import android.app.Application;

import com.taobao.weex.WXSDKEngine;

/**
 * Created by liulinxu on 16-7-23.
 */
public class InfoflowApplication  extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        WXSDKEngine.init(this, null, null, null, null);
    }
}
