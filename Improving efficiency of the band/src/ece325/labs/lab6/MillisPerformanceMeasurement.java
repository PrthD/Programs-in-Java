package ece325.labs.lab6;

public class MillisPerformanceMeasurement implements PerformanceMeasurement {
    private long startTime;
    private long endTime;

    @Override
    public void start() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void end() {
        endTime = System.currentTimeMillis();
    }

    @Override
    public void reset() {
        startTime = 0;
        endTime = 0;
    }

    @Override
    public long getResult() {
        return endTime - startTime;
    }
}