package mars_rover;

import mars_rover.direction.Direction;
import mars_rover.position.Position;

import java.util.Objects;

public class Driver {
    private Position position;
    private Direction direction;

    public Driver(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(position, driver.position) && Objects.equals(direction, driver.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
