import mars_rover.Territory;
import mars_rover.exception.IlegalDimensionSizeException;
import org.junit.jupiter.api.Test;

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
}
