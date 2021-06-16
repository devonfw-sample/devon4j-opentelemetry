# devon4j-sample-otelcollector
This is a sample devon4j project which spins up the OpenTelemetry Collector with Jaegar, Zipkin, Prometheus. This can be used to receive the traces/spans from projects which implement OpenTelemetry agents.

Note:-
1) Apart from creating a OpenTelemetry collector this is also a sample devon4j project which has open telemetry agent that exports traces/spans to the opentelemetry collector.
2) The devon4j SpringBootApp can be booted by passing the below JVM arguments.
-javaagent:agent/opentelemetry-javaagent-all.jar -Dotel.traces.exporter=otlp -Dotel.exporter.otlp.endpoint=http://localhost:4317 -Dotel.resource.attributes=service.name=mtsj -Dotel.javaagent.debug=false -Dotel.metrics.exporter=none
3) After booting the application - this URL can be hit from a postman client to generate traffic - http://localhost:%app-port%/services/rest/employeemanagement/v1/employee/1234

**Open Telemetry Collector**
The collector can be spinned up by using 'docker-compose up' command. And can be accessible at http://localhost:4317
Jaegar endpoint http://localhost:16686/
Zipkin endpoint http://localhost:9411/
Prometheus endpoint http://localhost:9090/

## MyThaiStar OpenTelemetry 

The backend of MyThaiStar a devon reference application can be booted to send the trace information to the OpenTelemetry Collector.

1. Download the latest OpenTelemetry JavaAgent JAR file from OpenTelemetry github pages and place it in core/agent folder under MyThaiStar parent directory.

2. Boot the SpringBootApp by passing the below JVM arguments.
-javaagent:agent/opentelemetry-javaagent-all.jar -Dotel.traces.exporter=otlp -Dotel.exporter.otlp.endpoint=http://localhost:4317 -Dotel.resource.attributes=service.name=mtsj -Dotel.javaagent.debug=false -Dotel.metrics.exporter=none

![image](https://user-images.githubusercontent.com/63033584/122231142-dca4a400-ced7-11eb-875e-0a61dcddb030.png)

3. From any rest client or a postman we can hit the http://localhost:8081/mythaistar/services/rest/dishmanagement/v1/dish/search to generate traffic.

4. Then Jaegar and Zipkin endpoint can be accessed to visualize the trace information from MyThaiStar application.
