#!/bin/bash

#mysql setup
mkdir -p /var/run/mysqld
chown mysql:mysql /var/run/mysqld

# launch mysql and wait
/usr/bin/mysqld_safe &
RET=1
while [[ RET -ne 0 ]]; do
    echo "=> Waiting for confirmation of MySQL service startup"
    sleep 5
    mysql -uroot -e "status" > /dev/null 2>&1
    RET=$?
done

#before extract to dockerfile
#mysql -u root -e "CREATE DATABASE busyqademo CHARACTER SET UTF8"
#mysql -u root -e "CREATE USER 'admin'@'%' IDENTIFIED BY 'mysql'"
#mysql -u root -e "GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%'"

#crate table for springboot and a user, not use root for remote access
mysql -u root -e "CREATE DATABASE $1 CHARACTER SET UTF8"
mysql -u root -e "CREATE USER '$2'@'%' IDENTIFIED BY '$3'"
mysql -u root -e "GRANT ALL PRIVILEGES ON *.* TO '$2'@'%' WITH GRANT OPTION"

#remove other cnf to release the remote connection limitation
rm /etc/mysql/*.cnf -f

mysql -u root -e "FLUSH PRIVILEGES"
mysqladmin -uroot shutdown
exec supervisord -n


#skill to have a pause
#x=1
#while [ $x -le 5 ]
#do
#  sleep 1h
#done

