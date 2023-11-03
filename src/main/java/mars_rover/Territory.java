package mars_rover;

public record Territory(int xLimit, int yLimit) {
    public Territory {
        if (xLimit < 1) {
            throw new java.lang.IllegalArgumentException("The dimension must be greater than 0");
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
