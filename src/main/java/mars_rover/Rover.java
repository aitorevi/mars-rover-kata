package mars_rover;

import mars_rover.command.Command;
import mars_rover.direction.Direction;
import mars_rover.move.MoveBackward;
import mars_rover.move.MoveForward;
import mars_rover.position.Position;

import java.util.List;
import java.util.Objects;

public class Rover {
    private Position position;
    private Direction direction;
    private Territory territory;
    private Driver driver;

    public Rover(Position position, Direction direction, Territory territory) {
        this.position = position;
        this.direction = direction;
        this.territory = territory;
    }

    public Rover(Driver driver) {
        this.driver = driver;
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

    public void moveBackward() {
        position = new MoveBackward(direction, territory).execute(position);
    }

    public Rover followThis(List<Command> commands) {
        return followThis2(commands);
    }

    public Rover followThis2(List<Command> commands) {
        for (Command command: commands) {
            executeCommand2(command);
        }
        return new Rover(this.driver);
    }

    private void executeCommand(Command command) {
        switch (command) {
            case FORWARD -> this.moveForward();
            case BACKWARD -> this.moveBackward();
            case TURN_LEFT -> this.turnLeft();
            case TURN_RIGHT -> this.turnRight();
        }
    }

    private void executeCommand2(Command command) {
        switch (command) {
            case FORWARD -> this.driver.moveForward();
            case BACKWARD -> this.driver.moveBackward();
            case TURN_LEFT -> this.driver.turnLeft();
            case TURN_RIGHT -> this.driver.turnRight();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(position, rover.position) && Objects.equals(direction, rover.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }
}
