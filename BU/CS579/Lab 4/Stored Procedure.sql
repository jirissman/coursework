use houseforsale;
drop procedure if exists get_highest_bidder;
delimiter $$
create procedure get_highest_bidder (in pid int, out bname varchar(50), out rname varchar(50), out bid_price decimal(10,0))
begin
	-- find the highest bid
    select max(price) into bid_price
    from bid_history bh
    where bh.pid = pid;
    -- get buyer and realtor info
    select b.bname, r.rname into bname, rname
    from buyer b, bid_history bh, realtor r
    where bh.bid = b.bid and b.rid = r.rid and bh.price = bid_price and bh.pid = pid;
end $$
delimiter ;