import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverShould {
    @Test
    void start_with_and_initial_position_facing_initial_direction () {
        Position initialPosition = new Position(0, 0);
        North initialDirection = new North();
        Rover rover = new Rover(initialPosition, initialDirection);

        assertThat(rover.getPosition()).isEqualTo(initialPosition);
        assertThat(rover.getDirection()).isEqualTo(initialDirection);
    }
}


/*
TPP

*/