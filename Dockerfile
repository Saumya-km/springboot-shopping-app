FROM eclipse-temurin:17-jdk

# current working directory of container

WORKDIR shop-app/

# Copy the compiled jar into the container

COPY target/shopping-1.0.jar shop-app.jar

#exposed port from container

EXPOSE 8081

# Run the jar when the container starts

ENTRYPOINT ["java", "-jar", "shop-app.jar"]

#ENTRYPOINT ["java", "-jar", "app.jar"]
