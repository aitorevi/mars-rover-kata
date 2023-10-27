package mars_rover;

import java.util.List;

import static mars_rover.Commands.BACKWARD;
import static mars_rover.Commands.TURN_LEFT;

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

    public void moveForward() {
        if(direction instanceof North) {
            position = position.incrementY();
        } else if (direction instanceof West) {
            position = position.decrementX();
        } else if (direction instanceof South) {
            position = position.decrementY();
        } else if (direction instanceof East) {
            position = position.incrementX();
        }
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

    public Rover followThis(List<Commands> commands) {
        if (commands.get(0) == BACKWARD) {
            this.moveBackward();
        } else if (commands.get(0) == TURN_LEFT) {
            this.turnLeft();
        } else {
            this.moveForward();
        }
        return new Rover(this.position,this.direction);
    }
}
