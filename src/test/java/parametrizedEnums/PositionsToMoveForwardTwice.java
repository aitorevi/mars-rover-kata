package parametrizedEnums;

import mars_rover.direction.*;
import mars_rover.position.Position;

public enum PositionsToMoveForwardTwice {
    NORTH(new North(), new Position(2, 4)),
    SOUTH(new South(), new Position(2,0)),
    EAST(new East(), new Position(4,2)),
    WEST(new West(), new Position(0,2));

    public final Direction direction;
    public final Position expected;

    PositionsToMoveForwardTwice(Direction direction, Position expected) {
        this.direction = direction;
        this.expected = expected;
    }
}
