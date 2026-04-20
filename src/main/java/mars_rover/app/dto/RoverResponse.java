package mars_rover.app.dto;

public record RoverResponse(
        PositionDto position,
        String direction,
        String status,
        PositionDto obstacleHit
) {}
