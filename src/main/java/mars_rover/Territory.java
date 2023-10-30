package mars_rover;

public record Territory(int xLimit, int yLimit) {
    public int topLimit() {
        return yLimit - 1;
    }

    public int bottomLimit() {
        return 0 ;
    }

    public int leftLimit() {
        return 0;
    }
}
