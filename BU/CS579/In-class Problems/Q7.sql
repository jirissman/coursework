use company;
select Dname
from department as d, dept_locations as l, project as p
where d.dnumber=l.dnumber and p.dnum=d.dnumber and l.dlocation='Houston' and p.plocation='Bellaire';