import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

import static helpers.AlarmBuilder.anAlarm;
import static helpers.SafetyRangeBuilder.aSafetyRange;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class AlarmShould {

    private Alarm alarm;

    @Test
    public void be_on_when_probed_value_is_too_low() {
        alarm = anAlarm().
            usingSensor(thatProbes(5.0)).
            and(aSafetyRange().
                withLowerThreshold(5.5).
                withHigherThreshold(21)).
            build();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));

        assertTrue(alarm.isAlarmOn());

        assertThat("hola", is(equalTo("hola")));
    }

    @Test
    public void be_on_when_probed_value_is_too_high() {
        alarm = anAlarm().
            usingSensor(thatProbes(25.0)).
            and(aSafetyRange().
                withLowerThreshold(17.0).
                withHigherThreshold(24.5)).
            build();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void be_off_when_probed_value_is_within_safety_range() {
        alarm = anAlarm().
            usingSensor(thatProbes(20.0)).
            and(aSafetyRange().
                withLowerThreshold(19.5).
                withHigherThreshold(20.3)).
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
