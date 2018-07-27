--USER
insert into user(`ID`, `USER_NAME`, `PASSWORD`, `FIRST_NAME`, `MIDDLE_NAME`, `LAST_NAME`, `EMAIL_ID`, `PHONE`, `STATUS`, `IS_USER_LOCKED`, `IS_PWD_EXPIRED`)
values(1, 'admin@gmail.com', 'admin', 'first', 'middle', 'last', 'admin@gmail.com', '9642648488', 1, 0, 0);


insert into user(`ID`, `USER_NAME`, `PASSWORD`, `FIRST_NAME`, `MIDDLE_NAME`, `LAST_NAME`, `EMAIL_ID`, `PHONE`, `STATUS`, `IS_USER_LOCKED`, `IS_PWD_EXPIRED`)
values(2, 'user@gmail.com', 'user', 'first', 'middle', 'last', 'user@gmail.com', '9999999999', 1, 0, 0);

--ORGANIZATION
insert into organization(`ID`, `NAME`, `DESCRIPTION`, `SECRET_KEY`) values(1, 'GET_SET', 'PAY ROLE SYSTEM', 'GET_SET_!@#');

--organization_sites
insert into organization_sites(`ID`, `ORG_ID`, `SITE_NAME`, `SITE_DISPLAY_NAME`) values(1, '1', 'SITE_A', 'SITE_A');
insert into organization_sites(`ID`, `ORG_ID`, `SITE_NAME`, `SITE_DISPLAY_NAME`) values(2, '1', 'SITE_B', 'SITE_B');
insert into organization_sites(`ID`, `ORG_ID`, `SITE_NAME`, `SITE_DISPLAY_NAME`) values(3, '1', 'SITE_C', 'SITE_C');

--ROLE
insert into role(`ID`, `ROLE_NAME`, `DISPLAY_NAME`) values(1, 'admin', 'ADMIN');
insert into role(`ID`, `ROLE_NAME`, `DISPLAY_NAME`) values(2, 'user', 'USER');


insert into organization_user values(1, 1, 1);
insert into organization_user values(2, 1, 2);


--User ROLES
insert into user_role values(1, 1, 1);
insert into user_role values(2, 2, 1);

--ORGANIZATION USER