# Используем OpenJDK 11 в качестве базового образа
FROM openjdk:11

# Копируем JAR файл внутрь контейнера
COPY ./target/BracketChecker-1.0.jar /app/BracketChecker-1.0.jar

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Make the jar file executable
RUN chmod +x /app/BracketChecker-1.0.jar

# Запускаем JAR файл
CMD ["java", "-jar", "BracketChecker-1.0.jar"]