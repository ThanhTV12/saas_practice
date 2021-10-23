FROM docker.topicanative.edu.vn/java:18x
COPY ./target/web-one-0.0.1-SNAPSHOT.jar /home/thanh/app/web/
WORKDIR /home/thanh/app/web
ENV TZ=Asia/Ho_Chi_Minh
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
CMD java -jar -Dspring.profiles.active=release /home/thanh/app/web/web-one-0.0.1-SNAPSHOT.jar