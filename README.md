# devon4j-sample-otelcollector
This is a sample devon4j project which spins up the OpenTelemetry Collector with Jaegar, Zipkin, Prometheus. This can be used to receive the traces/spans from projects which implement OpenTelemetry agents.

Note:-
1) Apart from creating a OpenTelemetry collector this is also a sample devon4j project which has open telemetry agent that exports traces/spans to the opentelemetry collector.
2) The devon4j SpringBootApp can be booted by passing the below JVM arguments.
-javaagent:agent/opentelemetry-javaagent-all.jar -Dotel.traces.exporter=otlp -Dotel.exporter.otlp.endpoint=http://localhost:4317 -Dotel.resource.attributes=service.name=mtsj -Dotel.javaagent.debug=false -Dotel.metrics.exporter=none

**Open Telemetry Collector**
The collector can be spinned up by using 'docker-compose up' command. And can be accessible at http://localhost:4317
Jaegar endpoint http://localhost:16686/
Zipkin endpoint http://localhost:9411/
Prometheus endpoint http://localhost:9090/
