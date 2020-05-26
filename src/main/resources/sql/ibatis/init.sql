create table COM_FIREWALL(
	FIREWALL_ID RAW(16),
	SOURCE_IP varchar2(32),
	DESTINATION_IP varchar2(32),
	PORT varchar2(32),
	BOUND varchar2(32),
	USED_SYSTEM varchar2(32),
	PURPOSE varchar2(32),
	CHANGER_ID varchar2(32),
	CHANGE_DATE datetime,
	DELETE_YN varchar2(1),
	PRIMARY KEY(FIREWALL_ID),
	CONSTRAINT firewall_id UNIQUE (SOURCE_IP, DESTINATION_IP, PORT, BOUND, USED_SYSTEM) 
)
;

create table Person (
    name varchar2(20),
    age int,
    primary key (name)
);