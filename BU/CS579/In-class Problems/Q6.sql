use company;
select Ssn,Fname,Lname
from employee
where Ssn NOT IN 
(select Ssn
from works_on,project
where Ssn=Essn and Pno=Pnumber and Pname = 'ProductX');