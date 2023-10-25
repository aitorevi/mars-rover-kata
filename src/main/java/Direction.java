public sealed interface Direction permits East, North, South, West {
    Direction turnLeft();
}
