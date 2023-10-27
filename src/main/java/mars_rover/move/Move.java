package mars_rover.move;

import mars_rover.position.Position;

public sealed interface Move permits MoveBackward, MoveForward {
    Position execute(Position position);

}
