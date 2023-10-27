package parametrizedEnums;

import mars_rover.direction.*;
import mars_rover.position.Position;

public enum PositionsToMoveForward {
    NORTH(new North(), new Position(0,1)),
    SOUTH(new South(), new Position(0,-1)),
    EAST(new East(), new Position(1,0)),
    WEST(new West(), new Position(-1,0));
    public final Direction direction;
    public final Position expected;

    PositionsToMoveForward(Direction direction, Position expected) {

        this.direction = direction;
        this.expected = expected;
    }
}
