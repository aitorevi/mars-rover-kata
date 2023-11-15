package mars_rover;

import mars_rover.direction.Direction;
import mars_rover.position.Position;

public class Driver {
    private Position position;
    private Direction direction;

    public Driver(Position position, Direction direction) {

        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
