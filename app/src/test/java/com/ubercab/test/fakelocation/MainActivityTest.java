package com.ubercab.test.fakelocation;

import android.os.Build;
<<<<<<< 519353268ae77c48ec24571dfad5055b1346c15c
import android.widget.Button;

import org.apache.tools.ant.Main;
=======

>>>>>>> UnitTest
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

<<<<<<< 519353268ae77c48ec24571dfad5055b1346c15c
import static org.junit.Assert.*;

=======
>>>>>>> UnitTest
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void testInput() throws Exception{
        assert(activity.checkCoordinate(-90, 180));
        assert(!activity.checkCoordinate(-91, 181));
        assert(activity.checkCoordinate(0, 0));
        assert(activity.checkCoordinate(90, -180));
    }
}