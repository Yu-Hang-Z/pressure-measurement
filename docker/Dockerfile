# 使用官方的OpenJDK 11作为基础镜像
FROM openjdk:11-jre-slim


# 设置工作目录
WORKDIR /app

# 将Spring Boot可执行jar文件复制到工作目录
COPY target/pressure-measurement-0.0.1-SNAPSHOT.jar app.jar

# 暴露应用程序运行的端口
EXPOSE 8080

# 指定启动命令
CMD ["java", "-jar", "app.jar"]
