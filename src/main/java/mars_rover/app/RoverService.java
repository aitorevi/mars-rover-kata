package mars_rover.app;

import mars_rover.Driver;
import mars_rover.PathFinder;
import mars_rover.Rover;
import mars_rover.Territory;
import mars_rover.app.dto.CommandsRequest;
import mars_rover.app.dto.PositionDto;
import mars_rover.app.dto.RoverResponse;
import mars_rover.command.Command;
import mars_rover.direction.Direction;
import mars_rover.direction.East;
import mars_rover.direction.North;
import mars_rover.direction.South;
import mars_rover.direction.West;
import mars_rover.position.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoverService {
    public RoverResponse execute(CommandsRequest request) {
        Territory territory = new Territory(
                request.territory().xLimit(),
                request.territory().yLimit(),
                toPositions(request.territory().obstacles())
        );
        Driver driver = new Driver(
                toPosition(request.rover().position()),
                toDirection(request.rover().direction()),
                new PathFinder(territory)
        );
        Rover rover = new Rover(driver).followThis(toCommands(request.commands()));

        return new RoverResponse(
                toPositionDto(driver.getPosition()),
                directionName(driver.getDirection()),
                driver.isBlocked() ? "BLOCKED" : "OK",
                rover.obstacleHit().map(RoverService::toPositionDto).orElse(null)
        );
    }

    private static List<Position> toPositions(List<PositionDto> obstacles) {
        return obstacles == null ? List.of() : obstacles.stream().map(RoverService::toPosition).toList();
    }

    private static Position toPosition(PositionDto dto) {
        return new Position(dto.x(), dto.y());
    }

    private static PositionDto toPositionDto(Position position) {
        return new PositionDto(position.x(), position.y());
    }

    private static List<Command> toCommands(List<String> commands) {
        return commands.stream().map(Command::valueOf).toList();
    }

    private static Direction toDirection(String name) {
        return switch (name.toUpperCase()) {
            case "NORTH" -> new North();
            case "SOUTH" -> new South();
            case "EAST" -> new East();
            case "WEST" -> new West();
            default -> throw new IllegalArgumentException("Unknown direction: " + name);
        };
    }

    private static String directionName(Direction direction) {
        return switch (direction) {
            case North ignored -> "NORTH";
            case South ignored -> "SOUTH";
            case East ignored -> "EAST";
            case West ignored -> "WEST";
        };
    }
}
