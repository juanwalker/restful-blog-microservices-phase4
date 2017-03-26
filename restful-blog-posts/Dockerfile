FROM java:8
ENV JPDA_ADDRESS=8000
ENV JPDA_TRANSPORT=dt_socket
VOLUME /tmp
ADD target/restful-blog-posts*.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]