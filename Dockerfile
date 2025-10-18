# Etapa 1: Construcción
FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar archivos de configuración de Maven
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .

# Descargar dependencias (se cachea esta capa si no cambia el pom.xml)
RUN mvn dependency:go-offline -B

# Copiar el código fuente
COPY src ./src

# Construir la aplicación
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Crear usuario no privilegiado
RUN groupadd -r appgroup && useradd -r -g appgroup appuser

# Copiar el JAR desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Cambiar propietario del archivo
RUN chown appuser:appgroup app.jar

# Cambiar a usuario no privilegiado
USER appuser

# Exponer el puerto
EXPOSE 8081

# Configurar variables de entorno para la aplicación
ENV SPRING_PROFILES_ACTIVE=docker

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]