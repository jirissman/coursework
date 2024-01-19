use houseforsale;

delimiter $$
create trigger UniqueRealtors
before insert on bid_history
for each row
begin
	declare buyerRealtor int;
    declare sellerRealtor int;
    -- get realtor's ID from buyer table
    select rid into buyerRealtor
    from buyer b
    where new.bid = b.bid;
    -- get realtor's ID from seller table through property table
    select rid into sellerRealtor
    from property p, seller s
    where new.pid = p.pid and p.sid = s.sid;
    -- compare and trigger
    if buyerRealtor = sellerRealtor then
		signal sqlstate '45000'
			set message_text = 'Buyer and seller cannot have the same realtor.';
	end if;
end $$
delimiter ;