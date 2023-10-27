package mars_rover;

import java.util.List;

public class Rover {

    private Position position;
    private Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    // TODO: Use State Pattern with Move
    public void moveForward() {
        position = new MoveForward(direction).execute(position);
    }

    public void moveBackward() {
        if(direction instanceof North) {
            position = position.decrementY();
        } else if (direction instanceof West) {
            position = position.incrementX();
        } else if (direction instanceof South) {
            position = position.incrementY();
        }  else if (direction instanceof East) {
            position = position.decrementX();
        }
    }

    public Rover followThis(List<Command> commands) {
        for (Command command: commands) {
            executeCommand(command);
        }
        return new Rover(this.position,this.direction);
    }

    private void executeCommand(Command command) {
        switch (command) {
            case FORWARD -> this.moveForward();
            case BACKWARD -> this.moveBackward();
            case TURN_LEFT -> this.turnLeft();
            case TURN_RIGHT -> this.turnRight();
        }
    }
}
