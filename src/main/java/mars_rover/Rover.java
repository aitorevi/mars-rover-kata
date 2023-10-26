package mars_rover;

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
        position = switch (direction) {
            case North n -> position.incrementY();
            case West w -> position.decrementX();
            case South s -> position.decrementY();
            case East e -> position.incrementX();
        };
    }

    public void moveBackward() {
        position = switch (direction) {
            case North n -> position.decrementY();
            case West w -> position.incrementX();
            case South s -> position.incrementY();
            case East e -> position.decrementX();
        };
    }
}
