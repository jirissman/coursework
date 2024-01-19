use company;
select dependent_name
from dependent, department
where essn = mgrssn;