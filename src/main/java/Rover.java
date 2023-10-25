public class Rover {

    private Direction direction;

    public Rover(Position position, Direction direction) {
        this.direction = direction;
    }

    public Position getPosition() {
        return new Position(0,0);
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }
}
