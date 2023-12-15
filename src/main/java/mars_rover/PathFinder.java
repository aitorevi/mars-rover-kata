package mars_rover;

import mars_rover.direction.Direction;
import mars_rover.direction.North;
import mars_rover.direction.South;
import mars_rover.direction.West;
import mars_rover.direction.East;
import mars_rover.position.Position;

public record PathFinder(Territory territory) {
    public Position moveForward(Position position, Direction direction) {
        return switch (direction) {
            case North ignored -> forwardNorth(position);
            case West ignored -> forwardWest(position);
            case South ignored -> forwardSouth(position);
            case East ignored -> forwardEast(position);
        };
    }

    public Position moveBackward(Position position, Direction direction) {
        return switch (direction) {
            case North ignored -> backwardNorth(position);
            case West ignored -> backwardWest(position);
            case South ignored -> backwardSouth(position);
            case East ignored -> backwardEast(position);
        };
    }

    private Position forwardEast(Position position) {
        final boolean isInTheRightLimit = territory.isInTheRightLimit(position);
        return isInTheRightLimit ? new Position(territory.leftLimit(), position.y()) : position.incrementX();
    }

    private Position forwardWest(Position position) {
        final boolean isInTheLeftLimit = territory.isInTheLeftLimit(position);
        return isInTheLeftLimit ? new Position(territory.rightLimit(), position.y()) : position.decrementX();
    }

    private Position forwardSouth(Position position) {
        final boolean isInTheBottomLimit = territory.isInTheBottomLimit(position);
        return isInTheBottomLimit ? new Position(position.x(), territory.topLimit()) : position.decrementY();
    }

    private Position forwardNorth(Position position) {
        final boolean isInTheTopLimit = territory.isInTheTopLimit(position);
        return isInTheTopLimit ? new Position(position.x(), territory.bottomLimit()) : position.incrementY();
    }

    private Position backwardEast(Position position) {
        boolean isInTheLeftLimit = territory.isInTheLeftLimit(position);
        return isInTheLeftLimit ? new Position(territory.rightLimit(), position.y()) : position.decrementX();
    }

    private Position backwardWest(Position position) {
        final boolean isInTheRightLimit = territory.isInTheRightLimit(position);
        return isInTheRightLimit ? new Position(territory.leftLimit(), position.y()) : position.incrementX();
    }

    private Position backwardNorth(Position position) {
        final boolean isInTheBottomLimit = territory.isInTheBottomLimit(position);
        return isInTheBottomLimit ? new Position(position.x(), territory.topLimit()) : position.decrementY();
    }

    private Position backwardSouth(Position position) {
        final boolean isInTheTopLimit = territory.isInTheTopLimit(position);
        return isInTheTopLimit ? new Position(position.x(), territory.bottomLimit()) : position.incrementY();
    }
}