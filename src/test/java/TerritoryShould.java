import builders.TerritoryBuilder;
import mars_rover.Territory;
import mars_rover.exception.IlegalDimensionSizeException;
import mars_rover.position.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TerritoryShould {
    @Test
    void check_that_x_axis_be_greater_than_0 () {
        assertThatThrownBy(() -> new TerritoryBuilder().withXLimit(0).withYLimit(2).build())
            .isInstanceOf(IlegalDimensionSizeException.class)
            .hasMessageContaining("The dimension must be greater than 0");
    }
    @Test
    void check_that_y_axis_be_greater_than_0 () {
        assertThatThrownBy(() -> new TerritoryBuilder().withXLimit(2).withYLimit(0).build())
            .isInstanceOf(IlegalDimensionSizeException.class)
            .hasMessageContaining("The dimension must be greater than 0");
    }

    @Test
    void check_that_have_an_obstacle_in_a_certain_position () {
        Territory territory = new TerritoryBuilder()
                .withXLimit(2)
                .withYLimit(2)
                .withObstacles(List.of(new Position(1, 1)))
                .build();
        assertThat(territory.hasObstacleIn(new Position(1, 1))).isTrue();
    }
    @Test
    void check_that_not_have_an_obstacle_in_a_certain_position () {
        Territory territory = new TerritoryBuilder()
                .withXLimit(2)
                .withYLimit(2)
                .withObstacles(List.of(new Position(1, 1)))
                .build();
        assertThat(territory.hasObstacleIn(new Position(0, 2))).isFalse();
    }
}
