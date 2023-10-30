package parametrizedEnums;

import mars_rover.direction.*;
import mars_rover.position.Position;

public enum PositionsToMoveBackwardInTheLimit {
    NORTH(new Position(1, 2), new South(), new Position(1,0)),
    SOUTH(new Position(1, 0), new North(), new Position(1,2)),
    EAST(new Position(2, 1), new West(), new Position(0,1)),
    WEST(new Position(0, 1), new East(), new Position(2,1));

    public Position initialPosition;
    public Direction direction;
    public Position expectedPosition;

    PositionsToMoveBackwardInTheLimit(Position initialPosition, Direction direction, Position expectedPosition) {
        this.initialPosition = initialPosition;
        this.direction = direction;
        this.expectedPosition = expectedPosition;
    }
}
