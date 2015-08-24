import org.junit.Before;
import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class AlarmShould {

    private SafetyRange safetyRange;

    @Before
    public void setUp() throws Exception {
        safetyRange = new SafetyRange(17, 21);
    }

    @Test
    public void be_on_when_probed_value_is_too_low() {
        Alarm alarm = new Alarm(sensorThatProbes(5.0), safetyRange);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void be_on_when_probed_value_is_too_high() {
        Alarm alarm = new Alarm(sensorThatProbes(25.0), safetyRange);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void be_off_when_probed_value_is_within_safety_range() {
        Alarm alarm = new Alarm(sensorThatProbes(20.0), safetyRange);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }

    protected Sensor sensorThatProbes(double value) {
        Sensor sensor = mock(Sensor.class);
        doReturn(value).when(sensor).probe();
        return sensor;
    }
}
