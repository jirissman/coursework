use company;
select dname
from department as d
where not exists
(select dlocation
from dept_locations as l
where d.dnumber = l.dnumber and dlocation = 'Houston');