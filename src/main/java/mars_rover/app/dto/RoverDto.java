package mars_rover.app.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record RoverDto(
        @Valid @NotNull PositionDto position,
        @NotNull String direction
) {}
