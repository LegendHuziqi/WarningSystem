create table relationship
(
    className varchar(64) not null,
    teacher   int         null comment '教师id',
    advisor   int         null comment '辅导员id',
    constraint relationship_className_uindex
        unique (className)
);

alter table relationship
    add primary key (className);

