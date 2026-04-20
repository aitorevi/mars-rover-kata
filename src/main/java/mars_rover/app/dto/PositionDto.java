package mars_rover.app.dto;

import jakarta.validation.constraints.NotNull;

public record PositionDto(@NotNull Integer x, @NotNull Integer y) {}
