use company;
select pname
from project
where pnumber not in
(select pnumber
from project, department
where dnumber = dnum and dname = 'Administration');