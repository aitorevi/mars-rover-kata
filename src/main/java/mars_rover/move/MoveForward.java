package mars_rover.move;

import mars_rover.Territory;
import mars_rover.position.Position;
import mars_rover.direction.*;

public record MoveForward(Direction direction, Territory territory) implements Move {
    public Position execute(Position position) {
        return switch (direction) {
            case North n -> toNorth(position);
            case West w -> position.decrementX();
            case South s -> position.decrementY();
            case East e -> position.incrementX();
        };
    }

    private Position toNorth(Position position) {
        boolean isInTheTopLimit = territory.topLimit() == position.y();
        return isInTheTopLimit ? new Position(position.x(), 0) : position.incrementY();
    }
}
