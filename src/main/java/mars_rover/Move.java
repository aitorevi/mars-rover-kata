package mars_rover;

public sealed interface Move permits MoveBackward, MoveForward {
    Position execute(Position position);

}
