package com.ubercab.test.fakelocation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class FackLocationServiceTest {

    private FakeLocationService service;
    private MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MainActivity.class);
        service = Robolectric.setupService(FakeLocationService.class);
    }

    @Test
    @Ignore
    public void startService() throws Exception {

    }
}