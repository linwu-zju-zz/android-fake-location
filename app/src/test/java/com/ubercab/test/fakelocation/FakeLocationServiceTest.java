package com.ubercab.test.fakelocation;

import android.content.Intent;
import android.os.Build;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class FakeLocationServiceTest {

    private FakeLocationService service;

    @Before
    public void setUp() {
        service = Robolectric.setupService(FakeLocationService.class);
    }

    @Test
    @Ignore
    public void startService() throws Exception {
        Intent intent = new Intent();
        service.onCreate();
        service.onHandleIntent(intent);
        Assert.assertNotNull("No intent received", intent);
    }
}