CREATE TABLE NOTES(
	id int not null AUTO_INCREMENT,
	title nvarchar(100),
	content nvarchar,
    created_at timestamp default CURRENT_TIMESTAMP()
);

