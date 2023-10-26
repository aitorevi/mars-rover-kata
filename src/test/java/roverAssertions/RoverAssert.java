package roverAssertions;
import mars_rover.Position;
import mars_rover.Rover;
import org.assertj.core.api.AbstractAssert;

public class RoverAssert extends AbstractAssert<RoverAssert, Rover> {
    public RoverAssert(Rover actual) {
        super(actual, RoverAssert.class);
    }

    public static RoverAssert assertThat1(Rover actual) {
        return new RoverAssert(actual);
    }

    public RoverAssert hasPosition(Position position) {
        isNotNull();

        if(!actual.getPosition().equals(position)) {
            failWithMessage("Expected Rover position to be " + position + "but was " + actual.getPosition());
        }

        return this;
    }
}
