# Docker image for springboot file run
# VERSION 0.0.1
# Author: hcl
# 基础镜像使用java
FROM java:8
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名为springboot-book.jar
ADD target/book-0.0.1-SNAPSHOT.jar /springboot-book.jar
# 运行jar包
RUN bash -c 'touch /springboot-book.jar'
ENV TZ 'Asia/Shanghai'
EXPOSE 8082
ENTRYPOINT ["java","-jar","/springboot-book.jar"]
