drop database vendor;

create database vendor;

use vendor;

CREATE TABLE VENDORS(
vendor_id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
mobile_no VARCHAR(12) NOT NULL,
email_id VARCHAR(30) NOT NULL,
city VARCHAR(40) NOT NULL
);

alter table vendors auto_increment=0;

INSERT INTO VENDORS(name,mobile_no,email_id,city) VALUES("Poonam","8971769091","poonam@gmail.com","Gadag");
INSERT INTO VENDORS(name,mobile_no,email_id,city) VALUES("Nikhila","8971768980","nikila@gmail.com","AP");
INSERT INTO VENDORS(name,mobile_no,email_id,city) VALUES("Dipesh", "8372628281","dipesh@gmail.com","Siliguri");
INSERT INTO VENDORS(name,mobile_no,email_id,city) VALUES("Neelam", "97272846282", "neelam@gmail.com", "Patna");
INSERT INTO VENDORS(name,mobile_no,email_id,city) VALUES("Pritam", "8534736372", "pritam@gmail.com", "Kolkata");
INSERT INTO VENDORS(name,mobile_no,email_id,city) VALUES("Ajay", "8372624351","ajay@gmail.com","Guwahati");
INSERT INTO VENDORS(name,mobile_no,email_id,city) VALUES("Babita", "9727282382", "babita@gmail.com", "Bhopal");
INSERT INTO VENDORS(name,mobile_no,email_id,city) VALUES("Ratna", "8183736372", "ratna@gmail.com", "Delhi");

select * from vendors;