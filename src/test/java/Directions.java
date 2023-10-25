public enum Directions {
    NORTH(new North(), new West()),
    SOUTH(new South(), new East()),
    EAST(new East(), new North()),
    WEST(new West(), new South());

    public final Direction initialDirection;
    public final Direction expectedDirection;

    Directions(Direction initialDirection, Direction expectedDirection) {
        this.initialDirection = initialDirection;
        this.expectedDirection = expectedDirection;
    }
}
