package mars_rover;

import mars_rover.direction.Direction;
import mars_rover.position.Position;

import java.util.Objects;

public class Driver {
    private Position position;
    private Direction direction;
    private final PathFinder pathFinder;

    public Driver(Position position, Direction direction, PathFinder pathFinder) {
        this.position = position;
        this.direction = direction;
        this.pathFinder = pathFinder;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void moveForward() {
        position = pathFinder.moveForward(position, direction);
    }

    public void moveBackward() {
        position = pathFinder.moveBackward(position, direction);
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
        return Objects.equals(position, driver.position) &&
               Objects.equals(direction, driver.direction) &&
               Objects.equals(pathFinder, driver.pathFinder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction, pathFinder);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "position=" + position +
                ", direction=" + direction +
                ", gps=" + pathFinder +
                '}';
    }
}
