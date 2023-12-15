package mars_rover;

import mars_rover.exception.IlegalDimensionSizeException;
import mars_rover.position.Position;

import java.util.List;

public record Territory(int xLimit, int yLimit, List<Position> obstacles) {
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

    boolean isInTheRightLimit(Position position) {
        return rightLimit() == position.x();
    }

    boolean isInTheLeftLimit(Position position) {
        return leftLimit() == position.x();
    }

    boolean isInTheBottomLimit(Position position) {
        return bottomLimit() == position.y();
    }

    boolean isInTheTopLimit(Position position) {
        return topLimit() == position.y();
    }

    public boolean hasObstacleIn(Position position) {
        return obstacles.contains(position);
    }
}
