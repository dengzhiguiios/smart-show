package com.coder.zzq.smartshowdemo;

import android.app.Application;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.coder.zzq.smartshow.SmartShow;
import com.coder.zzq.smartshow.basebar.IBarSetting;
import com.coder.zzq.smartshow.snackbar.SmartSnackbar;
import com.coder.zzq.smartshow.toast.IProcessToastCallback;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.coder.zzq.smartshow.topbar.SmartTopBar;


/**
 * Created by 朱志强 on 2017/11/12.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        SmartShow.init(this);
        /*
            如果不想使用Toast的默认布局，可以自定义布局，但是在你的布局中必须含有显示消息的
            TextView，且id为android:id="@id/custom_toast_msg"
         */
        SmartToast.setting()
                .backgroundColorRes(R.color.colorPrimary)

                .textSizeSp(18)
                .textBold(true)
                .processView(new IProcessToastCallback() {
                    @Override
                    //root 为布局根View，msgView为显示消息的TextView
                    public void processView(View rootView, TextView msgView) {

                    }
                });


        SmartTopBar.setting()
                .dismissOnLeave(true)
                .backgroundColor(Color.WHITE)
                .msgTextColor(Color.DKGRAY)
                .actionColor(Color.RED)
                .darkStatusBarTextAndIcon()
                .defaultActionTextForIndefinite("ok");

        SmartSnackbar.setting()
                .dismissOnLeave(true)
                .backgroundColorRes(R.color.colorPrimary);


    }
}
