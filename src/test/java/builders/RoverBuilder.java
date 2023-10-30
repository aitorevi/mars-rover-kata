package builders;

import mars_rover.Territory;
import mars_rover.direction.Direction;
import mars_rover.direction.North;
import mars_rover.position.Position;
import mars_rover.Rover;

public class RoverBuilder {
    private Position position = new Position(1,1);
    private Direction direction = new North();
    private final Territory territory = new Territory(5, 5);

    public RoverBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public RoverBuilder withDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public Rover build() {
        return new Rover(position, direction, territory);
    }
}
