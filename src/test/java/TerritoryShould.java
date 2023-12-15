import mars_rover.Territory;
import mars_rover.exception.IlegalDimensionSizeException;
import mars_rover.position.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TerritoryShould {
    @Test
    void check_that_x_axis_be_greater_than_0 () {
        assertThatThrownBy(() -> new Territory(0, 2))
            .isInstanceOf(IlegalDimensionSizeException.class)
            .hasMessageContaining("The dimension must be greater than 0");
    }
    @Test
    void check_that_y_axis_be_greater_than_0 () {
        assertThatThrownBy(() -> new Territory(2, 0))
            .isInstanceOf(IlegalDimensionSizeException.class)
            .hasMessageContaining("The dimension must be greater than 0");
    }

    @Test
    void check_that_have_an_obstacle_in_a_certain_position () {
        Territory territory = new Territory(2, 2);
        assertThat(territory.hasObstacleIn(new Position(1, 1))).isTrue();
    }
    @Test
    void check_that_not_have_an_obstacle_in_a_certain_position () {
        Territory territory = new Territory(2, 2);
        assertThat(territory.hasObstacleIn(new Position(0, 2))).isFalse();
    }
}
