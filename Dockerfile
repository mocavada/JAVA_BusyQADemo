FROM openjdk:8

# download mysql & supervisor
RUN apt-get update;apt-get install -y lsb-release mysql-server supervisor; apt-get clean; rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
# pwgen

# Add image configuration and scripts
COPY run.sh /run.sh
COPY start-springboot.sh /start-springboot.sh
COPY start-mysqld.sh /start-mysqld.sh
COPY supervisord-springboot.conf /etc/supervisor/conf.d/supervisord-springboot.conf
COPY supervisord-mysqld.conf /etc/supervisor/conf.d/supervisord-mysqld.conf
RUN chmod 755 /*.sh

#copy mysql config
COPY my.cnf /etc/mysql/conf.d/my.cnf
RUN chmod 644 /etc/mysql/conf.d/my.cnf

#copy app file
ARG JAR_FILE
COPY ${JAR_FILE} /app.jar

EXPOSE 80 3306
ENTRYPOINT ["/run.sh", "busyqademo","admin","mysql"]

################################################################
#https://github.com/mdelapenya/docker-tomcat-mysql

################################################################
#FROM openjdk:8-jdk-alpine
#EXPOSE 8080
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} /app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#CMD java -jar /app.jar
