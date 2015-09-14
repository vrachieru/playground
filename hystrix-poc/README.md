# About

[Hystrix](https://github.com/Netflix/Hystrix) is a latency and fault tolerance library designed to isolate points of access to remote systems, services and 3rd party libraries, stop cascading failure and enable resilience in complex distributed systems where failure is inevitable.

This project is a simple Proof Of Concept displaying the library's basic functionalities.


# Usage

## POC Application

1. Clone the repository to a location of your choosing and navigate to said location.
2. Execute `mvn spring-boot:run` to build the project and start the embedded server.
3. Open a new tab in your browser pointing at one of the app's REST endpoints `http://localhost:8080/${restEndpoint}`.

| Endpoint | Parameters | Fails on
| -------- | ---------- | --------
| /hello   | name       | Timeout (>5000ms)

## Hystrix Dashboard

1. Clone the [Hystrix repository](https://github.com/Netflix/Hystrix) to a location of your choosing and navigate to said location.
2. Navigate to the hystrix-dashboard module inside the project.
3. Execute `../gradlew jettyRun` to build the project and start the embedded server.
4. Open a new tab in your browser at `http://localhost:7979/hystrix-dashboard`.
5. Enter the POC stream url `http://localhost:8080/hystrix.stream` and click `Monitor stream`.
