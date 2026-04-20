package mars_rover;

import mars_rover.command.Command;
import mars_rover.position.Position;

import java.util.List;
import java.util.Optional;

public record Rover(Driver driver) {
    public Rover followThis(List<Command> commands) {
        for (Command command: commands) {
            executeCommand(command);
            if (driver.isBlocked()) {
                break;
            }
        }
        return new Rover(driver);
    }

    public Optional<Position> obstacleHit() {
        return driver.lastObstacle();
    }

    private void executeCommand(Command command) {
        switch (command) {
            case FORWARD -> driver.moveForward();
            case BACKWARD -> driver.moveBackward();
            case TURN_LEFT -> driver.turnLeft();
            case TURN_RIGHT -> driver.turnRight();
        }
    }
}
