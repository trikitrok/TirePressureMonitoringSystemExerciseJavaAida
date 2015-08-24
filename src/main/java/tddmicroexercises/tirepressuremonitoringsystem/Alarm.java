package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final SafetyRange safetyRange;
    private Sensor sensor;
    private boolean alarmOn;

    public Alarm(Sensor sensor, SafetyRange safetyRange) {
        this.sensor = sensor;
        this.safetyRange = safetyRange;
        this.alarmOn = false;
    }

    public void check() {
        double value = sensor.probe();

        if (isNotWithinSafetyRange(value)) {
            alarmOn = true;
        }
    }

    protected boolean isNotWithinSafetyRange(double value) {
        return safetyRange.isNotWithin(value);
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

}
