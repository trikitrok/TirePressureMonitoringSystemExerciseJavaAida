import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

import static helpers.AlarmBuilder.anAlarm;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class AlarmShould {

    private Alarm alarm;

    @Test
    public void be_on_when_probed_value_is_too_low() {
        alarm = anAlarm().
                usingSensor(thatProbes(5.0)).
                andWithSafetyRange(17, 21).
                build();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void be_on_when_probed_value_is_too_high() {
        alarm = anAlarm().
                usingSensor(thatProbes(25.0)).
                andWithSafetyRange(17, 21).
                build();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void be_off_when_probed_value_is_within_safety_range() {
        alarm = anAlarm().
                usingSensor(thatProbes(20.0)).
                andWithSafetyRange(17, 21).
                build();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }

    protected Sensor thatProbes(double value) {
        Sensor sensor = mock(Sensor.class);
        doReturn(value).when(sensor).probe();
        return sensor;
    }
}
