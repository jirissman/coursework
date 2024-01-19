use company;
select Fname,Lname
from employee
where ssn not in
(select mgrssn
from department);