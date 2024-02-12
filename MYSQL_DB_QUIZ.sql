create database revanth;
use revanth;
show tables;

drop table question;
drop table quiz_questions;
drop table quiz;

create table `question`(
	`id` int NOT NULL,
	`category` varchar(25) DEFAULT NULL,
    `difficulty_level` varchar(25) DEFAULT NULL,
	`option1` varchar(255) DEFAULT NULL,
	`option2` varchar(255) DEFAULT NULL,
    `option3` varchar(255) DEFAULT NULL,
    `option4` varchar(255) DEFAULT NULL,
    `question_title` varchar(255) DEFAULT NULL,
    `correct_answer` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


create table `quiz`(
	`id` int NOT NULL ,
    `quiz_title` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table `quiz_questions` (
	quiz_id int NOT NULL,
    question_id int NOT NULL,
    primary key (quiz_id, question_id),
    FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`),
    FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

show tables;

desc question;
desc quiz;
desc quiz_questions;

insert into question values(1,"Sports","Easy","Team A","Team B","Team C","Team D","Which team won the World Cup?","Team B");

insert into quiz values(1,"Sports");

insert into quiz_questions values(1,1);

select * from question;
select * from quiz;
select * from quiz_questions;

