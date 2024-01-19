use company;
delimiter $$
create function num_emp (dept_name varchar(15))
returns int
deterministic
begin
	declare dept_emp int;
    
    select count(*) into dept_emp
    from employee, department
    where dno = dnumber and dname = dept_name;
    
    return dept_emp;
end $$