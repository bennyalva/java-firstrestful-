INSERT INTO users (id, ds_name, ds_lastname, age) VALUES (1, 'Benny', 'Rodriguez', 25);
INSERT INTO users (id, ds_name, ds_lastname, age) VALUES (2, 'Bere', 'BRodriguez', 26);
INSERT INTO users (id, ds_name, ds_lastname, age) VALUES (3, 'BenUr', 'BuRodriguez', 27);

commit;
select count(*) from users;
alter sequence users_id_seq restart with 10;