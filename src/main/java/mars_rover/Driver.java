package mars_rover;

import mars_rover.direction.Direction;
import mars_rover.move.MoveForward;
import mars_rover.position.Position;

import java.util.Objects;

public class Driver {
    private Position position;
    private Direction direction;
    private Territory territory;

    public Driver(Position position, Direction direction, Territory territory) {
        this.position = position;
        this.direction = direction;
        this.territory = territory;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void moveForward() {
        position = new MoveForward(direction, territory).execute(position);
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
        return Objects.equals(position, driver.position) && Objects.equals(direction, driver.direction) && Objects.equals(territory, driver.territory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction, territory);
    }
}
