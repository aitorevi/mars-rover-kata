package mars_rover;

public sealed interface Move permits MoveForward {
    Position execute(Position direction);
}
