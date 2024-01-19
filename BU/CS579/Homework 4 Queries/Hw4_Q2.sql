use company;
select ssn, fname, lname
from employee
where ssn not in (select essn from works_on);