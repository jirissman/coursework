use company;
drop procedure if exists control_dept;
delimiter //
create procedure control_dept(in proj_name varchar(15), out dept_name varchar(15))
begin
	select dname into dept_name
    from department,project
    where dnum = dnumber and pname = proj_name;
end
//