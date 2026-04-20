package mars_rover.app.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CommandsRequest(
        @Valid @NotNull TerritoryDto territory,
        @Valid @NotNull RoverDto rover,
        @NotNull List<String> commands
) {}
