package mars_rover.app.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TerritoryDto(
        @NotNull @Min(1) Integer xLimit,
        @NotNull @Min(1) Integer yLimit,
        @Valid List<PositionDto> obstacles
) {}
