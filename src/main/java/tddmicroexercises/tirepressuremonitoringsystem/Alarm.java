package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private Sensor sensor;
    private boolean alarmOn;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
        this.alarmOn = false;
    }

    public void check() {
        double pressureValue = sensor.probePressureValue();

        if (pressureValue < LowPressureThreshold || HighPressureThreshold < pressureValue) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
