package builders;

import mars_rover.Driver;
import mars_rover.direction.Direction;
import mars_rover.direction.North;
import mars_rover.position.Position;

public class DriverBuilder {
    private Position position = new Position(1,1);
    private Direction direction = new North();

    public DriverBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public DriverBuilder withDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public Driver build() {
        return new Driver(position, direction);
    }
}
