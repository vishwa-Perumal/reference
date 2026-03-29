alter table tableretry1 add column useridss int;

--add primary key after table created
ALTER TABLE tableretry1
ADD CONSTRAINT tableretry1_pk PRIMARY KEY (useridss);

--drop constraint
ALTER TABLE tableretry1
DROP CONSTRAINT tableretry1_pkey;

select * from tableretry1;

update tableretry1 
set useridss=987001
where uname='vishwa3';


--delete records
DELETE FROM tableretry1
WHERE useridss IS NULL;