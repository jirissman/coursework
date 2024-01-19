use company;
delimiter $$
create procedure merge_dept()
begin
	declare headquarters_manager char(9);
    declare hq_mgr_start_date date;
    select mgrssn, mgrstartdate into headquarters_manager, hq_mgr_start_date
    from department
    where dname = 'Headquarters';
    
	insert into department
    values ('HQ',3, headquarters_manager,hq_mgr_start_date);
end $$