import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AlarmShould {

    @Test
    public void be_on_when_pressure_value_is_too_low() {
        Alarm alarm = new FakeAlarm(5.0);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    private class FakeAlarm extends Alarm {
        private final double samplePressure;

        public FakeAlarm(double samplePressure) {
            super();
            this.samplePressure = samplePressure;
        }

        @Override
        protected double probeValue() {
            return samplePressure;
        }
    }
}
