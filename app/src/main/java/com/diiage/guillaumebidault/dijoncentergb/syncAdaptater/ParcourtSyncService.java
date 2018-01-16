package com.diiage.guillaumebidault.dijoncentergb.syncAdaptater;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by GuillaumeBidault on 18/12/2017.
 */

public class ParcourtSyncService extends Service {

    private static ParcourtSyncAdapter mParcourtSyncAdaptateur = null;
    // Object to use as a thread-safe lock
    private static final Object mParcourtSyncAdaptateurLock = new Object();
    /*
     * Instantiate the sync adapter object.
     */
    @Override
    public void onCreate() {
        synchronized (mParcourtSyncAdaptateurLock) {
            if (mParcourtSyncAdaptateur == null) {
                mParcourtSyncAdaptateur = new ParcourtSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
