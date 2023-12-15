package builders;

import mars_rover.Territory;
import mars_rover.position.Position;

import java.util.List;

import static java.util.Collections.emptyList;

public class TerritoryBuilder {
    private int xLimit = 3;
    private int yLimit = 3;
    private List<Position> obstacles = emptyList();

    public TerritoryBuilder withXLimit(int xLimit) {
        this.xLimit = xLimit;
        return this;
    }
    public TerritoryBuilder withYLimit(int yLimit) {
        this.yLimit = yLimit;
        return this;
    }
    public TerritoryBuilder withObstacles(List<Position> obstacles) {
        this.obstacles = obstacles;
        return this;
    }
    public Territory build() {
        return new Territory(xLimit, yLimit, obstacles);
    }
}
