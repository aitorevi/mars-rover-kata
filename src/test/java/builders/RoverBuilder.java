package builders;

import mars_rover.Driver;
import mars_rover.Territory;
import mars_rover.direction.Direction;
import mars_rover.direction.North;
import mars_rover.position.Position;
import mars_rover.Rover;

public class RoverBuilder {
    private Position position = new Position(1,1);
    private Direction direction = new North();
    private Territory territory = new Territory(5, 5);
    private Driver driver = new Driver(position, direction, territory);

    public RoverBuilder withDriver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public Rover build() {
        return new Rover(driver);
    }
}
