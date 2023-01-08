SET FOREIGN_KEY_CHECKS=0; -- to disable them
drop table if exists my_group cascade;
drop table if exists my_user cascade;
drop table if exists schedule cascade;
drop table if exists middle_entity_user_group;
SET FOREIGN_KEY_CHECKS=1; -- to re-enable them

create table my_group
(
    id bigint auto_increment
        primary key,
    created_at varchar(255) null,
    updated_at varchar(255) null,
    name varchar(255) null
);

create table my_user
(
    user_id bigint auto_increment
        primary key,
    created_at varchar(255) null,
    updated_at varchar(255) null,
    access_token varchar(255) null,
    email varchar(255) null,
    image_url varchar(255) null,
    nick_name varchar(255) null,
    sns_type varchar(255) null
);

create table middle_entity_user_group
(
    id bigint auto_increment
        primary key,
    group_id bigint null,
    user_user_id bigint null,
    constraint FK1hhyd3k5cjhivanvhn4h1ujwp
        foreign key (group_id) references my_group (id),
    constraint FKj09i3gccbppsssrowxg2phm55
        foreign key (user_user_id) references my_user (user_id)
);

create table schedule
(
    id bigint auto_increment
        primary key,
    created_at varchar(255) null,
    updated_at varchar(255) null,
    contents varchar(200) null,
    end_dt varchar(255) null,
    start_dt varchar(255) null,
    subject varchar(255) not null,
    thumb_nail_url varchar(255) null,
    group_id bigint null,
    constraint FK8kk7bbfa7hxxeu0pbwhh24awl
        foreign key (group_id) references my_group (id)
);

