package com.wangchang.panorama_android;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

public class MainActivity extends AppCompatActivity {

    private VrPanoramaView mVrPanoramaView;
    private VrPanoramaView.Options paNormalOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVrPaNormalView();
    }
    //初始化VR图片
    private void initVrPaNormalView() {
        mVrPanoramaView = (VrPanoramaView) findViewById(R.id.mVrPanoramaView);
        paNormalOptions = new VrPanoramaView.Options();
        paNormalOptions.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
//      mVrPanoramaView.setFullscreenButtonEnabled (false); //隐藏全屏模式按钮
        mVrPanoramaView.setInfoButtonEnabled(true); //设置隐藏最左边信息的按钮
        mVrPanoramaView.setStereoModeButtonEnabled(true); //设置隐藏立体模型的按钮
        mVrPanoramaView.setEventListener(new ActivityEventListener()); //设置监听
        //加载本地的图片源
        mVrPanoramaView.loadImageFromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.andes), paNormalOptions);
        //设置网络图片源
//        mVrPanoramaView.loadImageFromByteArray();
    }

    private class ActivityEventListener extends VrPanoramaEventListener {
        @Override
        public void onLoadSuccess() {//图片加载成功
        }


        @Override
        public void onLoadError(String errorMessage) {//图片加载失败
        }

        @Override
        public void onClick() {//当我们点击了VrPanoramaView 时候触发            super.onClick();
        }

        @Override
        public void onDisplayModeChanged(int newDisplayMode) {
            super.onDisplayModeChanged(newDisplayMode);
        }
    }

}
