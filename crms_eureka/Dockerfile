FROM openjdk:11-jdk

#maintainer
MAINTAINER "chuncheng <chuncheng.jiang.partner@decathlon.com>"
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
VOLUME /logs/jcc-eureka-asia
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && \
    echo $TZ > /etc/timezone
CMD java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar