package parametrizedEnums;

import mars_rover.direction.*;
import mars_rover.position.Position;

public enum PositionsToMoveBackwardTwice {
    NORTH(new North(), new Position(2, 0)),
    SOUTH(new South(), new Position(2,4)),
    EAST(new East(), new Position(0,2)),
    WEST(new West(), new Position(4,2));
    public final Direction direction;
    public final Position expected;

    PositionsToMoveBackwardTwice(Direction direction, Position expected) {
        this.expected = expected;
        this.direction = direction;
    }
}
