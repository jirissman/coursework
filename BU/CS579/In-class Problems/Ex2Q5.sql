use company;
select dname, count(*)
from employee, department
where dno = dnumber
group by dno;