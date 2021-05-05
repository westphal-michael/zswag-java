# zswag-java
Access & serve zserio services via REST/OpenAPI using **Java** with SpringBoot technology stack.
<br><br>

## Prerequisites
   1. JDK 11+
   2. Maven 3.6
<br><br>

## Usage

### Build Calculator example
```bash
mvn clean package
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
