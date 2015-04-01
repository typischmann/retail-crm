/*
 * for installing the table in Postgres Database can use the following command in the console
 * \i 'script_path'
 */

set search_path to dbo;
--check if this extension existed
--TODO: Need a test
create or replace function install_encryption_extension()
return void as $$
begin
	if not exists (select 1 from pg_catalog.pg_available_extensions ex where ex.name = 'pgcrypto')
	then
	create extension pgcrypto;
	end if;
end;
$$ language plpgsql;

select install_encryption_extension();
/*=========================================================================================================*/
/* Table: ADDRESS                                               										   */
/*=========================================================================================================*/
create table ADDRESS (
ID                   SERIAL,
CONTACTABLE_ID       INTEGER  				not null,
LOCATION_ID          INTEGER,
ADDRESS_STRING       VARCHAR(100),
ZIP_CODE             VARCHAR(10),
STREET               VARCHAR(50),
HOUSE_NUM            VARCHAR(12),
STREET_NUM           VARCHAR(6),
APART_NUM            VARCHAR(6),
NOTE                 VARCHAR(255),
DELTA_TS			 TIMESTAMP				default current_timestamp,
constraint PK_ADDRESS primary key (ID)
);



/*=========================================================================================================*/
/* Table: CITY                                                  										   */
/*=========================================================================================================*/
create table CITY (
ID  				SERIAL,
STATE_ID 			INTEGER,
NAME 				VARCHAR(100) 			NOT NULL,	
NAME_EN 			VARCHAR(100),
PHONE_CODE 			VARCHAR(6),
DELTA_TS			TIMESTAMP				default current_timestamp,
constraint PK_CITY primary key (ID)
);

/*=========================================================================================================*/
/* Table: COUNTRY                                               										   */
/*=========================================================================================================*/
create table COUNTRY (
ID 					SERIAL,
PHONE_CODE 			VARCHAR(6),
NAME 				VARCHAR(50) 			NOT NULL,
NAME_EN 			VARCHAR(50),
DELTA_TS			TIMESTAMP				DEFAULT current_timestamp,
constraint PK_COUNTRY primary key (ID)
);

/*=========================================================================================================*/
/* Table: CURRENCY                                              										   */
/*=========================================================================================================*/
create table CURRENCY (
ID                   SERIAL,
NUMERIC_CODE         CHAR(3),
NAME                 VARCHAR(10)                    NOT NULL,
NAME_EN              VARCHAR(10),
FULL_NAME            VARCHAR(20),
constraint PK_CURRENCY primary key (ID)
);

/*==========================================================================================================*/
/* Table: DEPARTMENT                                            											*/
/*==========================================================================================================*/
create table DEPARTMENT (
ID                   		SERIAL,
NAME                 		VARCHAR(50)                    not null,
NAME_EN						VARCHAR(50),
PARENT_DEPARTMENT_ID        INTEGER,
DEPARTMENT_TYPE_ID			INTEGER,
constraint PK_DEPARTMENT primary key (ID)
);

/*==========================================================================================================*/
/* Table: DEPARTMENT_TYPE                                            											*/
/*==========================================================================================================*/
create table DEPARTMENT_TYPE(
ID							SERIAL,
TYPE_NAME					VARCHAR(50),
TYPE_DESCRIPTION			VARCHAR(300),
constraint PK_DEPARTMENT_TYPE primary key (ID)
);

/*=========================================================================================================*/
/* Table: DISTRICT                                              										   */
/*=========================================================================================================*/
create table DISTRICT (
ID SERIAL,
CITY_ID INTEGER not null,
NAME VARCHAR(50) not null,
NAME_EN VARCHAR(50),
DELTA_TS			 TIMESTAMP,
constraint PK_DISTRICT primary key (ID)
);

/*==========================================================================================================*/
/* Table: EMPLOYEE                                              											*/
/*==========================================================================================================*/
create table EMPLOYEE (
ID                   SERIAL,
DEPARTMENT_ID        INTEGER,
FIRST_NAME			 VARCHAR(50),
SECOND_NAME			 VARCHAR(50),
START_DATE           DATE,
END_DATE			 DATE 				default null,
NOTE                 VARCHAR(255),
DELTA_TS			 TIMESTAMP 			default current_timestamp,
constraint PK_EMPLOYEE primary key (ID)
);


/*=========================================================================================================*/
/* Table: INVENTORY_CURRENT_ITEMS	This table stores the current inventory in real time				   */
/* It should have a cascading trigger to update the amount status for the higher level deparment,		   */
/* but take care of infinite recursion trigger															   */				
/*=========================================================================================================*/
create table INVENTORY_CURRENT_ITEMS (
ID                   			SERIAL,
PRODUCT_ID           			INTEGER                        not null,
DEPARTMENT_ID    	 			INTEGER                        not null,--refering to store or warehouse, if 0, it should be a global overview 
REAL_AMOUNT               		NUMERIC(15,2)                  not null,--The really amount in the department
RESERVED_AMOUNT					NUMERIC(15,2)				   default 0,--The amount of items which are reserved, booked, pre ordered, e. g. such as a new created order item
INVENTORY_CHANGE_RECORD_ID		INTEGER						   not null, --refering to the change which causes the current inventory from last one
CREATE_TS			 			TIMESTAMP					   default current_timestamp,
DELTA_TS			 			TIMESTAMP					   default current_timestamp,
constraint PK_INVENTORY_CURRENT_ITEMS primary key (ID)
);

/*=========================================================================================================*/
/* Table: INVENTORY_CHANGE_RECORDS providing a mapping between departments and order items to record	   */
/* the changes for inventory		   																	   */
/*=========================================================================================================*/
create table INVENTORY_CHANGE_RECORDS (
ID                   	SERIAL,
DEPARMENT_ID			integer							not null,
ORDER_ITEM_ID  			integer,
AMOUNT_VALUE			integer,
CHANGE_TYPE				integer,						-- 0 income 1 outcome
CHANGE_STATUS			integer,						-- 0 begin 1 finished 2 cancelled
CREATE_TS			 	timestamp						default current_timestamp,
DELTA_TS			 	timestamp						default current_timestamp,
constraint PK_INVENTORY_CHANGE_RECORDS primary key (ID)
);

/*=========================================================================================================*/
/* Table: INVENTORY_PERIOD_OVERVIEW providing a periodically overview for the inventory					   */
/* a database job will be used to calculate it periodically												   */
/*=========================================================================================================*/
create table INVENTORY_PERIOD_OVERVIEW (
ID                   	SERIAL,
DEPARMENT_ID			integer							not null,
PERIOD_TYPE				integer,						-- 0 daily 1 monthly 2 yearly
TOTAL_AMOUNT			integer,
DELTA_TS			 	timestamp						default current_timestamp,
constraint PK_INVENTORY_PERIOD_OVERVIEW primary key (ID)
);



/*=========================================================================================================*/
/* Table: LOCATION  country/region/city/district               											   */
/*=========================================================================================================*/
create table LOCATION (
ID                   SERIAL,
COUNTRY_ID 			 INTEGER not null,
STATE_ID 			 INTEGER,
CITY_ID 			 INTEGER,
DISTRICT_ID 		 INTEGER,
NAME 				 VARCHAR(50) not null,
NAME_EN 			 VARCHAR(50),
DELTA_TS			 TIMESTAMP,
constraint PK_LOCALITY primary key (ID)
);

/*==============================================================*/
/* Table: PARTNER                                               */
/*==============================================================*/
create table PARTNER (
ID                   INTEGER                        not null,
CONTACT_ID           INTEGER,
PARTNER_GROUP_ID     INTEGER,
PARTNER_TYPE_ID      INTEGER                        default 1 not null,
NAME                 VARCHAR(50)                    not null,
NAME_EN              VARCHAR(50),
FULL_NAME            VARCHAR(100),
YEAR_CREATE          INTEGER                        default 0 not null,
WORK_TIME            VARCHAR(50),
NOTE                 VARCHAR(255),
PARENT_PARTNER_ID    INTEGER,
IMAGE_FILE_NAME      VARCHAR(50),
IS_PERSON            CHAR(1)                        default 'N' not null,
constraint PK_PARTNER primary key (ID)
);

/*==============================================================*/
/* Table: PARTNER_CONTACT                                           */
/*==============================================================*/
create table PARTNER_CONTACT(
ID                   INTEGER                        not null,
ADDRESS_ID           INTEGER,
--PHONE_ID             INTEGER,
PARTNER_ID           INTEGER                        not null,
QQ                   VARCHAR(15),
constraint PK_CONTACTABLE primary key (ID)
);

/*=========================================================================================================*/
/* Table: PRICE_TYPE                                          											   */
/*=========================================================================================================*/
create table PRICE_TYPE (
ID                   		SERIAL,
TYPE_NAME            		VARCHAR(30)					not null, --Discount, VIP,Wholesale,retail,income-price, etc
DESCRIPTION                 VARCHAR(255),
constraint PK_PRICE_TYPE primary key (ID)
);

/*=========================================================================================================*/
/* Table: PRODUCT                                               										   */
/*=========================================================================================================*/
create table PRODUCT (
ID                   		SERIAL,
SUPPLIER_PARTNER_ID    		INTEGER,
PRODUCT_CATEGORY_ID     	INTEGER,
MANUFACTURER_PARTNER_ID		INTEGER,
ACTIVE_PRICE_ID				INTEGER,
NAME                 		VARCHAR(100)                   not null,
NAME_EN              		VARCHAR(100),
FULL_NAME            		VARCHAR(100),
PRODUCT_INTERNAL_CODE		VARCHAR(100),
START_DATE           		DATE						   default current_date,
END_DATE             		DATE,
NOTE                 		VARCHAR(255),
WARRANTY_PERIOD      		INTEGER,
IMAGE_FILE_PATH      		VARCHAR(50),
DELTA_TS			 		TIMESTAMP						default current_timestamp,
constraint PK_PRODUCT primary key (ID)
);

/*=========================================================================================================*/
/* Table: PRODUCT_CATEORY                                         										   */
/*=========================================================================================================*/
create table PRODUCT_CATEGORY (
ID                   SERIAL,
NAME                 VARCHAR(100)                   not null,
NAME_EN              VARCHAR(100),
constraint PK_PRODUCT_CATEGORY primary key (ID)
);

/*=========================================================================================================*/
/* Table: PRODUCT_PRICE                                     										       */
/*=========================================================================================================*/
create table PRODUCT_PRICE (
ID                   SERIAL,
PRICE_TYPE_ID        INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
CURRENCY_ID          INTEGER                        not null,
PRICE_PERCENT     	 NUMERIC(6,2)                  	not null,
PRICE                NUMERIC(15,2)                  not null,
START_DATE			 DATE							default current_date,
END_DATE			 DATE,
DELTA_TS			 TIMESTAMP						default current_timestamp,
constraint PK_PRODUCT_PRICE primary key (ID)
);

/*======================================================================*/
/* Table: ORDERS	ORDER_TYPE: (PURCHASE,SALE,TRANSPORT)				*/
/* STATUS: (0: CREATED, 1: EXECUTED, 2: CANCELLED)						*/
/*======================================================================*/
create table ORDERS (
ID                   				SERIAL,
RESPONSIBLE_DEPARTMENT_ID 	 		integer,
PARENT_ORDER_ID						integer,
RESPONSIBLE_EMPLOYEE_ID  			integer,
ORDER_TYPE							varchar(20),
IS_PAID              				char(1)                        	default 'N' not null,
STATUS								integer							default 0 not null,
IS_ROOT								char(1)							default 'Y' not null,
CREATE_TS							timestamp						default current_timestamp,
DELTA_TS			 				timestamp						default current_timestamp,
constraint PK_SALE_ORDER primary key (ID)
);

/*==============================================================*/
/* Table: ORDER_ITEMS	                                        */
/*==============================================================*/
create table ORDER_ITEMS (
ID                   			SERIAL,
ORDER_ID	        			integer,
PRODUCT_ID           			integer                        	not null,
AMOUNT               			numeric(15,2)                  	not null,
PRICE_ID						integer							not null,
DELTA_TS			 			timestamp						default current_timestamp,
constraint PK_ORDER_ITEM primary key (ID)
);

/*==========================================================================================================*/
/* Table: ORDER_TYPES decription for orders, e. g. transport order, sale order, purchase order				*/
/*==========================================================================================================*/
/*create table ORDER_TYPES(
ID					SERIAL,
TYPE_NAME			varchar(50),
TYPE_DESCRIPTION	varchar(300),
constraint PK_ORDER_TYPES_ID primary key (ID)
);*/

/*=========================================================================================================*/
/* Table: STATE																							   */
/*=========================================================================================================*/
create table STATE (
ID SERIAL,
COUNTRY_ID           INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
NAME_EN 			 VARCHAR(50),
DELTA_TS			 TIMESTAMP						default current_timestamp,
constraint PK_REGION primary key (ID)
);

/*=========================================================================================================*/
/* Table: STORE                                                 										   */
/*=========================================================================================================*/
create table STORE (
ID                   SERIAL,
DEPARTMENT_ID        INTEGER			not null,
--ADDRESS_ID			 INTEGER,
NAME                 VARCHAR(50),
NAME_EN              VARCHAR(50),
MANAGER_EMPLOYEE_ID  INTEGER,
DELTA_TS			 TIMESTAMP 			default current_timestamp,
constraint PK_STORE primary key (ID)
);

/*=========================================================================================================*/
/* Table: STORE_WAREHOUSE  Mapping between stores and warehouse        		                               */
/*=========================================================================================================*/
create table STORE_WAREHOUSE (
ID                   SERIAL,
STORE_ID			 INTEGER                      	not null,
WAREHOUSE_ID 		 INTEGER                      	not null,
constraint PK_STORE_WAREHOUSE primary key (ID)
);

/*==============================================================*/
/* Table: SYS_USER                                              */
/*																*/
/*==============================================================*/
create table SYS_USER (
ID                   INTEGER                        not null,
USER_NAME            VARCHAR(64)                    not null,
USER_PASSWORD        VARCHAR(64)                    not null, --Here storing a encrypted password
AUTHORIZATION_LEVEL  INTEGER						not null, --The permission of the user
USER_STATUS			 INTEGER						not null, --CREATED, VERIFIED, BLOCKED
USER_TYPE			 INTEGER						not null, --Personal Customer, Organization Customer, Employee, Supplier
START_DATE           DATE                           not null,
END_DATE           	 DATE,
constraint PK_SYS_USER primary key (ID)
);


/*=========================================================================================================*/
/* Table: WAREHOUSE                                             										   */
/*=========================================================================================================*/
create table WAREHOUSE (
ID                   	SERIAL,
DEPARTMENT_ID			integer							not null,
--ADDRESS_ID 			 INTEGER,
NAME 				 	varchar(100),
NAME_EN 			 	varchar(100),
MANAGER_EMPLOYEE_ID  	integer,
WAREHOUSE_TYPE			integer,						-- 0 Normal Storage 1 Cold Storage
DELTA_TS			 	timestamp						default current_timestamp,
constraint PK_WAREHOUSE primary key (ID)
);



