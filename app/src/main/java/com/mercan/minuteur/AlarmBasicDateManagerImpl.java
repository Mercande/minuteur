package com.mercan.minuteur;

import java.util.ArrayList;
import java.util.List;

public class AlarmBasicDateManagerImpl implements AlarmBasicDateManager {

    private boolean isRunning;
    private static AlarmBasicDateManager instance;

    public static AlarmBasicDateManager getInstance() {
        if (instance == null) {
            instance = new AlarmBasicDateManagerImpl();
        }
        return instance;
    }

    AlarmBasicDateManagerImpl() {
        isRunning = false;
        listeners = new ArrayList<>();
    }

    private final List<EndListener> listeners;

    @Override
    public void start() {
        isRunning = true;
        // TODO
        notifyListener();
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    @Override
    public boolean addTime(final int minutes) {
        if (!isRunning) {
            return false;
        }
        // TODO impl
        return true;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void registerEndListener(final EndListener listener) {
        if (listeners.contains(listener)) {
            return;
        }
        listeners.add(listener);
    }

    @Override
    public void unregisterEndListener(final EndListener listener) {
        listeners.remove(listener);
    }

    @Override
    public BasicDate getTimeLeft() {
        return null;
    }

    private void notifyListener() {
        for (EndListener listener : listeners) {
            listener.onMinuteurEnded();
        }
    }
}
