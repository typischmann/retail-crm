/**
 * if encoding can not be recognized, the following command can be used
 * set client_encoding to 'UTF-8';
 */
set client_encoding to 'UTF-8';
set search_path to dbo;
insert into CITY values(1,1, 'zz', 'ZHENZHOU', '0043',timestamp '2015-03-08 12:00:00');
insert into CITY values(2,1, 'kf', 'KAIFENG',  '0053',timestamp '2015-03-08 12:00:00');
insert into CITY values(3,1, 'LY', 'LUOYANG',  '0743',timestamp '2015-03-08 12:00:00');
insert into CITY values(4, 5, 'jiu jin shan', 'San Fransisco', '',timestamp '2015-03-08 12:00:00');
insert into CITY values(5, 5, 'luo shan ji', 'Los Angeles', '',timestamp '2015-03-08 12:00:00');
insert into CITY values(6, 6, 'fei cheng', 'Phoenix', '',timestamp '2015-03-08 12:00:00');
insert into CITY values(7, 7, 'Dan Fo', 'Denver', '',timestamp '2015-03-08 12:00:00');
insert into CITY values(8, 5, 'Sheng di ya ge', 'San Diego', '',timestamp '2015-03-08 12:00:00');
insert into CITY values(9, 8, 'bo shi dun', 'Boston', '',timestamp '2015-03-08 12:00:00');
insert into CITY values(10, 6, 'Turson', 'Turson', '',timestamp '2015-03-08 12:00:00');
insert into CITY values(11, 9, 'da la si', 'Dallas', '',timestamp '2015-03-08 12:00:00');

alter sequence city_id_seq restart with 12;


insert into COUNTRY values(1, '+86', 'CN', 'CHINA');
insert into COUNTRY values(2, '+1', 'USA', 'United State');
insert into COUNTRY values(3, '+49', 'DE', 'Germany');

alter sequence country_id_seq restart with 4;

insert into CURRENCY(NUMERIC_CODE, NAME, FULL_NAME) values('156', 'CNY', 'China Yuan Renminbi');
insert into CURRENCY(NUMERIC_CODE, NAME, FULL_NAME) values('840', 'USD', 'US Dollar');
insert into CURRENCY(NUMERIC_CODE, NAME, FULL_NAME) values('978', 'EUR', 'Euro');

insert into DEPARTMENT_TYPE(TYPE_NAME, TYPE_DESCRIPTION) values('Director Bording', '');
insert into DEPARTMENT_TYPE(TYPE_NAME, TYPE_DESCRIPTION) values('Business Unit', '');
insert into DEPARTMENT_TYPE(TYPE_NAME, TYPE_DESCRIPTION) values('Team', '');
insert into DEPARTMENT_TYPE(TYPE_NAME, TYPE_DESCRIPTION) values('Store', '');
insert into DEPARTMENT_TYPE(TYPE_NAME, TYPE_DESCRIPTION) values('Warehouse', '');

insert into DEPARTMENT values(1, 'CEO', 'Chief Executing Officer', null, 1);
insert into DEPARTMENT values(2, 'CFO', 'Chief Finance Officer', 1, 1);
insert into DEPARTMENT values(3, 'CTO', 'Chief Technology Officer', 1, 1);
insert into DEPARTMENT values(4, 'BD', 'Business Development', 1, 2);
insert into DEPARTMENT values(5, 'eCP', 'eCommerce Platform', 1, 2);
insert into DEPARTMENT values(6, 'IR', 'International Retail', 1, 2);
insert into DEPARTMENT values(7, 'NAR', 'North America Retail', 1, 2);
insert into DEPARTMENT values(8, 'WS', 'Web Services', 1, 2);
insert into DEPARTMENT values(9, 'DM', 'Digital Media', 1, 2);
insert into DEPARTMENT values(10, 'L&S', 'Legal & Secretary', 1, 3);
insert into DEPARTMENT values(11, 'Kindle', 'Kindle', 1, 3);
insert into DEPARTMENT values(12, 'RE', 'Real Estate', 2, 3);
insert into DEPARTMENT values(13, 'Control', 'Control', 2, 3);
insert into DEPARTMENT values(14, 'China', 'China', 6, 3);
insert into DEPARTMENT values(15, 'Europe', 'Europe', 6, 3);
insert into DEPARTMENT values(16, 'India', 'India', 6, 3);
insert into DEPARTMENT values(17, 'SS', 'Seller Service', 7, 3);
insert into DEPARTMENT values(18, 'Operations', 'Operations', 7, 3);
insert into DEPARTMENT values(19, 'T,S&HI', 'Toys, Sports & Home Improvement', 7, 3);
insert into DEPARTMENT values(20, 'AP', 'Amazon Publishing', 7, 2);
insert into DEPARTMENT values(21, 'M&V', 'Music & Video', 7, 2);
insert into DEPARTMENT values(22, 'AS', 'Amazon S3', 8, 2);
insert into DEPARTMENT values(23, 'DS', 'Database Services', 8, 2);
insert into DEPARTMENT values(24, 'WP&S', 'Wireless Products & Services', 9, 2);
insert into DEPARTMENT values(25, 'Kindle', 'Kindle', 10, 3);
insert into DEPARTMENT values(26, 'PD&S', 'Product Development & Studios', null, 4);
insert into DEPARTMENT values(27, 'EO', 'Europe Operations', null, 4);
insert into DEPARTMENT values(28, 'GAS', 'Global Advertising Sales', null, 4);
insert into DEPARTMENT values(29, 'CS', 'Computing Services', null, 4);
insert into DEPARTMENT values(30, 'GCF', 'Global Customer Fullfillment', null, 4);

alter sequence department_id_seq restart with 31;

insert into EMPLOYEE (ID, DEPARTMENT_ID,FIRST_NAME,SECOND_NAME,START_DATE)
values(1, 1, '敏玲', '范', '2015-01-05');

insert into EMPLOYEE (ID, DEPARTMENT_ID,FIRST_NAME,SECOND_NAME,START_DATE)
values(2, 1, '晓霞', '曾', '2015-01-03');

alter sequence employee_id_seq restart with 3;

insert into ORDERS ( ID, RESPONSIBLE_DEPARTMENT_ID, PARENT_ORDER_ID, RESPONSIBLE_EMPLOYEE_ID,
ORDER_TYPE, IS_PAID, STATUS,IS_ROOT) 
values(10000001, 1, 10000001, 1, 'SALE', 'Y', 1, 'Y');

insert into ORDERS ( ID, RESPONSIBLE_DEPARTMENT_ID, PARENT_ORDER_ID, RESPONSIBLE_EMPLOYEE_ID,
ORDER_TYPE, IS_PAID, STATUS,IS_ROOT) 
values(10000002, 1, 10000002, 1, 'SALE', 'Y', 1, 'Y');

insert into ORDERS ( ID, RESPONSIBLE_DEPARTMENT_ID, PARENT_ORDER_ID, RESPONSIBLE_EMPLOYEE_ID,
ORDER_TYPE, IS_PAID, STATUS,IS_ROOT) 
values(10000003, 1, 10000003, 1, 'SALE', 'Y', 1, 'Y');

insert into ORDERS ( ID, RESPONSIBLE_DEPARTMENT_ID, PARENT_ORDER_ID, RESPONSIBLE_EMPLOYEE_ID,
ORDER_TYPE, IS_PAID, STATUS,IS_ROOT) 
values(10000004, 1, 10000004, 1, 'SALE', 'Y', 1, 'Y');

insert into ORDERS ( ID, RESPONSIBLE_DEPARTMENT_ID, PARENT_ORDER_ID, RESPONSIBLE_EMPLOYEE_ID,
ORDER_TYPE, IS_PAID, STATUS,IS_ROOT) 
values(10000005, 1, 10000005, 1, 'SALE', 'Y', 1, 'Y');

insert into ORDERS ( ID, RESPONSIBLE_DEPARTMENT_ID, PARENT_ORDER_ID, RESPONSIBLE_EMPLOYEE_ID,
ORDER_TYPE, IS_PAID, STATUS,IS_ROOT) 
values(10000006, 1, 10000006, 1, 'SALE', 'Y', 1, 'Y');

insert into ORDERS ( ID, RESPONSIBLE_DEPARTMENT_ID, PARENT_ORDER_ID, RESPONSIBLE_EMPLOYEE_ID,
ORDER_TYPE, IS_PAID, STATUS,IS_ROOT) 
values(10000007, 1, 10000007, 1, 'SALE', 'Y', 1, 'Y');

insert into ORDERS ( ID, RESPONSIBLE_DEPARTMENT_ID, PARENT_ORDER_ID, RESPONSIBLE_EMPLOYEE_ID,
ORDER_TYPE, IS_PAID, STATUS,IS_ROOT) 
values(10000008, 1, 10000008, 1, 'SALE', 'Y', 1, 'Y');

insert into ORDERS ( ID, RESPONSIBLE_DEPARTMENT_ID, PARENT_ORDER_ID, RESPONSIBLE_EMPLOYEE_ID,
ORDER_TYPE, IS_PAID, STATUS,IS_ROOT) 
values(10000009, 1, 10000009, 1, 'SALE', 'Y', 1, 'Y');

alter sequence orders_id_seq restart with 10000010;

insert into ORDER_ITEMS (ID, ORDER_ID, PRODUCT_ID, AMOUNT, PRICE_ID)
values(200000001, 10000001, 10003, 4, 3);

insert into ORDER_ITEMS (ID, ORDER_ID, PRODUCT_ID, AMOUNT, PRICE_ID)
values(200000002, 10000002, 10005, 14, 5);

insert into ORDER_ITEMS (ID, ORDER_ID, PRODUCT_ID, AMOUNT, PRICE_ID)
values(200000003, 10000003, 10005, 160, 5);

insert into ORDER_ITEMS (ID, ORDER_ID, PRODUCT_ID, AMOUNT, PRICE_ID)
values(200000004, 10000003, 10002, 156, 2);

insert into ORDER_ITEMS (ID, ORDER_ID, PRODUCT_ID, AMOUNT, PRICE_ID)
values(200000005, 10000004, 10005, 11, 5);

insert into ORDER_ITEMS (ID, ORDER_ID, PRODUCT_ID, AMOUNT, PRICE_ID)
values(200000006, 10000005, 10005, 1, 5);

insert into ORDER_ITEMS (ID, ORDER_ID, PRODUCT_ID, AMOUNT, PRICE_ID)
values(200000007, 10000006, 10005, 38, 5);

insert into ORDER_ITEMS (ID, ORDER_ID, PRODUCT_ID, AMOUNT, PRICE_ID)
values(200000008, 10000006, 10002, 2, 2);

insert into ORDER_ITEMS (ID, ORDER_ID, PRODUCT_ID, AMOUNT, PRICE_ID)
values(200000009, 10000006, 10005, 7, 5);

insert into ORDER_ITEMS (ID, ORDER_ID, PRODUCT_ID, AMOUNT, PRICE_ID)
values(200000010, 10000008, 10005, 1, 8);

insert into ORDER_ITEMS (ID, ORDER_ID, PRODUCT_ID, AMOUNT, PRICE_ID)
values(200000011, 10000009, 10003, 28, 9);

alter sequence order_items_id_seq restart with 200000012;


insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(1, 1,10001,1,100.00,800);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(2, 1,10002,1,100.00,600);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(3, 1,10003,1,100.00,500);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(4, 1,10004,1,100.00,240);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(5, 1,10005,1,100.00,180);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(6, 1,10006,1,100.00,192);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(7, 1,10007,1,100.00,288);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(8, 1,10008,1,100.00,288);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(9, 1,10009,1,100.00,192);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(10, 1,10010,1,100.00,192);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(11, 1,10011,1,100.00,288);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(12, 1,10012,1,100.00,420);
insert into PRODUCT_PRICE(ID, PRICE_TYPE_ID, PRODUCT_ID, CURRENCY_ID, PRICE_PERCENT, PRICE)
values(13, 1,10013,1,100.00,300);

alter sequence product_price_id_seq restart with 14;

insert into PRICE_TYPE(TYPE_NAME, DESCRIPTION) values('PRICE','The default price');
insert into PRICE_TYPE(TYPE_NAME, DESCRIPTION) values('LIST_PRICE','The list price');
insert into PRICE_TYPE(TYPE_NAME, DESCRIPTION) values('DISCOUNT','The discounted price');
insert into PRICE_TYPE(TYPE_NAME, DESCRIPTION) values('WHOLESALE_PRICE','The wholesal price');
insert into PRICE_TYPE(TYPE_NAME, DESCRIPTION) values('SMALL_WHOLESALE_PRICE','The small wholesale price');
insert into PRICE_TYPE(TYPE_NAME, DESCRIPTION) values('RETAIL_PRICE','The retail price');




insert into STATE values(1, 1, 'hn', 'HENAN');
insert into STATE values(2, 1, 'js', 'JIANGSU');
insert into STATE values(3, 3, 'Niedersachsen', 'Lower Saxon');
insert into STATE values(4, 3, 'Bayern', 'Bavaria');
insert into STATE values(5, 2, 'California', 'CA');
insert into STATE values(6, 2, 'Arizona', 'AZ');
insert into STATE values(7, 2, 'Colorado', 'CO');
insert into STATE values(8, 2, 'Massachusetts', 'MA');
insert into STATE values(9, 2, 'Texas', 'TX');

alter sequence state_id_seq restart with 10; 



insert into WAREHOUSE values (1, 4, 'San Diego Warehouse', 'SD 1700', 2);
insert into WAREHOUSE values (2, 5, 'Boston Warehouse', 'B 1000', 3);
insert into WAREHOUSE values (3, 6, 'Turson Warehouse', 'T 1500', 4);
insert into WAREHOUSE values (4, 7, 'Dallas Warehouse', 'D 1200', 5);

alter sequence warehouse_id_seq restart with 5;

insert into STORE_WAREHOUSE values(1, 1, 1);
insert into STORE_WAREHOUSE values(2, 1, 2);
insert into STORE_WAREHOUSE values(3, 1, 3);
insert into STORE_WAREHOUSE values(4, 2, 1);
insert into STORE_WAREHOUSE values(5, 2, 3);
insert into STORE_WAREHOUSE values(6, 2, 4);
insert into STORE_WAREHOUSE values(7, 3, 2);
insert into STORE_WAREHOUSE values(8, 3, 3);
insert into STORE_WAREHOUSE values(9, 4, 1);
insert into STORE_WAREHOUSE values(10, 4, 3);
insert into STORE_WAREHOUSE values(11, 4, 4);

alter sequence store_warehouse_id_seq restart with 12;

insert into PRODUCT_CATEGORY (ID ,NAME,NAME_EN)
values(1, '红茶', 'Black Tee');

insert into PRODUCT_CATEGORY (ID ,NAME,NAME_EN)
values(2, '普洱熟茶', 'Pu Er Shu Tee');

insert into PRODUCT_CATEGORY (ID ,NAME,NAME_EN)
values(3, '普洱生茶', 'Pu Er Sheng Tee');

alter sequence product_category_id_seq restart with 4;
--Dumping the data for products
insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10001, 1, 1, '千金红', 'Qian Jin Hong', '千金红', 'QQS-BT-001', '2015-01-03');

insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10002, 2, 1, '黄金绣球', 'Huang Jin Xiu Qiu', '黄金绣球', 'QQS-BT-002', '2015-01-03');

insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10003, 3, 1, '娜允天香', 'Na Yun Tian Xiang', '娜允天香', 'QQS-BT-003', '2015-01-03');


insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10004, 4, 1, '千红', 'Qian Hong', '千红', 'QQS-BT-004', '2015-01-03');

insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10005, 5, 1, '蜜香金珠', 'Mi Xiang Jin Zhu', '蜜香金珠', 'QQS-BT-005', '2015-01-03');

insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10006, 6, 2, '精腴', 'Jing Yu', '精腴', 'QQS-PT-001', '2015-01-03');

insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10007, 7, 2, '涌泉', 'Yong Quan', '涌泉', 'QQS-PT-002', '2015-01-03');

insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10008, 8, 3, '思源', 'Si Yuan', '思源', 'QQS-PT-003', '2015-01-03');

insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10009, 9, 3, '精武', 'Jing Wu', '精武', 'QQS-PT-004', '2015-01-03');

insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10010, 10, 3, '志趣', 'Zhi Qu', '志趣', 'QQS-PT-005', '2015-01-03');

insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10011, 11, 2, '物喜', 'Wu Xi', '物喜', 'QQS-PT-006', '2015-01-03');

insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10012, 12, 3, '大器', 'Da Qi', '大器', 'QQS-PT-007', '2015-01-03');

insert into PRODUCT (ID, ACTIVE_PRICE_ID, PRODUCT_CATEGORY_ID, NAME, NAME_EN, FULL_NAME, 
PRODUCT_INTERNAL_CODE, START_DATE)
values(10013, 13, 3, '格朗河帕沙', 'Ge Lang He Pa Sha', '格朗河帕沙', 'QQS-GT-001', '2015-01-03');

alter sequence product_id_seq restart with 10014;



