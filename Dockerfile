FROM oracle/graalvm-ce

# Add Maintainer Info
MAINTAINER Bhargav <bhargavryl@gmail.com>

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/Idempotency-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} Idempotency.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/Idempotency.jar"]