package parametrizedEnums;

import mars_rover.direction.*;
import mars_rover.position.Position;

public enum PositionsToMoveForwardInTheLimit {
    TOP(new Position(1, 2), new North(), new Position(1,0)),
    BOTTOM(new Position(1, 0), new South(), new Position(1,2)),
    RIGHT(new Position(2, 1), new East(), new Position(0,1)),
    LEFT(new Position(0, 1), new West(), new Position(2,1));

    public final Position initialPosition;
    public final Direction direction;
    public final Position expectedPosition;

    PositionsToMoveForwardInTheLimit(Position initialPosition, Direction direction, Position expectedPosition) {
        this.initialPosition = initialPosition;
        this.direction = direction;
        this.expectedPosition = expectedPosition;
    }

}
