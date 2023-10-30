package mars_rover.move;

import mars_rover.Territory;
import mars_rover.position.Position;
import mars_rover.direction.*;

public record MoveForward(Direction direction, Territory territory) implements Move {
    public Position execute(Position position) {
        return switch (direction) {
            case North n -> toNorth(position);
            case West w -> toWest(position);
            case South s -> toSouth(position);
            case East e -> position.incrementX();
        };
    }

    private Position toWest(Position position) {
        final boolean isInTheLeftLimit = territory.leftLimit() == position.x();
        return isInTheLeftLimit ? new Position(2, position.y()) : position.decrementX();
    }

    private Position toSouth(Position position) {
        final boolean isInTheBottomLimit = territory.bottomLimit() == position.y();
        return isInTheBottomLimit ? new Position(position.x(), territory.topLimit()) : position.decrementY();
    }

    private Position toNorth(Position position) {
        final boolean isInTheTopLimit = territory.topLimit() == position.y();
        return isInTheTopLimit ? new Position(position.x(), territory.bottomLimit()) : position.incrementY();
    }
}
