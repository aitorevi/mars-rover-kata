package mars_rover;

import mars_rover.direction.Direction;
import mars_rover.position.Position;

import java.util.Objects;

public class Driver {
    private Position position;
    private Direction direction;
    private final Gps gps;

    public Driver(Position position, Direction direction, Gps gps) {
        this.position = position;
        this.direction = direction;
        this.gps = gps;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void moveForward() {
        position = gps.moveForward(position, direction);
    }

    public void moveBackward() {
        position = gps.moveBackward(position, direction);
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
               Objects.equals(gps, driver.gps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction, gps);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "position=" + position +
                ", direction=" + direction +
                ", gps=" + gps +
                '}';
    }
}
