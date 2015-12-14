package com.ubercab.test.fakelocation;

import android.app.IntentService;
import android.content.Intent;
import android.location.LocationManager;
import android.util.Log;


public class StopFakeLocation extends IntentService {

    public static final String TAG = "FakeLocation";
    public StopFakeLocation() {
        super("StopFakeLocation");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            LocationManager locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
            if (locationManager.getProvider(LocationManager.GPS_PROVIDER) == null) {
                return;
            }
            locationManager.removeUpdates(FakeLocationService.listener);
            locationManager.setTestProviderEnabled(LocationManager.GPS_PROVIDER, false);
            Log.v(TAG, "fake location disabled");
            if (FakeLocationService.mTimer != null) {
                FakeLocationService.mTimer.cancel();
                FakeLocationService.mTimer = null;
            }
            locationManager.removeTestProvider(LocationManager.GPS_PROVIDER);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
