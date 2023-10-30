package mars_rover.move;

import mars_rover.position.Position;
import mars_rover.direction.*;

public record MoveBackward(Direction direction, mars_rover.Territory territory) implements Move {

    @Override
    public Position execute(Position position) {
        return switch (direction) {
            case North n -> position.y() == territory.bottomLimit() ? new Position(position.x(), territory.topLimit()) : position.decrementY();
            case West w -> position.incrementX();
            case South s -> toSouth(position);
            case East e -> position.decrementX();
        };
    }

    private Position toSouth(Position position) {
        final boolean isInTheTopLimit = position.y() == territory.topLimit();
        return isInTheTopLimit ? new Position(position.x(), territory.bottomLimit()) : position.incrementY();
    }
}
