package parametrizedEnums;

import mars_rover.direction.*;

public enum DirectionsToRight {
    NORTH(new North(), new East()),
    SOUTH(new South(), new West()),
    EAST(new East(), new South()),
    WEST(new West(), new North());

    public final Direction initialDirection;
    public final Direction expectedDirection;

    DirectionsToRight(Direction initialDirection, Direction expectedDirection) {
        this.initialDirection = initialDirection;
        this.expectedDirection = expectedDirection;
    }
}
