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

    public Rover(Position position, Direction direction, Territory territory) {
        this.position = position;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void moveForward() {
        position = new MoveForward(direction).execute(position);
    }

    public void moveBackward() {
        position = new MoveBackward(direction).execute(position);
    }

    public Rover followThis(List<Command> commands) {
        for (Command command: commands) {
            executeCommand(command);
        }
        return new Rover(this.position,this.direction, new Territory(3, 3));
    }

    private void executeCommand(Command command) {
        switch (command) {
            case FORWARD -> this.moveForward();
            case BACKWARD -> this.moveBackward();
            case TURN_LEFT -> this.turnLeft();
            case TURN_RIGHT -> this.turnRight();
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
}
