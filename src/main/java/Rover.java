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
            position = new Position(0,1);
        } else if (direction instanceof West) {
            position = new Position(-1,0);
        } else if (direction instanceof South) {
            position = new Position(0,-1);
        } else if (direction instanceof East) {
            position = new Position(1,0);
        }
    }
}
