FROM frolvlad/alpine-oraclejdk8:slim
RUN apk --update add --no-cache tzdata &&\
    cp /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime &&\
    echo "America/Sao_Paulo" > /etc/timezone
ADD demo-exemplo-consumidor.jar /app.jar
CMD java -Djava.security.egd=file:/dev/./urandom -jar /app.jar