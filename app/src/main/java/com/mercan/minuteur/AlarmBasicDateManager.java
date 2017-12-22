package com.mercan.minuteur;

public interface AlarmBasicDateManager {

    void start();

    void stop();

    boolean addTime(int minutes);

    boolean isRunning();

    void registerEndListener(EndListener listener);

    void unregisterEndListener(EndListener listener);

    BasicDate getTimeLeft();

    interface EndListener {
        void onMinuteurEnded();

        void onMinuteurAdvance();
    }


}
