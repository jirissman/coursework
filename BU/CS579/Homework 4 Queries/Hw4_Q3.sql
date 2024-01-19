use company;
select fname, lname
from employee, dept_locations, project, works_on
where dno = dnumber and dlocation = 'Stafford' and ssn = essn and pno = pnumber and pname = 'Computerization';