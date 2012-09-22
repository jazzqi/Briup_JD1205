drop table member cascade constraint purge;
create table member (
	id number(10),
	name varchar2(255) not null,
	password varchar2(255),
	gender varchar2(10),
	email varchar2(255),
	tele varchar2(255),
	registedate date,
	primary key(id),
	unique(name)
);

drop table topic cascade constraint purge;
create table topic(
	id number(10),
	name varchar2(255) not null,
	primary key(id),
	unique(name)
);

drop table post cascade constraint purge;
create table post(
	id number(10),
	title varchar2(255) not null,
	content varchar2(255) not null,
	issuedate date,
	member_id number(10),
	topic_id number(10),
	primary key(id),
	constraint fk_member_post foreign key(member_id) references member(id),
	constraint fk_topic_post foreign key(topic_id) references topic(id)
);