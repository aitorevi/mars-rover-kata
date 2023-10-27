package mars_rover;

public record MoveBackward(Direction direction) implements Move {

    @Override
    public Position execute(Position position) {
        return switch (direction) {
            case North n -> position.decrementY();
            case West w -> position.incrementX();
            case South s -> position.incrementY();
            case East e -> position.decrementX();
        };
    }
}
