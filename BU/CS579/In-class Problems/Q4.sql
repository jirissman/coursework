use company;
select dname
from department a, dept_locations b, project c
where b.dlocation = "Houston" and a.dnumber = b.dnumber = c.dnum and pname = "Reorganization";