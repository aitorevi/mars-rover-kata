package mars_rover.position;

// TODO: Change all method naming if we think a better option
public record Position(int x, int y) {
    public Position incrementY() {
        return new Position(x, y+1);
    }

    public Position decrementY() {
        return new Position(x, y-1);
    }

    public Position incrementX() {
        return new Position(x+1, y);
    }

    public Position decrementX() {
        return new Position(x-1,y);
    }
}
