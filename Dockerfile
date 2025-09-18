# Используем базовый образ OpenJDK 21
FROM openjdk:21-jdk-alpine

# Указываем рабочую директорию внутри контейнера
WORKDIR /app

# Добавляем собранный JAR-файл в образ
# Замените "serviceAuthorize-0.0.1-SNAPSHOT.jar" на имя вашего JAR-файла
COPY target/serviceAuthorize-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт, на котором будет работать приложение
EXPOSE 8080

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
