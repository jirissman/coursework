use company;
select dname
from department
where dnumber in
(select dnumber
from dept_locations
where dlocation='Houston')
and dnumber in
(select dnum
from project
where plocation='Bellaire');