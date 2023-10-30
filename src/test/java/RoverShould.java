import builders.RoverBuilder;
import mars_rover.*;
import mars_rover.command.Command;
import mars_rover.direction.Direction;
import mars_rover.direction.North;
import mars_rover.direction.South;
import mars_rover.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import parametrizedEnums.*;

import java.util.List;

import static mars_rover.command.Command.*;
import static roverAssertions.RoverAssert.assertThat;

public class RoverShould {
    Position initialPosition;
    Direction initialDirection;
    Rover initialRover;

    @BeforeEach
    void setup() {
        initialPosition = new Position(0, 0);
        initialDirection = new North();
        initialRover = new RoverBuilder().build();
    }

    @ParameterizedTest(name = "facing in {0}")
    @EnumSource(value = DirectionsToLeft.class)
    void turn_left(DirectionsToLeft direction) {
        Rover rover = new RoverBuilder().withDirection(direction.initialDirection).build();
        rover.turnLeft();
        assertThat(rover).isEqualTo(new RoverBuilder().withDirection(direction.expectedDirection).build());
    }

    @ParameterizedTest(name = "facing in {0}")
    @EnumSource(value = DirectionsToRight.class)
    void turn_right(DirectionsToRight direction) {
        Rover rover = new RoverBuilder().withDirection(direction.initialDirection).build();
        rover.turnRight();
        assertThat(rover).isEqualTo(new RoverBuilder().withDirection(direction.expectedDirection).build());
    }

    @ParameterizedTest(name = "in {0}")
    @EnumSource(value = PositionsToMoveForward.class)
    void move_forward(PositionsToMoveForward positionToMoveForward) {
        Rover rover = new RoverBuilder().withDirection(positionToMoveForward.direction).build();
        rover.moveForward();

        assertThat(rover).isEqualTo(
                new RoverBuilder()
                .withDirection(positionToMoveForward.direction)
                .withPosition(positionToMoveForward.expected)
                .build()
        );
    }

    @ParameterizedTest(name = "in {0}")
    @EnumSource(value = PositionsToMoveForwardTwice.class)
    void move_forward_twice(PositionsToMoveForwardTwice positionsToMoveForwardTwice) {
        Rover rover = new RoverBuilder().withDirection(positionsToMoveForwardTwice.direction).build();
        rover.moveForward();
        rover.moveForward();

        assertThat(rover).isEqualTo(
                new RoverBuilder()
                .withDirection(positionsToMoveForwardTwice.direction)
                .withPosition(positionsToMoveForwardTwice.expected)
                .build()
        );
    }

    @ParameterizedTest(name = "in {0}")
    @EnumSource(value = PositionsToMoveBackwardTwice.class)
    void move_backward_twice(PositionsToMoveBackwardTwice positionsToMoveBackwardTwice) {
        Rover rover = new RoverBuilder().withDirection(positionsToMoveBackwardTwice.direction).build();
        rover.moveBackward();
        rover.moveBackward();

        assertThat(rover).isEqualTo(
                new RoverBuilder()
                .withDirection(positionsToMoveBackwardTwice.direction)
                .withPosition(positionsToMoveBackwardTwice.expected)
                .build()
        );
    }

    @Test
    void follow_a_series_of_commands() {
        List<Command> commands = List.of(FORWARD, TURN_LEFT, BACKWARD, TURN_RIGHT, BACKWARD, TURN_RIGHT, TURN_RIGHT);

        Rover roverAfterCommands = initialRover.followThis(commands);

        assertThat(roverAfterCommands).isEqualTo(
                new RoverBuilder()
                .withDirection(new South())
                .withPosition(new Position(1,0))
                .build());
    }

    @Test
    void appear_in_the_bottom_limit_when_cross_the_top_limit_on_the_planet() {

        Rover rover = new Rover(new Position(0,1), new North(), new Territory(3,3));
        rover.moveForward();
        assertThat(rover).isEqualTo(new Rover(new Position(0,-1), new North(), new Territory(3,3)));

    }
}