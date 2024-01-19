use company;
delimiter $$
create trigger supervise
	before insert on employee
    for each row
begin
	declare reports tinyint;
    
	select count(*) into reports
    from employee
    where superssn = new.superssn;
    
    if reports >= 3 then
		 signal sqlstate '45000'
            set message_text = 'An employee can supervise at most three employees.';
	end if;
end $$
    