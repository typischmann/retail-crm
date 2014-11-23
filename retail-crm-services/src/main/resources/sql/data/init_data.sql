
insert into CITY(1,'zz','ZHENZHOU','0043',current_time);
insert into CITY(1,'kf','KAIFENG','0053',current_time);
insert into CITY(1,'LY','LUOYANG','0743',current_time);


insert into COUNTRY (PHONE_CODE, NAME, NAME_EN, DELTA_TS) values('+86', 'CN', 'CHINA', current_time);
insert into COUNTRY (PHONE_CODE, NAME, NAME_EN, DELTA_TS) values('+49', 'DE', 'Germany', current_time);

insert into CURRENCY(NUMERIC_CODE, NAME, FULL_NAME) values('156', 'CNY', 'China Yuan Renminbi');
insert into CURRENCY(NUMERIC_CODE, NAME, FULL_NAME) values('840', 'USD', 'US Dollar');
insert into CURRENCY(NUMERIC_CODE, NAME, FULL_NAME) values('978', 'EUR', 'Euro');


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



