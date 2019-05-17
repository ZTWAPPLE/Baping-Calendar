package com.jeek.calendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class BootCpltReceiver extends BroadcastReceiver {
  public BootCpltReceiver() {
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    // TODO: This method is called when the BroadcastReceiver is receiving
    Intent service = new Intent(context,JTService.class);
    context.startService(service); //启动 服务
    //Toast. makeText(context, "启动完成！", Toast. LENGTH_LONG). show();
    //throw new UnsupportedOperationException("Not yet implemented");
  }
}
