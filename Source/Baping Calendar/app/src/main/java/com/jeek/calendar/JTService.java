package com.jeek.calendar;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.jeek.calendar.activity.MainActivity;

public class JTService extends Service {

  private static final String TAG = "ScreenActivity";
  private IntentFilter recevierFilter;
  private ScreenOnBroadcastReciver sOnBroadcastReciver;

  public JTService() {
  }

  @Override
  public IBinder onBind(Intent intent) {
    // TODO: Return the communication channel to the service.
    return null;
    //throw new UnsupportedOperationException("Not yet implemented");
  }

  @Override
  public void onCreate(){
    super.onCreate();
    /**注册唤醒和锁屏时的广播**/
    sOnBroadcastReciver=new ScreenOnBroadcastReciver();
    recevierFilter=new IntentFilter();
    recevierFilter.addAction(Intent.ACTION_SCREEN_ON);
    recevierFilter.addAction(Intent.ACTION_SCREEN_OFF);
    registerReceiver(sOnBroadcastReciver, recevierFilter);

    //Toast.makeText(this, "服务已创建！", Toast.LENGTH_LONG).show();
  }
  public void onDestroy(){
    super.onDestroy();
    unregisterReceiver(sOnBroadcastReciver);
  }

  class ScreenOnBroadcastReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
      intent=new Intent(JTService.this,MainActivity.class);
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(intent);
    }
  }

}
