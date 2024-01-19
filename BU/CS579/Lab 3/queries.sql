use houseforsale;
-- Query 1
select pid, rname
from property as p, realtor as r, seller as s
where p.sid = s.sid and s.rid = r.rid and room > 1 and bath > 1 and city = 'New York City';
-- Query 2
select b.bid, b.bname, h.price
from buyer as b, bid_history as h
where b.bid = h.bid and pid = '2';
-- Query 3
select p.pid, r.rname, r.company
from realtor as r, property as p, seller as s
where s.rid = r.rid and p.sid = s.sid and datediff(current_date(),p.listdate)>15 and p.pid not in
(select pid
from bid_history
where closeDate is not null);
-- Query 4
select pid, city, rname
from property as p, seller as s, realtor as r
where p.sid = s.sid and s.rid = r.rid and pid not in
(select pid from bid_history);
-- Query 5
select avg(datediff(h.closeDate, p.listDate))
from property as p, bid_history as h
where h.pid = p.pid and closedate is not null;