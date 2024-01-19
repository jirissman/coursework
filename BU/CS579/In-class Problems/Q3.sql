use company;
select fname, lname
from employee, department, project
where pname = "ProductX" and dnumber = dnum and ssn = mgrssn;