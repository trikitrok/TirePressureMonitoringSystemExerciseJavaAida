package helpers;

import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;

public class SafetyRangeBuilder {
    private double lowerThreshold;
    private double higherThreshold;

    public static SafetyRangeBuilder aSafetyRange() {
        return new SafetyRangeBuilder();
    }

    public SafetyRangeBuilder withLowerThreshold(double lowerThreshold) {
        this.lowerThreshold = lowerThreshold;
        return this;
    }

    public SafetyRangeBuilder withHigherThreshold(double higherThreshold) {
        this.higherThreshold = higherThreshold;
        return this;
    }

    public SafetyRange build() {
        return new SafetyRange(lowerThreshold, higherThreshold);
    }
}
