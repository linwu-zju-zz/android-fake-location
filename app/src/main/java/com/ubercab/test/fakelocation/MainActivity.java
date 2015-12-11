package com.ubercab.test.fakelocation;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    static boolean isEnabled = false;
    Button startButton;
    Button stopButton;
    EditText latitudeEditText;
    EditText longitudeEditText;
    float mLatitude;
    float mLongitude;
    public static final String TAG = "FakeLocation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    public void initUI() {
        latitudeEditText = (EditText) findViewById(R.id.latitudeEditText);
        longitudeEditText = (EditText) findViewById(R.id.longitudeEditText);
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startFakeLocations();
            }
        });
        stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                stopFakeLocations();
            }
        });
    }

    public void startFakeLocations() {
        isEnabled = true;
        try {
            mLatitude = Float.parseFloat(latitudeEditText.getText().toString());
            mLongitude = Float.parseFloat(longitudeEditText.getText().toString());
        } catch(NumberFormatException e) {
            Toast.makeText(this, getString(R.string.error_input), Toast.LENGTH_LONG).show();
            return;
        }
        if(!checkCoordinate(mLatitude, mLongitude)) {
            Toast.makeText(this, getString(R.string.error_input), Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(this, FakeLocationService.class);
        intent.putExtra(getString(R.string.latitude), mLatitude);
        intent.putExtra(getString(R.string.longitude), mLongitude);
        startService(intent);
    }

    public boolean checkCoordinate(double latitude, double longitude) {
        return (latitude >= -90 && latitude <= 90) && (longitude >= -180 && longitude <= 180);
    }

    public void stopFakeLocations() {
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