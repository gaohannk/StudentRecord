drop table if exists `t_student`;
CREATE TABLE `t_student` (
'id' int(11) not null auto_increament,
`stu_name` varchar(16) not null ,
`gender` int(1) default null 
`age` int(3) not null ,
`address` varchar(128) not null ,
) engine = innodb auto_increament= 12 default charset=utf8;
insert into `t_studetn` values (`1`, `david`, `1`, `20` , `United Stated` )；

