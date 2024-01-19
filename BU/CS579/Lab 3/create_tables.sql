Drop database HouseForSale; -- Remove this line if RUN the script first time
Create database HouseForSale;
use HouseForSale;
create table realtor(
	rid int primary key auto_increment,
    rname varchar(50),
    company varchar(50),
    buyerFee DECIMAL(4,2),
    sellerFee DECIMAL(4,2)
	);
    create table buyer(
	bid int primary key auto_increment,
	preapproved boolean,
    bname varchar(50),
    phone varchar(10),
    rid int,
    foreign key (rid) references realtor(rid) on delete restrict on update cascade
	);
    
    create table seller(
	sid int primary key auto_increment,
    motivated boolean,
    sname varchar(50),
    phone varchar(10),
    rid int,
    foreign key (rid) references realtor(rid) on delete restrict on update cascade
	);
create table property (
	pid int primary key auto_increment,
    city varchar(50),
    ptype varchar(50),
    room int,
    bath int,
    sf int,
    allowance decimal(2), 
    listDate date NOT NULL,
    sid int NOT NULL,
    foreign key (sid) references seller(sid) on delete cascade on update cascade
	);
create table bid_history(
	pid int,
    bid int,
    bidDate date,
    price DECIMAL(10),
    closeDate date NULL,
    closePrice DECIMAL(10) NULL,
    foreign key (pid) references property(pid) on delete cascade on update cascade,
    foreign key (bid) references buyer(bid) on delete cascade on update cascade,
    primary key (pid, bid, bidDate)
);