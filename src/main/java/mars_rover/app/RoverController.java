package mars_rover.app;

import jakarta.validation.Valid;
import mars_rover.app.dto.CommandsRequest;
import mars_rover.app.dto.RoverResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rover")
public class RoverController {
    private final RoverService service;

    public RoverController(RoverService service) {
        this.service = service;
    }

    @PostMapping("/commands")
    public ResponseEntity<RoverResponse> executeCommands(@Valid @RequestBody CommandsRequest request) {
        return ResponseEntity.ok(service.execute(request));
    }
}
