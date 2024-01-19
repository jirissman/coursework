use HouseForSale;
select p.pid, r.rname, r.company
from realtor as r, property as p, seller as s
where s.rid = r.rid and p.sid = s.sid and datediff(current_date(),p.listdate)>15 and p.pid not in
(select pid
from bid_history
where closeDate is not null);