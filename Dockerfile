# Utiliza la imagen oficial de OpenJDK con la versión que necesitas
FROM openjdk:17
FROM gradle:8.5

# Establece el directorio de trabajo en la raíz del contenedor
WORKDIR /app

# Copia el archivo build.gradle y settings.gradle para aprovechar el caché de dependencias
COPY build.gradle .
COPY settings.gradle .

# Copia todos los archivos fuente al directorio de trabajo
COPY src ./src

# Construye el proyecto con Gradle
# RUN gradle build (No funcionó como esperaba).
RUN gradle shadowJar

# Expone el puerto en el que se ejecutará tu aplicación java (ajústalo según tus necesidades)
EXPOSE 5000
EXPOSE 50123

# Comando para ejecutar la aplicación java al iniciar el contenedor
CMD ["java", "-jar", "build/libs/conserjeria-0.0.1-all.jar"]