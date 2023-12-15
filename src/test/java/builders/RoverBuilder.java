package builders;

import mars_rover.Driver;
import mars_rover.PathFinder;
import mars_rover.Territory;
import mars_rover.direction.Direction;
import mars_rover.direction.North;
import mars_rover.position.Position;
import mars_rover.Rover;

import java.awt.*;
import java.util.Collections;

import static java.util.Collections.emptyList;

public class RoverBuilder {
    private final Position position = new Position(1,1);
    private final Direction direction = new North();
    private final Territory territory = new Territory(5, 5, emptyList());
    private Driver driver = new Driver(position, direction, new PathFinder(territory));

    public RoverBuilder withDriver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public Rover build() {
        return new Rover(driver);
    }
}
