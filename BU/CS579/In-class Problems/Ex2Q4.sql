use company;
select dno, count(*)
from employee
group by dno;