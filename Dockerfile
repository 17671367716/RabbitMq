FROM tomcat:1.0
MAINTAINER wyw<1328235636@qq.com>

EXPOSE  8080

CMD /usr/local/apache-tomcat-9.0.41/bin/startup.sh && tail -F /url/local/apache-tomcat-9.0.41/bin/logs/catalina.out
