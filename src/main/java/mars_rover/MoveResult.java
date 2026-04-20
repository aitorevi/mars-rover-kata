package mars_rover;

import mars_rover.position.Position;

public sealed interface MoveResult permits MoveResult.Moved, MoveResult.Blocked {
    record Moved(Position position) implements MoveResult {}
    record Blocked(Position obstacle) implements MoveResult {}
}
