# zswag-java
Access & serve zserio services via REST/OpenAPI using **Java** with Spring Boot technology stack.
<br><br>

## Prerequisites
   1. JDK 17+
   2. Maven 3.6
<br><br>

## Known issues
The infrastructure to build native images (executables as well as corresponding Docker images) is present but the built modules do not work at the moment.
<br><br>


## Usage

### Build zserio calculator example (including OpenAPI file generation)
#### Java
```bash
mvn install
```

or run script

```bash
build-java.sh
```

#### Docker images using Java applications
```bash
mvn -Pdocker-java spring-boot:build-image
```

or run script

```bash
build-docker-java.sh
```

#### Native image using GraalVM
```bash
mvn -Pnative verify
```
with GraalVM used as default JDK and native plugin installed

or run script

```bash
build-native.sh
```
with environment variable $GRAALVM_HOME pointing to GraalVM directory and native plugin installed

#### Docker images using native image created with GraalVM
```bash
mvn -Pdocker-native spring-boot:build-image
```

or run script

```bash
build-docker-native.sh
```

### Generated OpenAPI file during builds
```bash
.../zswag-java/server/generated-openapi/openapi.yaml
```

### Generated OpenAPI client sources during builds
```bash
.../zswag-java/openapi-client/generated-client
```

### Start REST server
#### Java (Spring Boot) application
```bash
java -jar server/targetJava/server-0.0.1-SNAPSHOT-boot.jar
# press Ctrl+C to quit the server
```

#### Docker image using Java (Spring Boot) application
Example using docker compose:

```bash
version: '3'

services:
  server:
    image: "zswag.java/server:0.0.1-SNAPSHOT"
    environment:
      - JAVA_OPTS=-Dspring.profiles.active="default"
    volumes:
      - /tmp:/tmp
      - /mnt:/mnt:ro
    ports:
      - "5000:5000"
    network_mode: bridge
    restart: always
```

Create Docker container and start it:

```bash
docker-compose up -d
```

### Start the client console example
#### Java (Spring Boot) application
```bash
java -Dspring.profiles.active="default" -jar client/targetJava/client-0.0.1-SNAPSHOT-boot.jar
```

#### Docker image using Java (Spring Boot) application
Addition to docker compose example above:

```bash
...
  client:
    image: "zswag.java/client:0.0.1-SNAPSHOT"
    depends_on:
      - "server"
    environment:
      - JAVA_OPTS=-Dspring.profiles.active="default" -Dspring.config.additional-location="file:/config/"
    volumes:
      - /tmp:/tmp
      - /mnt:/mnt:ro
      - <local file path for external config file>:/config
    network_mode: bridge
```

In the local config file named **application.yml** you have to override "localhost" with the concrete machine ip address, e.g.

```bash
feign:
    url: 192.168.168.1:5000
```

### Start the OpenApi client console example
#### Java (Spring Boot) application
```bash
java -Dspring.profiles.active="default" -jar openapi-client/targetJava/openapi-client-0.0.1-SNAPSHOT-boot.jar
```

#### Docker image using Java (Spring Boot) application
Addition to docker compose example above:

```bash
...
  client:
    image: "zswag.java/openapi-client:0.0.1-SNAPSHOT"
    depends_on:
      - "server"
    environment:
      - JAVA_OPTS=-Dspring.profiles.active="default" -Dspring.config.additional-location="file:/config/"
    volumes:
      - /tmp:/tmp
      - /mnt:/mnt:ro
      - <local file path for external config file>:/config
    network_mode: bridge
```

In the local config file named **application.yml** you have to override "localhost" with the concrete machine ip address, e.g.

```bash
feign:
    url: 192.168.168.1:5000
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
