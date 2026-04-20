# Your Task
You’re part of the team that explores Mars by sending remotely controlled vehicles to the surface of the planet. Develop
an API that translates the commands sent from earth to instructions that are understood by the rover.

## Requirements
*IMPORTANT*: For this version you need Java 21
You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.

The rover receives a character array of commands.
Ej: -> [FORWARD, BACKWARD, LEFT, RIGHT]
Implement commands that move the rover forward/backward (f,b).
Implement commands that turn the rover left/right (l,r).
Implement wrapping at edges. But be careful, planets are spheres.
Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle,
the rover moves up to the last possible point, aborts the sequence and reports the obstacle.

## Rules
Hardcore TDD. No Excuses!
Change roles (driver, navigator) after each TDD cycle.
No red phases while refactoring.
Be careful about edge cases and exceptions. We can not afford to lose a mars rover, just because the developers
overlooked a null pointer.

## Obstacle detection

`PathFinder` returns a `MoveResult` sealed type — either `Moved(position)` or `Blocked(obstacle)`. The `Driver`
applies only `Moved` updates and records the hit obstacle; `Rover.followThis` aborts the command sequence the
first time the driver reports `isBlocked()` and exposes `obstacleHit()` for inspection.

## HTTP service

A Spring Boot application wraps the domain behind a single endpoint:

```
POST /api/rover/commands
Content-Type: application/json

{
  "territory": { "xLimit": 5, "yLimit": 5, "obstacles": [{"x": 1, "y": 3}] },
  "rover":     { "position": {"x": 1, "y": 1}, "direction": "NORTH" },
  "commands":  ["FORWARD", "FORWARD", "FORWARD"]
}
```

Response example (blocked case):

```json
{
  "position":    {"x": 1, "y": 2},
  "direction":   "NORTH",
  "status":      "BLOCKED",
  "obstacleHit": {"x": 1, "y": 3}
}
```

Run locally:

```bash
./gradlew bootRun
```

Run the tests:

```bash
./gradlew test
```