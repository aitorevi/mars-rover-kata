package mars_rover;

public record MoveForward(Direction direction) implements Move {
    public Position execute(Position position) {
        return switch (direction) {
            case North n -> position.incrementY();
            case West w -> position.decrementX();
            case South s -> position.decrementY();
            case East e -> position.incrementX();
        };
    }
}
