package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;
    private final SafetyRange safetyRange;

    private Sensor sensor;
    private boolean alarmOn;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
        this.alarmOn = false;
        this.safetyRange = new SafetyRange(LowPressureThreshold, HighPressureThreshold);
    }

    public void check() {
        double pressureValue = sensor.probePressureValue();

        if (isNotWithinSafetyRange(pressureValue)) {
            alarmOn = true;
        }
    }

    protected boolean isNotWithinSafetyRange(double pressureValue) {
        return pressureValue < LowPressureThreshold || HighPressureThreshold < pressureValue;
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    private class SafetyRange {
        private final double lowerThreshold;
        private final double higherThreshold;

        public SafetyRange(double lowerThreshold, double higherThreshold) {
            this.lowerThreshold = lowerThreshold;
            this.higherThreshold = higherThreshold;
        }
    }
}
