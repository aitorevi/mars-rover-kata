package builders;

import mars_rover.Driver;
import mars_rover.PathFinder;
import mars_rover.Territory;
import mars_rover.direction.Direction;
import mars_rover.direction.North;
import mars_rover.position.Position;

import static java.util.Collections.emptyList;

public class DriverBuilder {
    private Position position = new Position(1,1);
    private Direction direction = new North();
    private Territory territory = new Territory(5, 5, emptyList());

    public DriverBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public DriverBuilder withDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public DriverBuilder withTerritory(Territory territory) {
        this.territory = territory;
        return this;
    }

    public Driver build() {
        return new Driver(position, direction, new PathFinder(territory));
    }
}
