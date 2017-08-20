package helpers;

import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

public class AlarmBuilder {
    private SafetyRangeBuilder safetyRangeBuilder;
    private Sensor sensor;

    public static AlarmBuilder anAlarm() {
        return new AlarmBuilder();
    }

    public AlarmBuilder usingSensor(Sensor sensor) {
        this.sensor = sensor;
        return this;
    }

    public AlarmBuilder and(SafetyRangeBuilder safetyRangeBuilder) {
        this.safetyRangeBuilder = safetyRangeBuilder;
        return this;
    }

    public Alarm build() {
        return new Alarm(sensor, safetyRangeBuilder.build());
    }
}
