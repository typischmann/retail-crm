set search_path to dbo;
/*=========================================================================================================*/
/* Table: ADDRESS                                               										   */
/*=========================================================================================================*/
create table ADDRESS (
ID                   SERIAL,
CONTACTABLE_ID       INTEGER  not null,
LOCATION_ID          INTEGER,
ADDRESS_STRING       VARCHAR(100),
ZIP_CODE             VARCHAR(10),
STREET               VARCHAR(50),
HOUSE_NUM            VARCHAR(12),
STREET_NUM           VARCHAR(6),
APART_NUM            VARCHAR(6),
NOTE                 VARCHAR(255),
DELTA_TS			 TIMESTAMP,
constraint PK_ADDRESS primary key (ID)
);

/*=========================================================================================================*/
/* Table: CITY                                                  										   */
/*=========================================================================================================*/
create table CITY (
ID  				SERIAL,
STATE_ID 			INTEGER,
NAME 				VARCHAR(100) NOT NULL,	
NAME_EN 			VARCHAR(100),
PHONE_CODE 			VARCHAR(6),
DELTA_TS			TIMESTAMP,
constraint PK_CITY primary key (ID)
);

/*=========================================================================================================*/
/* Table: COUNTRY                                               										   */
/*=========================================================================================================*/
create table COUNTRY (
ID 					SERIAL,
PHONE_CODE 			VARCHAR(6),
NAME 				VARCHAR(50) not null,
NAME_EN 			VARCHAR(50),
DELTA_TS			TIMESTAMP,
constraint PK_COUNTRY primary key (ID)
);

/*=========================================================================================================*/
/* Table: CURRENCY                                              										   */
/*=========================================================================================================*/
create table CURRENCY (
ID                   SERIAL,
NUMERIC_CODE         CHAR(3),
NAME                 VARCHAR(10)                    not null,
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
constraint PK_DEPARTMENT primary key (ID)
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
ID                   INTEGER                        not null,
DEPARTMENT_ID        INTEGER,
FIRST_NAME			 VARCHAR(50),
SECOND_NAME			 VARCHAR(50),
START_DATE           DATE,
END_DATE			 DATE default null,
NOTE                 VARCHAR(255),
constraint PK_EMPLOYEE primary key (ID)
);

/*=========================================================================================================*/
/* Table: GOODS_INCOME_ITEM                                     										   */
/*=========================================================================================================*/
create table GOODS_INCOME_ITEM (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
PRODUCT_PRICE_ID	 INTEGER						not null,
INCOME_WAREHOUSE_ID  INTEGER                        not null,
--Supplier ID
AMOUNT               NUMERIC(15,2)                  not null,
DELIVERY_COST		 NUMERIC(15,2),
INCOME_DATE			 TIMESTAMP,
DELTA_TS			 TIMESTAMP,
constraint PK_GOODS_INCOME_ITEM primary key (ID)
);

/*=========================================================================================================*/
/* Table: GOODS_OUTCOME_ITEM                                     										   */
/*=========================================================================================================*/
create table GOODS_OUTCOME_ITEM (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
PRODUCT_PRICE_ID	 INTEGER						not null,
OUTCOME_WAREHOUSE_ID INTEGER                        not null,
--Supplier ID
AMOUNT               NUMERIC(15,2)                  not null,
DELIVERY_COST		 NUMERIC(15,2),
OUTCOME_DATE		 TIMESTAMP,
DELTA_TS			 TIMESTAMP,
constraint PK_GOODS_OUTCOME_ITEM primary key (ID)
);

/*=========================================================================================================*/
/* Table: GOODS_MOVE_ITEM    Delivery among Warehouses          										   */
/*=========================================================================================================*/
create table GOODS_MOVE_ITEM (
ID                   INTEGER                        not null,
INCOME_WAREHOUSE_ID  INTEGER                        not null,
OUTCOME_WAREHOUSE_ID INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
AMOUNT               INTEGER		                not null,
PRODUCT_PRICE_ID	 INTEGER						not null,
DELIVERY_COST		 NUMERIC(15,2),
OUTCOME_DATE		 TIMESTAMP,
INCOME_DATE			 TIMESTAMP,
DELTA_TS			 TIMESTAMP,
constraint PK_INVENTORY_MOVE_ITEM primary key (ID)
);




/*=========================================================================================================*/
/* Table: INVENTORY_REST_ITEM                                   										   */
/*=========================================================================================================*/
create table GOODS_REST_ITEM (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
WAREHOUSE_ID    	 INTEGER                        not null,
AMOUNT               NUMERIC(15,2)                  not null,
PRODUCT_PRICE_ID	 INTEGER						not null,
DELTA_TS			 TIMESTAMP,
constraint PK_INVENTORY_REST_ITEM primary key (ID)
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
ID                   SERIAL,
TYPE_NAME            VARCHAR(30)					not null, --Discount, VIP,Wholesale,retail,income-price, etc
NOTE                 VARCHAR(255),
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
NAME                 		VARCHAR(100)                   not null,
NAME_EN              		VARCHAR(100),
FULL_NAME            		VARCHAR(100),
START_DATE           		DATE,
END_DATE             		DATE,
NOTE                 		VARCHAR(255),
WARRANTY_PERIOD      		INTEGER,
DIM_LENGTH           		NUMERIC(12,3)                  default 0 not null,
DIM_WIDTH            		NUMERIC(12,3)                  default 0 not null,
DIM_HEIGHT           		NUMERIC(12,3)                  default 0 not null,
WEIGHT               		NUMERIC(12,3)                  default 0 not null,
IMAGE_FILE_NAME      		VARCHAR(50),
DELTA_TS			 		TIMESTAMP,
constraint PK_PRODUCT primary key (ID)
);

/*=========================================================================================================*/
/* Table: PRODUCT_CATEORY                                         										   */
/*=========================================================================================================*/
create table PRODUCT_CATEGORY (
ID                   SERIAL,
NAME                 VARCHAR(100)                   not null,
NAME_EN              VARCHAR(100),
constraint PK_PRODUCT_GROUP primary key (ID)
);

/*=========================================================================================================*/
/* Table: PRODUCT_PRICE                                     										       */
/*=========================================================================================================*/
create table PRODUCT_PRICE (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
CURRENCY_ID          INTEGER                        not null,
PRICE_PERCENT     	 NUMERIC(6,2)                  	not null,
PRICE                NUMERIC(15,2)                  not null,
DELTA_TS			 TIMESTAMP,
constraint PK_PRODUCT_PRICE primary key (ID)
);

/*=========================================================================================================*/
/* Table: STATE																							   */
/*=========================================================================================================*/
create table STATE (
ID SERIAL,
COUNTRY_ID           INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
NAME_EN 			 VARCHAR(50),
DELTA_TS			 TIMESTAMP,
constraint PK_REGION primary key (ID)
);

/*=========================================================================================================*/
/* Table: STORE                                                 										   */
/*=========================================================================================================*/
create table STORE (
ID                   SERIAL,
ADDRESS_ID			 INTEGER,
NAME                 VARCHAR(50),
NAME_EN              VARCHAR(50),
MANAGER_EMPLOYEE_ID  INTEGER,
DELTA_TS			 TIMESTAMP,
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

/*=========================================================================================================*/
/* Table: WAREHOUSE                                             										   */
/*=========================================================================================================*/
create table WAREHOUSE (
ID                   SERIAL,
ADDRESS_ID 			 INTEGER,
NAME 				 VARCHAR(100),
NAME_EN 			 VARCHAR(100),
MANAGER_EMPLOYEE_ID  INTEGER,
DELTA_TS			 TIMESTAMP,
constraint PK_WAREHOUSE primary key (ID)
);

