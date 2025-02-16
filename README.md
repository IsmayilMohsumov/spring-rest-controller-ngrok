# Facesdmc - Car API

This is a simple Spring Boot REST API that provides hardcoded JSON data (a list of cars). The application is containerized using Docker for easy deployment.

## Table of Contents
- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Building the Application](#building-the-application)
- [Docker Build & Run](#docker-build--run)
- [Deployment Options](#deployment-options)
- [Troubleshooting](#troubleshooting)
- [License](#license)

## Overview

This project demonstrates a basic Spring Boot REST API that provides endpoints to retrieve car data. The application is packaged as an executable JAR and containerized using Docker.

## Prerequisites

Ensure you have the following installed:
- [Java JDK 17](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)

## Building the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/facesdmc.git
   cd facesdmc
   ```

2. Build the JAR file:

   ```bash
   mvn clean package -DskipTests
   ```

   The JAR file will be generated in the `target/` directory.

## Docker Build & Run

1. **Create the Docker Image:**

   ```bash
   docker build -t car-api .
   ```

2. **Run the Docker Container:**

   ```bash
   docker run -p 8080:8080 car-api
   ```

   The API will be available at [http://localhost:8080](http://localhost:8080).

## Deployment

### Temporary Exposure with ngrok
- Run the Docker container locally.
- Start ngrok:

  ```bash
  ngrok http 8080
  ```

- ngrok generates a temporary public URL for external access.

## Troubleshooting

### JAR File Not Found
Ensure the JAR file is in the `target/` directory and correctly referenced in the `Dockerfile`.

### Port Mapping Issues
Confirm that port 8080 is available and used with `-p 8080:8080`.

### Application Fails to Start
Check container logs:

```bash
docker logs <container-id>
```

## License

This project is licensed under the MIT License. See the LICENSE file for details.