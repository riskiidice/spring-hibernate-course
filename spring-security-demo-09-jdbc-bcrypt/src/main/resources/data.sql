insert into user (username, password, enabled) values ('amp', '{bcrypt}$2a$04$jP7kBGpU5W7OYahmFIEoiuL.wlxDZl6lOR2A7zn1OqndR4sc31ldO', true);
insert into role(name) values ('ROLE_EMPLOYEE');
insert into role(name) values ('ROLE_ADMIN');
insert into role(name) values ('ROLE_MANAGER');

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (1,3);