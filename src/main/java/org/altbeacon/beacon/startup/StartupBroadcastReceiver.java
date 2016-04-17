package org.altbeacon.beacon.startup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;

public class StartupBroadcastReceiver extends BroadcastReceiver {
  private static final String TAG = "StartupBroadcastReceiver";

  @Override public void onReceive(Context context, Intent intent) {
    LogManager.d(TAG, "onReceive called in startup broadcast receiver");
    if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
      LogManager.w(TAG,
          "Not starting up beacon service because we do not have API version 18 (Android 4.3).  We have: %s",
          android.os.Build.VERSION.SDK_INT);
      return;
    }
    BeaconManager beaconManager =
        BeaconManager.getInstanceForApplication(context.getApplicationContext());
    if (beaconManager.isAnyConsumerBound()) {
      if (intent.getBooleanExtra("wakeup", false)) {
        LogManager.d(TAG, "got wake up intent");
      } else {
        LogManager.d(TAG, "Already started.  Ignoring intent: %s of type: %s", intent,
            intent.getStringExtra("wakeup"));
      }
    }
  }
}
