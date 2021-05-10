# zswag-java
Access & serve zserio services via REST/OpenAPI using **Java** with SpringBoot technology stack.
<br><br>

## Prerequisites
   1. JDK 11+
   2. Maven 3.6
<br><br>

## Usage

### Build zserio calculator example (including OpenAPI file generation)
```bash
mvn clean verify
```

### Generated OpenAPI file during builds
```bash
.../zswag-java/openapi-client/generated-openapi/openapi.yaml
```

### Generated OpenAPI client sources during builds
```bash
.../zswag-java/openapi-client/generated-client
```

### Start REST server
```bash
java -jar server/target/server-0.0.1-SNAPSHOT.jar
# press Ctrl+C to quit the server
```

### Start the client console example
```bash
java -jar client/target/client-0.0.1-SNAPSHOT.jar
```

### Start the OpenApi client console example
```bash
java -jar openapi-client/target/openapi-client-0.0.1-SNAPSHOT.jar
```

### URL for OpenAPI Swagger UI
```bash
http://localhost:5000/swagger-ui
```

### URL for OpenAPI docs (JSON format)
```bash
http://localhost:5000/api
```

### Download URL for OpenAPI docs in YAML format
```bash
http://localhost:5000/api.yaml
```
