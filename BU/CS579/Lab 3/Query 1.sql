use HouseForSale;
select PID, rname
from property as p, realtor as r, seller as s
where p.sid = s.sid and s.rid = r.rid and room > 1 and bath > 1 and city = 'New York City';