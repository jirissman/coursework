use company;
select pnumber, pname
from project, works_on
where pno = pnumber
group by pno
having count(*)>2;