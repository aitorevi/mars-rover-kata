package parametrizedEnums;

import mars_rover.direction.*;

public enum DirectionsToLeft {
    NORTH(new North(), new West()),
    SOUTH(new South(), new East()),
    EAST(new East(), new North()),
    WEST(new West(), new South());

    public final Direction initialDirection;
    public final Direction expectedDirection;

    DirectionsToLeft(Direction initialDirection, Direction expectedDirection) {
        this.initialDirection = initialDirection;
        this.expectedDirection = expectedDirection;
    }
}
