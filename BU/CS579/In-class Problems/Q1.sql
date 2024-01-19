use company;
select fname, lname, bdate from employee e, department d where e.bdate > "1960-01-01" && d.dname = "Research" && e.dno = d.dnumber; 