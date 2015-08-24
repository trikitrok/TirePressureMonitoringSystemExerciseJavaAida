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
        double pressureValue = sensor.probePressureValue();

        if (isNotWithinSafetyRange(pressureValue)) {
            alarmOn = true;
        }
    }

    protected boolean isNotWithinSafetyRange(double pressureValue) {
        return safetyRange.isNotWithin(pressureValue);
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

}
