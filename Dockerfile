FROM eclipse-temurin:17-jdk-alpine


COPY target/pokemon-*.jar ms-pokemon.jar


EXPOSE 8090


CMD ["java", "-jar", "ms-pokemon.jar"]