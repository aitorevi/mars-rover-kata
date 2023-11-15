import builders.RoverBuilder;
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

        assertThat(roverAfterCommands).isEqualTo(
                new RoverBuilder()
                .withDirection(new South())
                .withPosition(new Position(2,1))
                .build());
    }

    @Test
    void follow_a_series_of_commands2() {
        List<Command> commands = List.of(FORWARD, TURN_LEFT, BACKWARD, TURN_RIGHT, BACKWARD, TURN_RIGHT, TURN_RIGHT);

        Rover roverAfterCommands = new RoverBuilder().build2().followThis2(commands);

        assertThat(roverAfterCommands).isEqualTo(
                new RoverBuilder()
                        .build2());
    }
}