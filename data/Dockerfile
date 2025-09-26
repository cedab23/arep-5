FROM mysql:latest as builder

ENV MYSQL_ROOT_PASSWORD=maj123K.
ENV MYSQL_DATABASE=buildingdb
ENV MYSQL_USER=building
ENV MYSQL_PASSWORD=maj123K.

COPY ./building-schema.sql /docker-entrypoint-initdb.d/

RUN ["sed", "-i", "s/exec \"$@\"/echo \"skipping...\"/", "/usr/local/bin/docker-entrypoint.sh"]
USER mysql
RUN ["/usr/local/bin/docker-entrypoint.sh", "mysqld"]

FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=maj123K.
ENV MYSQL_DATABASE=buildingdb
ENV MYSQL_USER=building
ENV MYSQL_PASSWORD=maj123K.

COPY --from=builder /var/lib/mysql /var/lib/mysql

VOLUME ["/var/lib/mysql"]

USER mysql
EXPOSE 3306