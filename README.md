# springWebProject


[Part 3]
create table tbl_reply (
	rno INT NOT NULL AUTO_INCREMENT,
	bno INT NOT NULL default 0,
	replytext varchar(1000) NOT NULL,
	replyer varchar(50) NOT NULL,
	regdate timestamp NOT NULL default now(),
	updatedate timestamp NOT NULL default now(),
	primary key(rno)
); 

alter table tbl_reply add constraint fk_board
foreign key (bno) references tbl_board(bno);



[Part 4]
create table tbl_user (
	uid varchar(50) NOT NULL,
	upw varchar(50) NOT NULL,
	uname varchar(100) NOT NULL,
	upoint int NOT NULL DEFAULT 0,
	primary key(uid)
); 

create table tbl_message (
	mid int not null auto_increment,
	targetid varchar(50) NOT NULL,
	sender varchar(50) NOT NULL,
	message text NOT NULL,
	opendate timestamp,
	senddate timestamp NOT NULL default now(),
	primary key(mid)
); 

alter table tbl_message add constraint fk_usertarget
foreign key (targetid) references tbl_user(uid);

alter table tbl_message add constraint fk_usersender
foreign key (sender) references tbl_user(uid);

insert into tbl_user(uid, upw, uname) values('user00', 'user00', 'IRON MAN'); 
insert into tbl_user(uid, upw, uname) values('user01', 'user01', 'CAPTAIN'); 
insert into tbl_user(uid, upw, uname) values('user02', 'user02', 'HULK'); 
insert into tbl_user(uid, upw, uname) values('user03', 'user03', 'Thor'); 
insert into tbl_user(uid, upw, uname) values('user10', 'user10', 'Quick Silver'); 

[Part 4 : Ch5]
alter table tbl_board add column replycnt int default 0;