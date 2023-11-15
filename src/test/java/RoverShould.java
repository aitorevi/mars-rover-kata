import builders.DriverBuilder;
import builders.RoverBuilder;
import mars_rover.Driver;
import mars_rover.Rover;
import mars_rover.command.Command;
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
}