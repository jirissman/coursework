use houseforsale;

call get_highest_bidder(2, @bname, @rname, @price);
select @bname as 'Buyer Name', @rname as 'Buyer\'s Realtor Name', @price as 'Highest Bid Price in USD';