create table user
(
    id            int auto_increment,
    userName      varchar(128) null comment '用户名,即学号或教师工号',
    password      varchar(128) null,
    roleId        int          null,
    college       varchar(64)  null comment '学院',
    className     varchar(64)  null comment '班级',
    name          varchar(128) null comment '学生姓名',
    phone         int          null,
    room          varchar(32)  null comment '宿舍号',
    address       varchar(256) null,
    contactName   varchar(128) null,
    contactPhone  int          null,
    warningStatus varchar(64)  null,
    warningReason varchar(256) null,
    description   varchar(512) null,
    handleStatus  varchar(64)  null,
    constraint user_id_uindex
        unique (id)
)
    collate = utf8mb4_bin;

alter table user
    add primary key (id);

