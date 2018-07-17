CREATE DATABASE get_set_leavemanagement CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'root'@'%' IDENTIFIED by 'root';
CREATE USER 'root'@'localhost' IDENTIFIED by 'root';
GRANT EXECUTE ON `get_set_leavemanagement%`.* to root@`%`;
FLUSH PRIVILEGES;

GRANT ALL ON `get_set_leavemanagement%`.* to root@`%`;
FLUSH PRIVILEGES;

