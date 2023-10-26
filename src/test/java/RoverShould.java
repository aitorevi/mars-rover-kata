import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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

    @ParameterizedTest(name="facing in {0}")
    @EnumSource(value = DirectionsToLeft.class)
    void turn_left(DirectionsToLeft direction) {
        Rover rover = new Rover(initialPosition, direction.initialDirection);
        rover.turnLeft();
        assertThat(rover.getDirection()).isEqualTo(direction.expectedDirection);
    }

    @ParameterizedTest(name="facing in {0}")
    @EnumSource(value = DirectionsToRight.class)
    void turn_right(DirectionsToRight direction) {
        Rover rover = new Rover(initialPosition, direction.initialDirection);
        rover.turnRight();
        assertThat(rover.getDirection()).isEqualTo(direction.expectedDirection);
    }

    @ParameterizedTest(name="in {0}")
    @EnumSource(value = PositionsToMoveForward.class)
    void move_forward(PositionsToMoveForward positionToMoveForward) {
        Rover rover = new Rover(initialPosition, positionToMoveForward.direction);
        rover.moveForward();

        assertThat(rover.getPosition()).isEqualTo(positionToMoveForward.expected);
    }

    @Test
    void move_forward_twice_facing_north(){
        rover.moveForward();
        rover.moveForward();

        assertThat(rover.getPosition()).isEqualTo(new Position(0,2));
    }
}
