package com.sevenfoxsolutions.capacitor.appversion;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;

import java.lang.reflect.Field;

public class aversion {

    public void appName(PluginCall call, Context context) {
        try {
            String appName = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            JSObject obj = new JSObject();
            obj.put("name", appName);
            JSObject re = new JSObject();
            re.put("results",obj);
            call.resolve(re);
        }catch (Exception exception){
            call.errorCallback(exception.getMessage());
        }
    }
    public void PackageName(PluginCall call, Context context) {
        try{
            String appName = context.getApplicationInfo().packageName;
            JSObject obj = new JSObject();
            obj.put("packageName", appName);
            JSObject re = new JSObject();
            re.put("results",obj);
            call.resolve(re);
        }
        catch (Exception exception){
            call.errorCallback(exception.getMessage());
        }
    }
    public void VersionNumber(PluginCall call, Context context) {
        try{
            PackageManager packageManager = context.getPackageManager();
            String versionName =  packageManager.getPackageInfo(context.getPackageName(),0).versionName;
            JSObject obj = new JSObject();
            obj.put("versionNumber", versionName);
            JSObject re = new JSObject();
            re.put("results",obj);
            call.resolve(re);
        }
        catch (Exception exception){
            call.errorCallback(exception.getMessage());
        }
    }
    public void VersionCode(PluginCall call, Context context) {

        try{
            PackageManager packageManager = context.getPackageManager();
            Integer versionName =  packageManager.getPackageInfo(context.getPackageName(),0).versionCode;
            JSObject obj = new JSObject();
            obj.put("versionCode", versionName);
            JSObject re = new JSObject();
            re.put("results",obj);
            call.resolve(re);
        } catch (Exception exception){
            call.errorCallback(exception.getMessage());
        }

    }
    public void androidVer(PluginCall call) {
        try{

            String version2 = Build.VERSION.RELEASE;
            JSObject obj = new JSObject();
            obj.put("androidVersion", version2);
            JSObject re = new JSObject();
            re.put("results",obj);
            call.resolve(re);
        } catch (Exception exception){
            call.errorCallback(exception.getMessage());
        }
    }
    public void androidSdkVersion(PluginCall call) {
        try{
            Integer version = android.os.Build.VERSION.SDK_INT;
            JSObject obj = new JSObject();
            obj.put("androidSDK", version);
            JSObject re = new JSObject();
            re.put("results",obj);
            call.resolve(re);
        } catch (Exception exception){
            call.errorCallback(exception.getMessage());
        }
    }
    public void androidOsName(PluginCall call) {
        try{

            StringBuilder builder = new StringBuilder();
            builder.append("android : ").append(Build.VERSION.RELEASE);

            Field[] fields = Build.VERSION_CODES.class.getFields();
            for (Field field : fields) {
                String fieldName = field.getName();
                int fieldValue = -1;
                try {
                    fieldValue = field.getInt(new Object());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                if (fieldValue == Build.VERSION.SDK_INT) {
                    builder.append(" : ").append(fieldName).append(" : ");
                    builder.append("sdk=").append(fieldValue);
                }
            }
            JSObject obj = new JSObject();
            obj.put("androidOS", builder);
            JSObject re = new JSObject();
            re.put("results",obj);
            call.resolve(re);
        } catch (Exception exception){
            call.errorCallback(exception.getMessage());
        }
    }
}
