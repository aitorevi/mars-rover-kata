import builders.RoverBuilder;
import mars_rover.Rover;
import mars_rover.Territory;
import mars_rover.command.Command;
import mars_rover.direction.East;
import mars_rover.direction.South;
import mars_rover.direction.West;
import mars_rover.position.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import parametrizedEnums.*;

import java.util.List;

import static mars_rover.command.Command.*;
import static roverAssertions.RoverAssert.assertThat;

public class RoverShould {

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
        Rover rover = new RoverBuilder()
                .withDirection(positionsToMoveForwardTwice.direction)
                .withPosition(new Position(2,2))
                .build();
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
        Rover rover = new RoverBuilder()
                .withDirection(positionsToMoveBackwardTwice.direction)
                .withPosition(new Position(2,2))
                .build();
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

        Rover roverAfterCommands = new RoverBuilder().build().followThis(commands);

        assertThat(roverAfterCommands).isEqualTo(
                new RoverBuilder()
                .withDirection(new South())
                .withPosition(new Position(2,1))
                .build());
    }

    @Test
    void appear_in_the_bottom_limit_when_cross_the_top_limit_on_the_planet() {
        Rover rover = new RoverBuilder()
                .withPosition(new Position(1,2))
                .withTerritory(new Territory(3,3))
                .build();

        rover.moveForward();

        assertThat(rover).isEqualTo(
                new RoverBuilder()
                .withPosition(new Position(1,0))
                .withTerritory(new Territory(3,3))
                .build()
        );
    }

    @Test
    void appear_in_the_bottom_limit_when_cross_the_top_limit_on_the_planet2() {
        Rover rover = new RoverBuilder()
                .withPosition(new Position(1,0))
                .withDirection(new South())
                .withTerritory(new Territory(3,3))
                .build();

        rover.moveForward();

        assertThat(rover).isEqualTo(
                new RoverBuilder()
                        .withPosition(new Position(1,2))
                        .withDirection(new South())
                        .withTerritory(new Territory(3,3))
                        .build()
        );
    }

    @Test
    void appear_in_the_bottom_limit_when_cross_the_top_limit_on_the_planet3() {
        Rover rover = new RoverBuilder()
                .withPosition(new Position(0,1))
                .withDirection(new West())
                .withTerritory(new Territory(3,3))
                .build();

        rover.moveForward();

        assertThat(rover).isEqualTo(
                new RoverBuilder()
                        .withPosition(new Position(2,1))
                        .withDirection(new West())
                        .withTerritory(new Territory(3,3))
                        .build()
        );
    }

    @Test
    void appear_in_the_bottom_limit_when_cross_the_top_limit_on_the_planet4() {
        Rover rover = new RoverBuilder()
                .withPosition(new Position(2,1))
                .withDirection(new East())
                .withTerritory(new Territory(3,3))
                .build();

        rover.moveForward();

        assertThat(rover).isEqualTo(
                new RoverBuilder()
                        .withPosition(new Position(0,1))
                        .withDirection(new East())
                        .withTerritory(new Territory(3,3))
                        .build()
        );
    }
}