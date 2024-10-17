# Etapa de construcción
FROM openjdk:17-jdk-slim AS build

# Instalar Maven dentro del contenedor
RUN apt-get update && apt-get install -y maven && apt-get clean && rm -rf /var/lib/apt/lists/*

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos de configuración de Maven
COPY pom.xml .

# Descargar las dependencias
RUN mvn dependency:go-offline -B

# Copiar el resto del código fuente de la aplicación
COPY src ./src

# Compilar la aplicación (genera el JAR ejecutable)
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo .env al contenedor (opcional)
COPY .env .env

# Copiar el JAR compilado desde la etapa de build
COPY --from=build /app/target/survey-platform-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto (ajusta si tu app escucha en otro puerto)
EXPOSE 8080

# Configurar la entrada para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
