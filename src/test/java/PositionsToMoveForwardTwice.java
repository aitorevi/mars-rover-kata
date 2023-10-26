import mars_rover.*;

public enum PositionsToMoveForwardTwice {
    NORTH(new North(), new Position(0, 2)),
    SOUTH(new South(), new Position(0,-2)),
    EAST(new East(), new Position(2,0)),
    WEST(new West(), new Position(-2,0));

    public final Direction direction;
    public final Position expected;

    PositionsToMoveForwardTwice(Direction direction, Position expected) {
        this.direction = direction;
        this.expected = expected;
    }
}
