import builders.DriverBuilder;
import builders.RoverBuilder;
import builders.TerritoryBuilder;
import mars_rover.Driver;
import mars_rover.Rover;
import mars_rover.Territory;
import mars_rover.command.Command;
import mars_rover.direction.North;
import mars_rover.direction.South;
import mars_rover.position.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static mars_rover.command.Command.*;
import static roverAssertions.RoverAssert.assertThat;

public class RoverShould {
    @Test
    void follow_a_series_of_commands() {
        List<Command> commands = List.of(FORWARD, TURN_LEFT, BACKWARD, TURN_RIGHT, BACKWARD, TURN_RIGHT, TURN_RIGHT);

        Rover roverAfterCommands = new RoverBuilder().build().followThis(commands);
        Driver expectedDriver = new DriverBuilder()
                .withDirection(new South())
                .withPosition(new Position(2,1))
                .build();

        assertThat(roverAfterCommands).isEqualTo(new RoverBuilder().withDriver(expectedDriver).build());
    }

    @Test
    void stop_before_the_obstacle_and_report_it() {
        Position obstacle = new Position(1, 3);
        Territory territory = new TerritoryBuilder()
                .withXLimit(5)
                .withYLimit(5)
                .withObstacles(List.of(obstacle))
                .build();
        Driver driver = new DriverBuilder()
                .withPosition(new Position(1, 1))
                .withDirection(new North())
                .withTerritory(territory)
                .build();
        Rover rover = new RoverBuilder().withDriver(driver).build();

        Rover finalRover = rover.followThis(List.of(FORWARD, FORWARD, FORWARD, TURN_RIGHT));

        org.assertj.core.api.Assertions.assertThat(finalRover.driver().getPosition()).isEqualTo(new Position(1, 2));
        org.assertj.core.api.Assertions.assertThat(finalRover.driver().getDirection()).isInstanceOf(North.class);
        org.assertj.core.api.Assertions.assertThat(finalRover.obstacleHit()).contains(obstacle);
    }
}