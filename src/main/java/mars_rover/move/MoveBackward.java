package mars_rover.move;

import mars_rover.Territory;
import mars_rover.position.Position;
import mars_rover.direction.*;

public record MoveBackward(Direction direction, Territory territory) implements Move {

    @Override
    public Position execute(Position position) {
        return switch (direction) {
            case North n -> territory.backwardNorth(position, this);
            case West w -> territory.backwardWest(position, this);
            case South s -> territory.backwardSouth(position, this);
            case East e -> territory.backwardEast(position, this);
        };
    }

}
