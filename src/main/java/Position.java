public record Position(int x, int y) {
    public Position incrementY() {
        return new Position(x, y+1);
    }
}
