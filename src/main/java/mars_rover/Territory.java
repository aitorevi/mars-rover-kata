package mars_rover;

import mars_rover.exception.IlegalDimensionSizeException;
import mars_rover.move.MoveBackward;
import mars_rover.position.Position;

public record Territory(int xLimit, int yLimit) {
    public Territory {
        if (xLimit < 1 || yLimit < 1) {
            throw new IlegalDimensionSizeException("The dimension must be greater than 0");
        }
    }
    public int topLimit() {
        return yLimit - 1;
    }

    public int bottomLimit() {
        return 0 ;
    }

    public int leftLimit() {
        return 0;
    }

    public int rightLimit() {
        return xLimit -1;
    }

    public Position forwardEast(Position position) {
        final boolean isInTheRightLimit = rightLimit() == position.x();
        return isInTheRightLimit ? new Position(leftLimit(), position.y()) : position.incrementX();
    }

    public Position forwardWest(Position position) {
        final boolean isInTheLeftLimit = leftLimit() == position.x();
        return isInTheLeftLimit ? new Position(rightLimit(), position.y()) : position.decrementX();
    }

    public Position forwardSouth(Position position) {
        final boolean isInTheBottomLimit = bottomLimit() == position.y();
        return isInTheBottomLimit ? new Position(position.x(), topLimit()) : position.decrementY();
    }

    public Position forwardNorth(Position position) {
        final boolean isInTheTopLimit = topLimit() == position.y();
        return isInTheTopLimit ? new Position(position.x(), bottomLimit()) : position.incrementY();
    }

    public Position backwardEast(Position position, MoveBackward moveBackward) {
        boolean isInTheLeftLimit = position.x() == leftLimit();
        return isInTheLeftLimit ? new Position(rightLimit(), position.y()) : position.decrementX();
    }

    public Position backwardWest(Position position, MoveBackward moveBackward) {
        final boolean isInTheRightLimit = position.x() == rightLimit();
        return isInTheRightLimit ? new Position(leftLimit(), position.y()) : position.incrementX();
    }

    public Position backwardNorth(Position position, MoveBackward moveBackward) {
        final boolean isInTheBottomLimit = position.y() == bottomLimit();
        return isInTheBottomLimit ? new Position(position.x(), topLimit()) : position.decrementY();
    }

    public Position backwardSouth(Position position, MoveBackward moveBackward) {
        final boolean isInTheTopLimit = position.y() == topLimit();
        return isInTheTopLimit ? new Position(position.x(), bottomLimit()) : position.incrementY();
    }
}
