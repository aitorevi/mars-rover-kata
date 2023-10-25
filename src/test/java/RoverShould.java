import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverShould {
    @Test
    void start_with_and_initial_position_facing_initial_direction () {

        Rover rover = new Rover(new Position(0,0), new North());

        assertThat(rover.getPosition()).isEqualTo(new Position(0,0));
        assertThat(rover.getDirection()).isEqualTo(new North());
    }
}


/*
TPP

*/