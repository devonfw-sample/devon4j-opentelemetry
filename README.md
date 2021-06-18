# devon4j-opentelemetry

## What is OpenTelemetry
It is an observability framework for distributed systems which helps to monitor your microservices, REST APIs.
It is a collection of tools, APIs, and SDKs. You can use it to instrument, generate, collect, and export telemetry data (metrics, logs, and traces) for analysis in order to understand your software's performance and behavior.

### Open Telemetry Collector
This is a sample devon4j project which spins up the OpenTelemetry Collector with telemetry backends such as Jaegar, Zipkin & Prometheus. This can be used to receive the traces/spans from applications through OpenTelemetry agents. The below image represents the functionality of OpenTelemetry with only a few telemetry backends though OpenTelemetry supports many other. The Collector collects the telemetry data and exports it to various backends. 

![opentel (1)](https://user-images.githubusercontent.com/63033584/122399442-6ddb4f80-cf98-11eb-8029-a011de5b8870.png)


The collector can be spinned up by using a simple command from the parent directory once you clone this repository. 
```
docker-compose up
```
And can be accessible at http://localhost:4317

Jaegar endpoint http://localhost:16686/

Zipkin endpoint http://localhost:9411/

Prometheus endpoint http://localhost:9090/


## devon4j OpenTelemetry Integration

Apart from creating a OpenTelemetry collector this is also a sample devon4j project which has open telemetry agent that exports traces/spans to the opentelemetry collector.

To integrate OpenTelemetry with devon4j/any Spring Boot application we have 2 different ways
1) Auto Instrumentation
2) Manual Instrumentation

This sample covers only Auto Instrumentation.

### Auto Instrumentation
This is rather straight forward and faster approach to integrate any SpringBoot application with OpenTelemetry.

Below are the steps:-

1) Download the latest OpenTelemetry JavaAgent JAR file from [*here*](https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent-all.jar)
2) The devon4j SpringBootApp can be booted by passing the below JVM arguments.
```
-javaagent:agent/opentelemetry-javaagent-all.jar -Dotel.traces.exporter=otlp -Dotel.exporter.otlp.endpoint=http://localhost:4317 -Dotel.resource.attributes=service.name=mtsj -Dotel.javaagent.debug=false -Dotel.metrics.exporter=none
```
3) After booting the application for this sample - this URL can be hit from a postman client to generate traffic - http://localhost:%app-port%/services/rest/employeemanagement/v1/employee/1234
4) The trace information can be visualized in the Jaegar, Zipkin or any other telemetry backends using the above endpoints provided. Currently this sample is integrated with Jaegar and Zipkin. 

## MyThaiStar OpenTelemetry Integration
The backend of MyThaiStar a devon reference application can be booted to send the trace information to the OpenTelemetry Collector.

Follow the below steps:
1) Download the latest OpenTelemetry JavaAgent JAR file from [*here*](https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent-all.jar)
2. Boot the SpringBootApp by passing the below JVM arguments.
```
-javaagent:agent/opentelemetry-javaagent-all.jar -Dotel.traces.exporter=otlp -Dotel.exporter.otlp.endpoint=http://localhost:4317 -Dotel.resource.attributes=service.name=mtsj -Dotel.javaagent.debug=false -Dotel.metrics.exporter=none
```

![image](https://user-images.githubusercontent.com/63033584/122231142-dca4a400-ced7-11eb-875e-0a61dcddb030.png)

3. From any rest client or a postman we can hit the http://localhost:8081/mythaistar/services/rest/dishmanagement/v1/dish/search to generate traffic.

Sample JSON request: 
```
{
    "categories": [],
    "searchBy": "",
    "pageable": {
        "pageSize": 8,
        "pageNumber": 0,
        "sort": [
            {
                "property": "price",
                "direction": "DESC"
            }
        ]
    },
    "maxPrice": null,
    "minLikes": null
}
```
Note:- You might have to provide the login while testing this in local due to SpringSecurity login configuration in MyThaiStar.

4. Then Jaegar and Zipkin endpoint can be accessed to visualize the trace information from MyThaiStar application.
### Zipkin endpoint http://localhost:9411/

![image](https://user-images.githubusercontent.com/63033584/122234808-cc41f880-ceda-11eb-8813-d440ad6431bb.png)


### Jaegar endpoint http://localhost:16686/

![image](https://user-images.githubusercontent.com/63033584/122234896-de239b80-ceda-11eb-88dc-132443a40118.png)

### Drill down one more level

![image](https://user-images.githubusercontent.com/63033584/122236462-28594c80-cedc-11eb-898a-0bd46be0b7bd.png)


This sample will continue to evolve as we investigate different ways to improve of using OpenTelemetry and implement the same.


_Relevant components:_

[*OpenTelemetry Collector*](https://github.com/open-telemetry/opentelemetry-collector)
(https://www.jaegertracing.io/)[*Jaeger*]
* _https://zipkin.io/[*Zipkin*]_
* _https://github.com/VictoriaMetrics/VictoriaMetrics[*VictoriaMetrics*]_
* _https://grafana.com/[*Grafana*]_



