use HouseForSale;
select b.bid, b.bname, h.price
from buyer as b, bid_history as h
where b.bid = h.bid and pid = '2';