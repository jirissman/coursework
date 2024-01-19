use HouseForSale;
-- Insert 5 REALTOR records
INSERT INTO realtor (rname, company, buyerFee, sellerFee)
VALUES
    ('Aaliyah Patel', 'Ace Realtors', 5, 6),
    ('Benjamin Rodriguez', 'Beacon Realty', 5.5, 4.5),
    ('Chloe Jones', 'Compass Real Estate', 2.75, 4),
    ('Isaac Johnson', 'Keystone Homes', 3.25, 3.5),
    ('Noah Perez', 'Beacon Realty', 4.6, 4.2);
-- Insert 10 SELLER records
INSERT INTO seller (motivated, sname, phone, rid)
VALUES
    (0, 'Alivia Garcia', '7778889999', 1),
    (0, 'Bentley Miller', '1112223333', 3),
    (1, 'Cameron Johnson', '5556667777', 4),
    (0, 'Daniella Perez', '9998887777', 4),
    (0, 'Ezra Walker', '3332221111', 3),
	(1, 'Finnegan Smith', '5555555555', 1),
	(0, 'Harper Jones', '7145553333', 1),
	(1, 'Isabella Garcia', '3105551212', 2),
	(0, 'William Miller', '8183034545', 1),
	(0, 'Imani Brown', '6265557777', 2);
-- Insert 5 BUYER records
INSERT INTO buyer (preapproved, bname, phone, rid)
VALUES
    (1, 'John Doe', '1234567890', 1),
    (0, 'Jane Smith', '9876543210', 2),
    (1, 'David Brown', '5551112222', 3),
    (1, 'Mary Johnson', '3337778888', 5),
    (0, 'Robert Wilson', '9994445555', 5);
-- Insert 20 PROPERTY records
INSERT INTO property (city, ptype, room, bath, sf, allowance, listDate, sid)
VALUES
    ('New York City', 'Romanesque', 3, 2, 1800, 0, '2023-08-11', 8), #5,850,000
    ('Chicago', 'Mid-century modern', 1, 1, 800, 0, '2023-08-17', 4), #200,000
    ('Chicago', 'International', 1, 1, 950, 0, '2023-08-28', 8), #450,000
	('Dallas', 'Ranch', 4, 2, 2500, 0, '2023-09-06', 6), #400,000
    ('San Diego', 'Mission', 2, 1, 1300, 2, '2023-09-08', 4), #630,000
    ('Philadelphia', 'Cape Cod', 5, 3, 3000, 0, '2023-09-15', 8), #500,000
    ('Houston', 'Ranch', 2, 1, 1200, 0, '2023-09-16', 10), #250,000
    ('New York City', 'Georgian', 1, 1, 800, 0, '2023-09-24', 7), #950,000
    ('New York City', 'Art Deco', 4, 3, 2600, 1, '2023-09-26', 7), #8,900,000
    ('Houston', 'Mid-century modern', 3, 2, 1500, 0, '2023-10-02', 6), #685,000
    ('Los Angeles', 'Ranch', 3, 2, 1600, 0, '2023-10-03', 9), #850,000
    ('Boston', 'Colonial', 5, 3, 3200, 0, '2023-10-05', 6), #1,200,000
    ('New York City', 'Postmodern', 2, 2, 1400, 0, '2023-10-09', 1), #700,000
    ('Los Angeles', 'Spanish Colonial', 3, 2, 1900, 0, '2023-10-13', 10), #1,150,000
    ('San Antonio', 'Ranch', 2, 1, 1200, 0, '2023-10-20', 2), #220,000
    ('New York City', 'Gothic', 4, 2, 2200, 0, '2023-10-24', 5), #1,500,000
    ('New York City', 'Renaissance', 4, 3, 2700, 0, '2023-10-24', 5), #1,050,000
    ('Philadelphia', 'American Colonial', 1, 1, 750, 0, '2023-10-26', 6), #180,000
    ('Phoenix', 'Ranch', 2, 2, 1400, 3, '2023-11-03', 3), #400,000
    ('Los Angeles', 'Mid-century modern', 2, 2, 1100, 1, '2023-11-04', 10); #650,000
-- Insert 30 BID_HISTORY records
-- Insert 25 records without closeDate or closePrice first
INSERT INTO bid_history (pid, bid, bidDate, price)
VALUES
	(1,3,'2023-08-15',5300000),
	(1,1,'2023-08-17',5250000),
	(2,2,'2023-08-19',185000),
	(2,3,'2023-08-23',160000),
	(1,3,'2023-08-25',5400000),
	(1,1,'2023-08-28',5500000),
	(2,4,'2023-08-29',190000),
	(2,5,'2023-09-04',205000),
	(4,4,'2023-09-08',385000),
	(5,2,'2023-09-12',600000),
	(7,1,'2023-09-27',210000),
	(6,1,'2023-09-28',440000),
	(8,2,'2023-09-28',925000),
	(6,1,'2023-10-03',450000),
	(9,5,'2023-10-03',9000000),
	(11,1,'2023-10-09',840000),
	(10,1,'2023-10-18',600000),
	(13,2,'2023-10-22',690000),
	(11,4,'2023-10-22',850000),
	(12,1,'2023-10-27',1150000),
	(8,1,'2023-10-29',920000),
	(18,4,'2023-11-02',180000),
	(14,2,'2023-11-03',1050000),
	(12,3,'2023-11-03',1215000),
	(5,4,'2023-11-05',625000);
-- Insert 5 records with closeDate and closePrice
INSERT INTO bid_History (pid, bid, bidDate, price, closeDate, closePrice)
VALUES    
	(3,5,'2023-09-04',445000,'2023-9-25',445000),
	(2,3,'2023-09-05',210000,'2023-9-29',210000),
	(1,5,'2023-09-10',5650000,'2023-10-30',5700000),
	(4,4,'2023-09-16',390000,'2023-10-16',390000),
	(6,3,'2023-09-18',485000,'2023-11-03',495000);
    