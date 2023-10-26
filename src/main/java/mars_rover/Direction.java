package mars_rover;

public sealed interface Direction permits East, North, South, West {
    Direction turnLeft();

    Direction turnRight();
}