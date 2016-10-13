package com.bryan.incrementupdate;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void patch(View v){
        //增量包
        String patch=Environment.getExternalStorageDirectory().getAbsolutePath()+"/app.patch";
        //新生成包
        String newApk=Environment.getExternalStorageDirectory().getAbsolutePath()+"/new.apk";
        if(new File(patch).exists())
         BsPatch.bspatch(getSoureAPK(),newApk,patch);
        if(new File(newApk).exists())
          install(this,newApk);

    }

    public String getSoureAPK(){
       ApplicationInfo applicationInfo= getApplicationInfo();
       String source=applicationInfo.sourceDir;
        Log.e(TAG,source);
       return source;
    }

    public static void install(Context context, String apkPath) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setDataAndType(Uri.fromFile(new File(apkPath)),
                "application/vnd.android.package-archive");
        context.startActivity(i);
       // android.os.Process.killProcess(android.os.Process.myPid());
    }


}
