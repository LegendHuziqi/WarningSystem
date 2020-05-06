create table role
(
    id   int auto_increment,
    name varchar(128) not null,
    constraint Role_id_uindex
        unique (id),
    constraint Role_name_uindex
        unique (name)
)
    comment '角色表' collate = utf8mb4_bin;

alter table role
    add primary key (id);

INSERT INTO WarningSystem.role (id, name) VALUES (4, '学生');
INSERT INTO WarningSystem.role (id, name) VALUES (1, '教学秘书');
INSERT INTO WarningSystem.role (id, name) VALUES (3, '班主任');
INSERT INTO WarningSystem.role (id, name) VALUES (2, '辅导员');