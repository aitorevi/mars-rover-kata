package mars_rover;

import mars_rover.exception.IlegalDimensionSizeException;

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
}
