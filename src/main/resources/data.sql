INSERT INTO Article ( title , body ) VALUES ( 'article1' , 'lorem ipsum vertate' );
INSERT INTO Article ( title , body ) VALUES ( 'article2' , 'lorem ipsum vertate' );
INSERT INTO Article ( title , body ) VALUES ( 'article3' , 'lorem ipsum vertate' );

INSERT INTO Role (rolename) VALUES ('ROLE_ADMIN');
INSERT INTO Role (rolename) VALUES ('ROLE_AUTHENTICATED');

insert into User (username, encryptedpassword, enabled) values ('Mansur', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
insert into User (username, encryptedpassword, enabled) values ('Admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
insert into User (username, encryptedpassword, enabled) values ('Jerry', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into user_roles (users_id, roles_id)
values (1, 1);
 
insert into user_roles (users_id, roles_id)
values (2, 1);

insert into user_roles (users_id, roles_id)
values (3, 2);