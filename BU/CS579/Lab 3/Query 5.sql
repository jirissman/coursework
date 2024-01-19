use HouseForSale;
select avg(datediff(h.closeDate, p.listDate))
from property as p, bid_history as h
where h.pid = p.pid and closedate is not null;