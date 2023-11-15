import builders.RoverBuilder;
import mars_rover.Rover;
import mars_rover.Territory;
import mars_rover.position.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import parametrizedEnums.*;

import static roverAssertions.RoverAssert.assertThat;

public class DriverShould {
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

    @ParameterizedTest(name = "{0}")
    @EnumSource(value = PositionsToMoveForwardInTheLimit.class)
    void appear_in_the_other_side_when_move_forward_in_the_limit(PositionsToMoveForwardInTheLimit positionsToMoveForwardInTheLimit) {
        Rover rover = new RoverBuilder()
                .withPosition(positionsToMoveForwardInTheLimit.initialPosition)
                .withDirection(positionsToMoveForwardInTheLimit.direction)
                .withTerritory(new Territory(3,3))
                .build();

        rover.moveForward();

        assertThat(rover).isEqualTo(
                new RoverBuilder()
                        .withPosition(positionsToMoveForwardInTheLimit.expectedPosition)
                        .withDirection(positionsToMoveForwardInTheLimit.direction)
                        .withTerritory(new Territory(3,3))
                        .build()
        );
    }

    @ParameterizedTest(name = "{0}")
    @EnumSource(value = PositionsToMoveBackwardInTheLimit.class)
    void appear_in_the_other_side_when_move_backward_in_the_limit(PositionsToMoveBackwardInTheLimit positionsToMoveBackwardInTheLimit) {
        Rover rover = new RoverBuilder()
                .withPosition(positionsToMoveBackwardInTheLimit.initialPosition)
                .withDirection(positionsToMoveBackwardInTheLimit.direction)
                .withTerritory(new Territory(3,3))
                .build();

        rover.moveBackward();

        assertThat(rover).isEqualTo(
                new RoverBuilder()
                        .withPosition(positionsToMoveBackwardInTheLimit.expectedPosition)
                        .withDirection(positionsToMoveBackwardInTheLimit.direction)
                        .withTerritory(new Territory(3,3))
                        .build()
        );
    }
}
