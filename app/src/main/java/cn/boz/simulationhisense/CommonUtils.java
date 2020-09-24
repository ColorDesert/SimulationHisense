/*
 *     (C) Copyright 2019, ForgetSky.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package cn.boz.simulationhisense;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class CommonUtils {
    private static final String TAG = "CommonUtils";

    private static Context applicationContext;
    private static String imei = "";
    private static String meid = "";
    private static String appVersion;
    private static String sysVersion;

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(Context applicationContext) {
        CommonUtils.applicationContext = applicationContext;
    }

    public static void startActivityByUri(Context context, String uriString) {
        Uri uri = Uri.parse(uriString);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, R.string.not_install, Toast.LENGTH_SHORT).show();
        }
    }

    public static void startOperatorActivityByUri(Context context, String uriString) {
        Uri uri = Uri.parse(uriString);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, R.string.not_install, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 拨打电话
     *
     * @param context   Context
     * @param uriString 拨打的电话的URI字符串
     */
    public static void callPhone(Context context, String uriString) {
        Intent intent = new Intent(); // 意图对象：动作 + 数据
        intent.setAction(Intent.ACTION_CALL); // 设置动作
        Uri data = Uri.parse(uriString); // 设置数据
        intent.setData(data);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, R.string.not_install, Toast.LENGTH_SHORT).show();
        }
    }


//    public static void startVideoActivityByUri(Context context, String uid) {
//        Uri uri = Uri.parse(UriUtils.VIDEO_CHAT + uid);
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        try {
//            context.startActivity(intent);
//        } catch (ActivityNotFoundException e) {
//            Toast.makeText(context, R.string.not_install, Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//    public static void startSearchActivity(Context context) {
//        Intent intent = new Intent();
//        ComponentName componentName = new ComponentName("com.android.quicksearchbox", "com.android.quicksearchbox.SearchActivity");
//        intent.setComponent(componentName);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }
//
//
//    public static String getIMEI(Context context) {
//        if (TextUtils.isEmpty(imei)) {
//            try {
//                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    imei = telephonyManager.getImei(0);
//                }
//
//            } catch (SecurityException e) {
//                Logger.e("getIMEI  SecurityException e " + e);
//            } catch (Exception e) {
//                Logger.e("getIMEI  Exception e " + e);
//            }
//        }
//        Logger.d("imei= " + imei);
//        return imei;
//    }
//
//    public static String getMEID(Context context) {
//        if (TextUtils.isEmpty(meid)) {
//            try {
//                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    meid = telephonyManager.getMeid();
//                }
//
//            } catch (SecurityException e) {
//                Logger.e("getMEID  SecurityException e " + e);
//            } catch (Exception e) {
//                Logger.e("getMEID  Exception e " + e);
//            }
//        }
//        Logger.d("getMEID  meid= " + meid);
//        return meid;
//    }
//
//    @SuppressLint({"NewApi", "MissingPermission"})
//    public static String getSerialNumber() {
//        String sn = "123456";
//        try {
//            @SuppressLint("PrivateApi")
//            Class<?> systemProperty = Class.forName("android.os.SystemProperties");
//            Method getStable = systemProperty.getMethod("getStable", String.class, String.class);
//            sn = (String) getStable.invoke(null, "stable.sys.msnno", "123456");
//            Log.d(TAG, "getSN  sn = " + sn);
//        } catch (SecurityException e) {
//            Log.e(TAG, "getSN  SecurityException e " + e);
//        } catch (Exception e) {
//            Log.e(TAG, "getSN  Exception e " + e);
//        }
//        return sn;
//    }
//
//    /**
//     * 获取负一屏版本号
//     *
//     * @param context
//     * @return
//     */
//    public static String getAppVersion(Context context) {
//        if (TextUtils.isEmpty(appVersion)) {
//            List<PackageInfo> pakageinfos;
//            PackageManager packageManager = context.getPackageManager();
//            pakageinfos = packageManager.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
//            for (PackageInfo pi : pakageinfos) {
//                if ("com.zsmarter.launcher.plugin".equals(pi.packageName)) {
//                    appVersion = pi.versionCode + "";
//                }
//            }
//        }
//        Logger.d(TAG, "appVersion : " + appVersion);
//        return appVersion;
//    }
//
//    /**
//     * 获取系统版本号 TODO 正确性待验证
//     *
//     * @return
//     */
//    public static String getSysVersion() {
//        String[] version = {"null", "null", "null", "null"};
//        String str1 = "/proc/version";
//        String str2;
//        String[] arrayOfString;
//        try {
//            FileReader localFileReader = new FileReader(str1);
//            BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
//            str2 = localBufferedReader.readLine();
//            arrayOfString = str2.split("\\s+");
//            version[0] = arrayOfString[2];//KernelVersion
//            localBufferedReader.close();
//        } catch (IOException e) {
//        }
//        version[1] = Build.VERSION.RELEASE;// firmware version
//        version[2] = Build.MODEL;//model
//        version[3] = Build.DISPLAY;//system version
//        sysVersion = version[1];
//        Logger.d(TAG, "sysVersion : " + sysVersion);
//        return sysVersion;
//    }

}
