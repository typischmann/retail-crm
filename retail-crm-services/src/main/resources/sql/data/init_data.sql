
insert into CITY(1,'zz','ZHENZHOU','0043',current_time);
insert into CITY(1,'kf','KAIFENG','0053',current_time);
insert into CITY(1,'LY','LUOYANG','0743',current_time);


insert into COUNTRY (PHONE_CODE, NAME, NAME_EN, DELTA_TS) values('+86', 'CN', 'CHINA', current_time);
insert into COUNTRY (PHONE_CODE, NAME, NAME_EN, DELTA_TS) values('+49', 'DE', 'Germany', current_time);

insert into CURRENCY(NUMERIC_CODE, NAME, FULL_NAME) values('156', 'CNY', 'China Yuan Renminbi');
insert into CURRENCY(NUMERIC_CODE, NAME, FULL_NAME) values('840', 'USD', 'US Dollar');
insert into CURRENCY(NUMERIC_CODE, NAME, FULL_NAME) values('978', 'EUR', 'Euro');



insert into DEPARTMENT values(1, 'CEO', 'Chief Executing Officer', null);
insert into DEPARTMENT values(2, 'CFO', 'Chief Finance Officer', 1);
insert into DEPARTMENT values(3, 'CTO', 'Chief Technology Officer', 1);
insert into DEPARTMENT values(4, 'BD', 'Business Development', 1);
insert into DEPARTMENT values(5, 'eCP', 'eCommerce Platform', 1);
insert into DEPARTMENT values(6, 'IR', 'International Retail', 1);
insert into DEPARTMENT values(7, 'NAR', 'North America Retail', 1);
insert into DEPARTMENT values(8, 'WS', 'Web Services', 1);
insert into DEPARTMENT values(9, 'DM', 'Digital Media', 1);
insert into DEPARTMENT values(10, 'L&S', 'Legal & Secretary', 1);
insert into DEPARTMENT values(11, 'Kindle', 'Kindle', 1);
insert into DEPARTMENT values(12, 'RE', 'Real Estate', 2);
insert into DEPARTMENT values(13, 'Control', 'Control', 2);
insert into DEPARTMENT values(14, 'China', 'China', 6);
insert into DEPARTMENT values(15, 'Europe', 'Europe', 6);
insert into DEPARTMENT values(16, 'India', 'India', 6);
insert into DEPARTMENT values(17, 'SS', 'Seller Service', 7);
insert into DEPARTMENT values(18, 'Operations', 'Operations', 7);
insert into DEPARTMENT values(19, 'T,S&HI', 'Toys, Sports & Home Improvement', 7);
insert into DEPARTMENT values(20, 'AP', 'Amazon Publishing', 7);
insert into DEPARTMENT values(21, 'M&V', 'Music & Video', 7);
insert into DEPARTMENT values(22, 'AS', 'Amazon S3', 8);
insert into DEPARTMENT values(23, 'DS', 'Database Services', 8);
insert into DEPARTMENT values(24, 'WP&S', 'Wireless Products & Services', 9);
insert into DEPARTMENT values(25, 'Kindle', 'Kindle', 10);
insert into DEPARTMENT values(26, 'PD&S', 'Product Development & Studios', null);
insert into DEPARTMENT values(27, 'EO', 'Europe Operations', null);
insert into DEPARTMENT values(28, 'GAS', 'Global Advertising Sales', null);
insert into DEPARTMENT values(29, 'CS', 'Computing Services', null);
insert into DEPARTMENT values(30, 'GCF', 'Global Customer Fullfillment', null);

alter sequence department_id_seq restart with 31;

insert into PRODUCT_CATEGORY(NAME, NAME_EN) values('Red Tee', 'Red Tee from China');
insert into PRODUCT_CATEGORY(NAME, NAME_EN) values('Green Tee', 'Green Tee from Indian');
insert into PRODUCT_CATEGORY(NAME, NAME_EN) values('Tee Pot', 'Pot from south');

insert into PRODUCT_PRICE(PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE, DELTA_TS)
values(1,1,1,100.00,50,current_time);
insert into PRODUCT_PRICE(PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE, DELTA_TS)
values(1,2,1,100.00,25,current_time);
insert into PRODUCT_PRICE(PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE, DELTA_TS)
values(2,3,1,100.00,10.50,current_time);
insert into PRODUCT_PRICE(PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE, DELTA_TS)
values(3,1,1,95.00,5.50,current_time);


insert into PRICE_TYPE(TYPE_NAME, NOTE) values('PRICE','The default price');
insert into PRICE_TYPE(TYPE_NAME, NOTE) values('LIST_PRICE','The list price');
insert into PRICE_TYPE(TYPE_NAME, NOTE) values('DISCOUNT','The discounted price');
insert into PRICE_TYPE(TYPE_NAME, NOTE) values('WHOLESALE_PRICE','The wholesal price');
insert into PRICE_TYPE(TYPE_NAME, NOTE) values('SMALL_WHOLESALE_PRICE','The small wholesale price');
insert into PRICE_TYPE(TYPE_NAME, NOTE) values('RETAIL_PRICE','The retail price');



10001		CA	CALENDAR	N	15
10002		CA	CALENDAR	N	10
10003		CA	CALENDAR	N	10
10004		BK	BOOK	Y	90
10005		BK	BOOK	Y	16
10006		BK	BOOK	N	10
10007		BK	BOOK	N	7
10008		BK	BOOK	N	11
10009		BK	BOOK	N	10
10010		BK	BOOK	N	19
10011		GA	GAME	N	11
10012		AR	ARTWORK	Y	195
10013		AR	ARTWORK	Y	195
10014		AR	ARTWORK	Y	175
10015		AR	ARTWORK	Y	195
10016		AR	ARTWORK	Y	195
10017		AR	ARTWORK	Y	540




insert into STATE(COUNTRY_ID, NAME, NAME_EN, DELTA_TS) values(1, 'hn', 'HENAN', current_time);
insert into STATE(COUNTRY_ID, NAME, NAME_EN, DELTA_TS) values(1, 'js', 'JIANGSU', current_time);
insert into STATE(COUNTRY_ID, NAME, NAME_EN, DELTA_TS) values(2, 'Niedersachsen', 'Lower Saxon', current_time);
insert into STATE(COUNTRY_ID, NAME, NAME_EN, DELTA_TS) values(2, 'Bayern', 'Bavaria', current_time);

insert into STORE() values();



