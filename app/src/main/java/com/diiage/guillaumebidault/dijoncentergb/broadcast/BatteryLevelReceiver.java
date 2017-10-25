package com.diiage.guillaumebidault.dijoncentergb.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

/**
 * Created by GuillaumeBidault on 25/10/2017.
 */

public class BatteryLevelReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
    }
}
