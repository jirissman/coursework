use HouseForSale;
select pid, city, rname
from property as p, seller as s, realtor as r
where p.sid = s.sid and s.rid = r.rid and pid not in
(select pid from bid_history);