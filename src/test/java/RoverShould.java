import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(rover.getPosition()).isEqualTo(initialPosition);
        assertThat(rover.getDirection()).isEqualTo(initialDirection);
    }
    @Test
    void turn_left() {
        rover.turnLeft();
        assertThat(rover.getDirection()).isEqualTo(new West());
    }

    @Test
    void turn_left_twice() {
        rover.turnLeft();
        rover.turnLeft();
        assertThat(rover.getDirection()).isEqualTo(new South());
    }
}


/*
TPP
*/