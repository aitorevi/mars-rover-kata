package parametrizedEnums;

import mars_rover.direction.*;
import mars_rover.position.Position;

public enum PositionsToMoveBackwardTwice {
    NORTH(new North(), new Position(0, -2)),
    SOUTH(new South(), new Position(0,2)),
    EAST(new East(), new Position(-2,0)),
    WEST(new West(), new Position(2,0));
    public final Direction direction;
    public final Position expected;

    PositionsToMoveBackwardTwice(Direction direction, Position expected) {
        this.expected = expected;
        this.direction = direction;
    }
}
