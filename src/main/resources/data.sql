insert into user_role(id, name)
values (1, 'CLIENT');
insert into user_role(id, name)
values (2, 'BACKOFFICE');
insert into users (id, username, user_role, create_time, update_time)
values ('2346fa71-10d6-4fca-8db9-4674ff6ca39b', 'ilya', 1, CURRENT_DATE, CURRENT_DATE);
insert into users (id, username, user_role, create_time, update_time)
values ('150fd450-2c8e-4ea3-a164-b8b7050cc75b', 'peter', 1, CURRENT_DATE, CURRENT_DATE);
insert into users (id, username, user_role, create_time, update_time)
values ('06bc58c7-4076-49e9-aead-69e98af06616', 'dima', 1, CURRENT_DATE, CURRENT_DATE);
insert into users (id, username, user_role, create_time, update_time)
values ('6a15771c-fa6d-4351-8010-4dbd47ce734c', 'Admin', 2, CURRENT_DATE, CURRENT_DATE);

insert into operating_system (name, create_time, update_time)
values ('ANDROID', CURRENT_DATE, CURRENT_DATE);
insert into operating_system (name, create_time, update_time)
values ('iOS', CURRENT_DATE, CURRENT_DATE);

insert into devices (operating_system, user_id, create_time, update_time)
VALUES (1, '2346fa71-10d6-4fca-8db9-4674ff6ca39b', CURRENT_DATE, CURRENT_DATE);
insert into devices (operating_system, user_id, create_time, update_time)
VALUES (2, '2346fa71-10d6-4fca-8db9-4674ff6ca39b', CURRENT_DATE, CURRENT_DATE);
insert into devices (operating_system, user_id, create_time, update_time)
VALUES (1, '2346fa71-10d6-4fca-8db9-4674ff6ca39b', CURRENT_DATE, CURRENT_DATE);
insert into devices (operating_system, user_id, create_time, update_time)
VALUES (2, '2346fa71-10d6-4fca-8db9-4674ff6ca39b', CURRENT_DATE, CURRENT_DATE);
insert into devices (operating_system, user_id, create_time, update_time)
VALUES (2, '150fd450-2c8e-4ea3-a164-b8b7050cc75b', CURRENT_DATE, CURRENT_DATE);
insert into devices (operating_system, user_id, create_time, update_time)
VALUES (1, '150fd450-2c8e-4ea3-a164-b8b7050cc75b', CURRENT_DATE, CURRENT_DATE);
insert into devices (operating_system, user_id, create_time, update_time)
VALUES (1, '150fd450-2c8e-4ea3-a164-b8b7050cc75b', CURRENT_DATE, CURRENT_DATE);
insert into devices (operating_system, user_id, create_time, update_time)
VALUES (2, '06bc58c7-4076-49e9-aead-69e98af06616', CURRENT_DATE, CURRENT_DATE);
insert into devices (operating_system, user_id, create_time, update_time)
VALUES (1, '06bc58c7-4076-49e9-aead-69e98af06616', CURRENT_DATE, CURRENT_DATE);
insert into devices (operating_system, user_id, create_time, update_time)
VALUES (2, '06bc58c7-4076-49e9-aead-69e98af06616', CURRENT_DATE, CURRENT_DATE);