package mars_rover.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RoverControllerShould {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void move_the_rover_when_no_obstacle_is_hit() throws Exception {
        String body = """
                {
                  "territory": {"xLimit": 5, "yLimit": 5, "obstacles": []},
                  "rover": {"position": {"x": 1, "y": 1}, "direction": "NORTH"},
                  "commands": ["FORWARD", "FORWARD", "TURN_RIGHT"]
                }
                """;

        mockMvc.perform(post("/api/rover/commands")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.position.x").value(1))
                .andExpect(jsonPath("$.position.y").value(3))
                .andExpect(jsonPath("$.direction").value("EAST"))
                .andExpect(jsonPath("$.obstacleHit").doesNotExist());
    }

    @Test
    void report_the_obstacle_when_the_rover_is_blocked() throws Exception {
        String body = """
                {
                  "territory": {"xLimit": 5, "yLimit": 5, "obstacles": [{"x": 1, "y": 3}]},
                  "rover": {"position": {"x": 1, "y": 1}, "direction": "NORTH"},
                  "commands": ["FORWARD", "FORWARD", "FORWARD"]
                }
                """;

        mockMvc.perform(post("/api/rover/commands")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("BLOCKED"))
                .andExpect(jsonPath("$.position.x").value(1))
                .andExpect(jsonPath("$.position.y").value(2))
                .andExpect(jsonPath("$.direction").value("NORTH"))
                .andExpect(jsonPath("$.obstacleHit.x").value(1))
                .andExpect(jsonPath("$.obstacleHit.y").value(3));
    }
}
