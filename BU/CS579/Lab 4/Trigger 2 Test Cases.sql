use houseforsale;
-- successful insert
insert into bid_history (pid, bid, bidDate, price)
values
	(1, 1, '2023-09-04', 5700000);
    
-- failed insert
insert into bid_history (pid, bid, bidDate, price)
values
	(1, 2, '2023-09-04', 5700000);