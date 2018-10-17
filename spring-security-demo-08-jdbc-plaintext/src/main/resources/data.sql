insert into user (username, password, enabled) values ('amp', '{noop}test123', true);
insert into role(name) values ('ROLE_USER');
insert into role(name) values ('ROLE_ADMIN');
insert into role(name) values ('ROLE_MANAGER');

insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (1,3);