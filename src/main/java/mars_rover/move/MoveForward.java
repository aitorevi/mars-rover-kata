package mars_rover.move;

import mars_rover.Territory;
import mars_rover.position.Position;
import mars_rover.direction.*;

public record MoveForward(Direction direction, Territory territory) implements Move {
    public Position execute(Position position) {
        return switch (direction) {
            case North n -> territory.forwardNorth(position);
            case West w -> territory.forwardWest(position);
            case South s -> territory.forwardSouth(position);
            case East e -> territory.forwardEast(position);
        };
    }

}
