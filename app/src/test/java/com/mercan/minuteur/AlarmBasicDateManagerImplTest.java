package com.mercan.minuteur;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlarmBasicDateManagerImplTest {

    private AlarmBasicDateManager alarmBasicDateManager;

    @Before
    public void setup() {
        alarmBasicDateManager = new AlarmBasicDateManagerImpl();
    }

    @Test
    public void shouldNotRunningBeforeStart() {
        boolean running = alarmBasicDateManager.isRunning();
        Assert.assertFalse(running);
    }

}
