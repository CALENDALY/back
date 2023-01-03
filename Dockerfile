FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/calendar-0.0.1-SNAPSHOT.jar Calendar.jar
ENTRYPOINT ["java", "-jar", "Calendar.jar","-web -webAllowOthers -tcp -tcpAllowOthers -browser"]

