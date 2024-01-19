use company;
select dname
from department
where dnumber not in
(select dnumber
from dept_locations
where dlocation = 'Houston');