package cn.boz.simulationhisense;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * @author zhaofg
 */
public  class BaseApplication extends Application implements Application.ActivityLifecycleCallbacks {

//    protected static WeakArray<Activity> mActivitys = new WeakArray<>();


    @Override
    public void onCreate() {
        super.onCreate();

        this.registerActivityLifecycleCallbacks(this);
//        this.initConfig();
//        this.initApiConfig();
//        this.initARouter();
//        this.initMonitor();
//        this.initLocation();
    }


    @Override
    public void onActivityCreated(@NonNull Activity activity, Bundle savedInstanceState) {

        Log.e("dxf", "lifecycle-onCreate: " + activity.getLocalClassName());

    }

    @Override
    public void onActivityPreStarted(@NonNull Activity activity) {

        Log.e("dxf", "lifecycle-PreStarted: " + activity.getLocalClassName());


    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

        Log.e("dxf", "lifecycle-onStart: " + activity.getLocalClassName());


    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        Log.e("dxf", "lifecycle-onResume: " + activity.getLocalClassName());
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
        Log.e("dxf", "lifecycle-onPause: " + activity.getLocalClassName());
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        Log.e("dxf", "lifecycle-onStop: " + activity.getLocalClassName());
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
        Log.e("dxf", "lifecycle-onSaveInstanceState: " + activity.getLocalClassName());

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        Log.e("dxf", "lifecycle-onDestroy: " + activity.getLocalClassName());
    }

//    /**
//     * 安全退出
//     */
//    public static void retreatSafely() {
//        if (mActivitys != null && mActivitys.size() > 0) {
//            for (int i = 0; i < mActivitys.size(); i++) {
//                mActivitys.get(i).get().finish();
//            }
//        }
//        android.os.Process.killProcess(android.os.Process.myPid());
//        System.exit(0);
//    }


}
