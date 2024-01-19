use company;
select fname, lname, dependent_name
from employee left join dependent on ssn = essn;