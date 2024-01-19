use company;
(select fname, lname, dno
from employee
where dno = 5)
union
(select fname, lname, dno
from employee, department
where ssn = mgrssn)