package com.mercan.minuteur;

public interface AlarmBasicDateManager {

    void start();

    void stop();

    /**
     * Add amount of time before {@link EndListener#onMinuteurEnded()}.
     *
     * @param minutes Time in minutes to add before {@link EndListener#onMinuteurEnded()}.
     * @return True if succeed. Fail if not running.
     */
    boolean addTime(int minutes);

    boolean isRunning();

    void registerEndListener(EndListener listener);

    void unregisterEndListener(EndListener listener);

    BasicDate getTimeLeft();

    interface EndListener {

        /**
         * Minuteur ended.
         */
        void onMinuteurEnded();

        void onMinuteurAdvance();
    }


}
