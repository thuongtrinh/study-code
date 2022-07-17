set search_path to springexample;

insert into role(code, name) values ('ADMIN', 'Quan tri he thong');
insert into role(code, name) values ('USER', 'Nhan vien');
insert into role(code, name) values ('MANAGER', 'Quan ly');

insert into users(username, password, fullname)
values('admin', 'dfdsfdf3t546t5t5t5t5fdsfdf5fddsfdf', 'admin');
insert into users(username, password, fullname)
values('user', 'thrhgfhgfhdfdsfdf3t546t5t5t5t5fdsf', 'user');
insert into users(username, password, fullname)
values('manager', 'frfdfdsfdf3t546t5t5t5t5fdsfdf5fdds', 'manager');
insert into users(username, password, fullname)
values('test1', 'freferfrfrdfdsfdf3t546t5t5t5t5fdsf', 'test1');
insert into users(username, password, fullname)
values('test2', 'verferfredfdsfdf3t546t5t5t5t5fdsfy', 'test3');
insert into users(username, password, fullname)
values('test3', 'frefrfrdfdsfdf3t546t5t5t5t5fdsfdf5', 'test3');
insert into users(username, password, fullname)
values('test4', 'frefrfrdfdsfdyhtgfrfrfrfdsdsd5t5fd', 'test4');

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (2,2);
insert into user_role(user_id, role_id) values (3,3);
insert into user_role(user_id, role_id) values (4,2);
insert into user_role(user_id, role_id) values (5,2);
insert into user_role(user_id, role_id) values (6,2);
insert into user_role(user_id, role_id) values (7,2);

