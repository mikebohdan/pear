FROM clojure:tools-deps
COPY . /usr/app
WORKDIR /usr/app
CMD ["clj", "-T:build", "uber"]

FROM eclipse-temurin:17-jre-alpine
WORKDIR /root/
COPY --from=0 /usr/app/target/pear-uber.jar app.jar
CMD ["java", "-jar", "app.jar"]