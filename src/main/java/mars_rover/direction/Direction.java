package mars_rover.direction;

public sealed interface Direction permits East, North, South, West {
    Direction turnLeft();

    Direction turnRight();
}
