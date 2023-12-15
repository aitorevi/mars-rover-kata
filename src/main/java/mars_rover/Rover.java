package mars_rover;

import mars_rover.command.Command;

import java.util.List;

public record Rover(Driver driver) {
    public Rover followThis(List<Command> commands) {
        for (Command command: commands) {
            executeCommand(command);
        }
        return new Rover(driver);
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
