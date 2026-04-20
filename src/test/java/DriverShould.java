import builders.DriverBuilder;
import builders.TerritoryBuilder;
import mars_rover.Driver;
import mars_rover.Territory;
import mars_rover.direction.North;
import mars_rover.position.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import parametrizedEnums.*;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;


public class DriverShould {
    @ParameterizedTest(name = "facing in {0}")
    @EnumSource(value = DirectionsToLeft.class)
    void turn_left(DirectionsToLeft direction) {
        Driver driver = new DriverBuilder().withDirection(direction.initialDirection).build();
        driver.turnLeft();
        assertThat(driver).isEqualTo(new DriverBuilder().withDirection(direction.expectedDirection).build());
    }

    @ParameterizedTest(name = "facing in {0}")
    @EnumSource(value = DirectionsToRight.class)
    void turn_right(DirectionsToRight direction) {
        Driver driver = new DriverBuilder().withDirection(direction.initialDirection).build();
        driver.turnRight();
        assertThat(driver).isEqualTo(new DriverBuilder().withDirection(direction.expectedDirection).build());
    }

    @ParameterizedTest(name = "in {0}")
    @EnumSource(value = PositionsToMoveForward.class)
    void move_forward(PositionsToMoveForward positionToMoveForward) {
        Driver driver = new DriverBuilder().withDirection(positionToMoveForward.direction).build();
        driver.moveForward();

        assertThat(driver).isEqualTo(
                new DriverBuilder()
                        .withDirection(positionToMoveForward.direction)
                        .withPosition(positionToMoveForward.expected)
                        .build()
        );
    }

    @ParameterizedTest(name = "in {0}")
    @EnumSource(value = PositionsToMoveForwardTwice.class)
    void move_forward_twice(PositionsToMoveForwardTwice positionsToMoveForwardTwice) {
        Driver driver = new DriverBuilder()
                .withDirection(positionsToMoveForwardTwice.direction)
                .withPosition(new Position(2, 2))
                .build();
        driver.moveForward();
        driver.moveForward();

        assertThat(driver).isEqualTo(
                new DriverBuilder()
                        .withDirection(positionsToMoveForwardTwice.direction)
                        .withPosition(positionsToMoveForwardTwice.expected)
                        .build()
        );
    }

    @ParameterizedTest(name = "in {0}")
    @EnumSource(value = PositionsToMoveBackwardTwice.class)
    void move_backward_twice(PositionsToMoveBackwardTwice positionsToMoveBackwardTwice) {
        Driver driver = new DriverBuilder()
                .withDirection(positionsToMoveBackwardTwice.direction)
                .withPosition(new Position(2, 2))
                .build();
        driver.moveBackward();
        driver.moveBackward();

        assertThat(driver).isEqualTo(
                new DriverBuilder()
                        .withDirection(positionsToMoveBackwardTwice.direction)
                        .withPosition(positionsToMoveBackwardTwice.expected)
                        .build()
        );
    }

    @ParameterizedTest(name = "{0}")
    @EnumSource(value = PositionsToMoveForwardInTheLimit.class)
    void appear_in_the_other_side_when_move_forward_in_the_limit(PositionsToMoveForwardInTheLimit positionsToMoveForwardInTheLimit) {
        Driver driver = new DriverBuilder()
                .withPosition(positionsToMoveForwardInTheLimit.initialPosition)
                .withDirection(positionsToMoveForwardInTheLimit.direction)
                .withTerritory(new TerritoryBuilder().build())
                .build();

        driver.moveForward();

        assertThat(driver).isEqualTo(
                new DriverBuilder()
                        .withPosition(positionsToMoveForwardInTheLimit.expectedPosition)
                        .withDirection(positionsToMoveForwardInTheLimit.direction)
                        .withTerritory(new TerritoryBuilder().build())
                        .build()
        );
    }

    @ParameterizedTest(name = "{0}")
    @EnumSource(value = PositionsToMoveBackwardInTheLimit.class)
    void appear_in_the_other_side_when_move_backward_in_the_limit(PositionsToMoveBackwardInTheLimit positionsToMoveBackwardInTheLimit) {
        Driver driver = new DriverBuilder()
                .withPosition(positionsToMoveBackwardInTheLimit.initialPosition)
                .withDirection(positionsToMoveBackwardInTheLimit.direction)
                .withTerritory(new TerritoryBuilder().build())
                .build();

        driver.moveBackward();

        assertThat(driver).isEqualTo(
                new DriverBuilder()
                        .withPosition(positionsToMoveBackwardInTheLimit.expectedPosition)
                        .withDirection(positionsToMoveBackwardInTheLimit.direction)
                        .withTerritory(new TerritoryBuilder().build())
                        .build()
        );
    }

    @Test
    void not_move_when_an_obstacle_is_ahead() {
        Position initialPosition = new Position(1, 1);
        Territory territoryWithObstacle = new TerritoryBuilder()
                .withObstacles(List.of(new Position(1, 2)))
                .build();
        Driver driver = new DriverBuilder()
                .withPosition(initialPosition)
                .withDirection(new North())
                .withTerritory(territoryWithObstacle)
                .build();

        driver.moveForward();

        assertThat(driver.getPosition()).isEqualTo(initialPosition);
    }

    @Test
    void report_the_obstacle_position_after_being_blocked() {
        Position obstacle = new Position(1, 2);
        Territory territoryWithObstacle = new TerritoryBuilder()
                .withObstacles(List.of(obstacle))
                .build();
        Driver driver = new DriverBuilder()
                .withPosition(new Position(1, 1))
                .withDirection(new North())
                .withTerritory(territoryWithObstacle)
                .build();

        driver.moveForward();

        assertThat(driver.isBlocked()).isTrue();
        assertThat(driver.lastObstacle()).contains(obstacle);
    }

    @Test
    void continue_to_turn_after_being_blocked() {
        Territory territoryWithObstacle = new TerritoryBuilder()
                .withObstacles(List.of(new Position(1, 2)))
                .build();
        Driver driver = new DriverBuilder()
                .withPosition(new Position(1, 1))
                .withDirection(new North())
                .withTerritory(territoryWithObstacle)
                .build();

        driver.moveForward();
        driver.turnRight();

        assertThat(driver.getDirection().getClass().getSimpleName()).isEqualTo("East");
    }
}
