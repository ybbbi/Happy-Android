package com.lihang.selfmvvm.customview.iosdialog;

import android.app.Activity;
import android.view.View;

/**
 * Created by leo on 2016/12/27.
 */
public final class DialogUtil {

    private DialogUtil() {
    }


    //需要no的点击监听，那么再加个接口。实现。
    public interface DialogAlertListener {
        void yes() ;
    }


    //单设备登录
    public static void alertDoctorDialog(Activity act,String title, String content, String confirmMessage, final DialogAlertListener listener) {
        DoctorDialog dialog = new DoctorDialog(act).builder();
        dialog.setContent(content);
        dialog.setTitle(title);
        dialog.setConfirmMsg(confirmMessage);
        dialog.setCancaleGone();
        dialog.setCancelable(false);
        dialog.setConfirmButton(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.yes();
            }
        });

        if (act != null && !act.isFinishing()) {
            dialog.show();
        }
    }





    /*
    * 仿ios dialog
    * */
    public static void alertIosDialog(Activity act, String message, String confirmMessage, String cancleMessage, final DialogAlertListener listener) {
        IosAlertDialogByleo dialog = new IosAlertDialogByleo(act).builder();
        dialog.setMsg(message);
        dialog.setConfirmMsg(confirmMessage);
        dialog.setConcleMsg(cancleMessage);
        dialog.setConfirmButton(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.yes();
            }
        });
//        dialog.setNegativeButton("取消", new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//            }
//        });
        if (act != null && !act.isFinishing()) {
            dialog.show();
        }
    }





}
