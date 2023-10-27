import mars_rover.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static mars_rover.Commands.*;
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

    @ParameterizedTest(name = "in {0}")
    @EnumSource(value = PositionsToMoveBackwardTwice.class)
    void move_backward_twice(PositionsToMoveBackwardTwice positionsToMoveBackwardTwice) {
        Rover rover = new Rover(initialPosition, positionsToMoveBackwardTwice.direction);
        rover.moveBackward();
        rover.moveBackward();

        assertThat(rover).hasPosition(positionsToMoveBackwardTwice.expected);
    }

    @Test
    void follow_a_series_of_commands(){
        List<Commands> commands = List.of(FORWARD);

        Rover roverAfterCommands = rover.followThis(commands);

        assertThat(roverAfterCommands).hasPosition(new Position(0,1));
    }
    @Test
    void follow_a_series_of_commands_2(){
        List<Commands> commands = List.of(BACKWARD);

        Rover roverAfterCommands = rover.followThis(commands);

        assertThat(roverAfterCommands).hasPosition(new Position(0,-1));
    }

    @Test
    void follow_a_series_of_commands_3(){
        List<Commands> commands = List.of(TURN_LEFT);

        Rover roverAfterCommands = rover.followThis(commands);

        assertThat(roverAfterCommands).hasDirection(new West());
    }
}
