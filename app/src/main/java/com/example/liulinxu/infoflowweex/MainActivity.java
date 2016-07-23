package com.example.liulinxu.infoflowweex;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements IWXRenderListener{
    private final String TAG = "MainActivity";
    private RelativeLayout mContentPanel;
    private WXSDKInstance mInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ///
        mInstance = new WXSDKInstance(this);
        mContentPanel = (RelativeLayout) findViewById(R.id.contentPanel);

        loadFromService();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mInstance.registerRenderListener(this);
    }

    private void loadFromLocal(){

    }

    private void loadFromService(){
        /**
         * 在父容器不为window时，不知道会不会有问题，因为oncreate方法中时不知道view的宽高的。
         * 如果放到后面会不会影响页面的加载速度
         */
        mInstance.renderByUrl(TAG,"http://100.84.253.100:8081/weex_tmp/h5_render/tech_list.js",new HashMap<String, Object>(),
                null,
                getWindow().getDecorView().getWidth(),
                getWindow().getDecorView().getHeight(),
                WXRenderStrategy.APPEND_ASYNC);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(mInstance!=null){
            mInstance.onActivityStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mInstance!=null){
            mInstance.onActivityResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mInstance!=null){
            mInstance.onActivityPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mInstance!=null){
            mInstance.onActivityStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mInstance!=null){
            mInstance.onActivityDestroy();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
        mContentPanel.addView(view);
    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {

    }
}
