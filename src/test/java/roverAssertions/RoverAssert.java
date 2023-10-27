package roverAssertions;

import mars_rover.Rover;
import org.assertj.core.api.AbstractAssert;

public class RoverAssert extends AbstractAssert<RoverAssert, Rover> {
    public RoverAssert(Rover actual) {
        super(actual, RoverAssert.class);
    }

    public static RoverAssert assertThat(Rover actual) {
        return new RoverAssert(actual);
    }

}
