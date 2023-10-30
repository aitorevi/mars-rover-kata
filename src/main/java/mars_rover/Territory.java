package mars_rover;

public record Territory(int xLimit, int yLimit) {
    public int topLimit() {
        return yLimit - 1;
    }
}
