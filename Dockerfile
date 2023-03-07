FROM openjdk
EXPOSE 8080
ADD target/svtodo-1.0-snapshot.jar svtodo-1.0-snapshot.jar
ENTRYPOINT ["java","jar","/svtodo-1.0-snapshot.jar"]