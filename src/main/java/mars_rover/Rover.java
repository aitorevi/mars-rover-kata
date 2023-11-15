package mars_rover;

import mars_rover.command.Command;

import java.util.List;
import java.util.Objects;

public class Rover {
    private final Driver driver;

    public Rover(Driver driver) {
        this.driver = driver;
    }

    public Rover followThis(List<Command> commands) {
        for (Command command: commands) {
            executeCommand(command);
        }
        return new Rover(this.driver);
    }

    private void executeCommand(Command command) {
        switch (command) {
            case FORWARD -> this.driver.moveForward();
            case BACKWARD -> this.driver.moveBackward();
            case TURN_LEFT -> this.driver.turnLeft();
            case TURN_RIGHT -> this.driver.turnRight();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(driver, rover.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "driver=" + driver +
                '}';
    }
}
