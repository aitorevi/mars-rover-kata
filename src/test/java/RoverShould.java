import mars_rover.Direction;
import mars_rover.North;
import mars_rover.Position;
import mars_rover.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static roverAssertions.RoverAssert.assertThat;

public class RoverShould {
    Position initialPosition;
    Direction initialDirection;
    Rover rover;

    @BeforeEach
    void setup() {
        initialPosition = new Position(0, 0);
        initialDirection = new North();
        rover = new Rover(initialPosition, initialDirection);
    }

    @Test
    void start_with_and_initial_position_facing_initial_direction() {
        assertThat(rover).hasPosition(initialPosition);
        assertThat(rover).hasDirection(initialDirection);
    }

    @ParameterizedTest(name = "facing in {0}")
    @EnumSource(value = DirectionsToLeft.class)
    void turn_left(DirectionsToLeft direction) {
        Rover rover = new Rover(initialPosition, direction.initialDirection);
        rover.turnLeft();
        assertThat(rover).hasDirection(direction.expectedDirection);
    }

    @ParameterizedTest(name = "facing in {0}")
    @EnumSource(value = DirectionsToRight.class)
    void turn_right(DirectionsToRight direction) {
        Rover rover = new Rover(initialPosition, direction.initialDirection);
        rover.turnRight();
        assertThat(rover).hasDirection(direction.expectedDirection);
    }

    @ParameterizedTest(name = "in {0}")
    @EnumSource(value = PositionsToMoveForward.class)
    void move_forward(PositionsToMoveForward positionToMoveForward) {
        Rover rover = new Rover(initialPosition, positionToMoveForward.direction);
        rover.moveForward();

        assertThat(rover).hasPosition(positionToMoveForward.expected);
    }

    @ParameterizedTest(name = "in {0}")
    @EnumSource(value = PositionsToMoveForwardTwice.class)
    void move_forward_twice(PositionsToMoveForwardTwice positionsToMoveForwardTwice) {
        Rover rover = new Rover(initialPosition, positionsToMoveForwardTwice.direction);
        rover.moveForward();
        rover.moveForward();

        assertThat(rover).hasPosition(positionsToMoveForwardTwice.expected);
    }
}
