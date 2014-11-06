/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     2014/11/6 10:55:14                           */
/*==============================================================*/


if exists (select 1
            from  sysobjects
           where  id = object_id('CLASSES_LV')
            and   type = 'U')
   drop table CLASSES_LV
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CLASS_STAD')
            and   type = 'U')
   drop table CLASS_STAD
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CROPS_LV')
            and   type = 'U')
   drop table CROPS_LV
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('GROUPS_LV')
            and   name  = 'R159_SDE_ROWID_UK'
            and   indid > 0
            and   indid < 255)
   drop index GROUPS_LV.R159_SDE_ROWID_UK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('GROUPS_LV')
            and   type = 'U')
   drop table GROUPS_LV
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Method')
            and   type = 'U')
   drop table Method
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ParamName')
            and   type = 'U')
   drop table ParamName
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ParamValue')
            and   type = 'U')
   drop table ParamValue
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ROLE_LV')
            and   type = 'U')
   drop table ROLE_LV
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ROLE_USER_MAP_LV')
            and   type = 'U')
   drop table ROLE_USER_MAP_LV
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SAMPLES_LV')
            and   name  = 'R157_SDE_ROWID_UK'
            and   indid > 0
            and   indid < 255)
   drop index SAMPLES_LV.R157_SDE_ROWID_UK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SAMPLES_LV')
            and   type = 'U')
   drop table SAMPLES_LV
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SHEDULETIME')
            and   type = 'U')
   drop table SHEDULETIME
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SP_TABLE_META_LV')
            and   name  = 'R156_SDE_ROWID_UK'
            and   indid > 0
            and   indid < 255)
   drop index SP_TABLE_META_LV.R156_SDE_ROWID_UK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SP_TABLE_META_LV')
            and   type = 'U')
   drop table SP_TABLE_META_LV
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SYMBOL_LV')
            and   type = 'U')
   drop table SYMBOL_LV
go

if exists (select 1
            from  sysobjects
           where  id = object_id('USERINFO_LV')
            and   type = 'U')
   drop table USERINFO_LV
go

if exists (select 1
            from  sysobjects
           where  id = object_id('area')
            and   type = 'U')
   drop table area
go

execute sp_revokedbaccess SDE
go


/*==============================================================*/
/* Table: CLASSES_LV                                            */
/*==============================================================*/
create table CLASSES_LV (
   ID                   numeric(14)          null,
   CLASS                numeric(10)          null,
   CLASS_NAME           varchar(20)          null,
   COLOR                varchar(10)          null,
   SYMBOLID             numeric(10)          null,
   LOWER                numeric(19,8)        null,
   UPPER                numeric(19,8)        null
)
go

/*==============================================================*/
/* Table: CLASS_STAD                                            */
/*==============================================================*/
create table CLASS_STAD (
   SID                  numeric(10)          not null,
   ITEM                 varchar(20)          not null,
   CLASS                numeric(2)           not null,
   CLASS_NAME           varchar(20)          not null,
   LOWER                numeric(10,4)        not null,
   UPPER                numeric(10,4)        not null,
   COLOR                varchar(10)          not null,
   constraint PK_CLASS_STAD primary key nonclustered (SID)
)
go



/*==============================================================*/
/* Table: CROPS_LV                                              */
/*==============================================================*/
create table CROPS_LV (
   ID                   numeric              null,
   NAME_CH              varchar(20)          null,
   NAME_EN              varchar(20)          null
)
go



/*==============================================================*/
/* Table: Method                                                */
/*==============================================================*/
create table Method (
   id                   int                  not null,
   name                 varchar(100)         null,
   "desc"               varchar(1000)        null,
   constraint PK_METHOD primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: ParamName                                             */
/*==============================================================*/
create table ParamName (
   id                   int                  not null,
   MethodID             int                  null,
   ParamName            varchar(100)         null,
   constraint PK_PARAMNAME primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: ParamValue                                            */
/*==============================================================*/
create table ParamValue (
   id                   int                  not null,
   ParamID              int                  null,
   ParamValue           nvarchar(1000)       null,
   constraint PK_PARAMVALUE primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: ROLE_LV                                               */
/*==============================================================*/
create table ROLE_LV (
   ID                   numeric(9)           not null,
   ROLENAME             varchar(50)          not null,
   TYPE                 varchar(50)          not null,
   DESTEXT              varchar(1000)        not null,
   constraint SYS_C0013295 primary key nonclustered (ID)
)
go

/*==============================================================*/
/* Table: ROLE_USER_MAP_LV                                      */
/*==============================================================*/
create table ROLE_USER_MAP_LV (
   ID                   numeric(9)           not null,
   ROLEID               numeric(9)           not null,
   USERID               numeric(9)           not null,
   constraint SYS_C0013299 primary key nonclustered (ID)
)
go

/*==============================================================*/
/* Table: SAMPLES_LV                                            */
/*==============================================================*/
create table SAMPLES_LV (
   OBJECTID             numeric              not null,
   SID                  numeric(10)          null,
   SP_ID                varchar(50)          null,
   SP_NAME              varchar(50)          null,
   SP_LON               numeric(19,8)        null,
   SP_LAT               numeric(19,8)        null,
   --SHAPE                ST_GEOMETRY      null,
   SP_Type              varchar(50)          null,
   SP_PB                numeric(19,8)        null,
   SP_CD                numeric(19,8)        null,
   SP_AS                numeric(19,8)        null,
   SP_CR                numeric(19,8)        null,
   SP_HG                numeric(19,8)        null,
   PH                   numeric(19,8)        null,
   SP_PB2               numeric(19,8)        null,
   SP_CD2               numeric(19,8)        null,
   SP_AS2               numeric(19,8)        null,
   SP_CR2               numeric(19,8)        null,
   SP_HG2               numeric(19,8)        null,
   constraint PK_SAMPLES_LV primary key nonclustered (OBJECTID)
)
go



/*==============================================================*/
/* Table: SHEDULETIME                                           */
/*==============================================================*/
create table SHEDULETIME (
   ID                   numeric(5)           null,
   STIME                timestamp            null
)
go

/*==============================================================*/
/* Table: SP_TABLE_META_LV                                      */
/*==============================================================*/
create table SP_TABLE_META_LV (
   OBJECTID             numeric              not null,
   SP_TABLE_NAME        varchar(20)          null,
   SP_COLUMN_NAME       varchar(20)          null,
   SP_DATA_TYPE         varchar(20)          null,
   SP_DATA_LENGTH       varchar(20)          null,
   SP_DATA_PRECISION    varchar(20)          null,
   SP_DATA_SCALE        varchar(20)          null,
   SP_NULLABLE          varchar(20)          null,
   SP_DATA_DEFAULT      varchar(20)          null,
   SP_COMMENTS          varchar(20)          null,
   SP_CATEGORY          varchar(20)          null
)
go

/*==============================================================*/
/* Index: R156_SDE_ROWID_UK                                     */
/*==============================================================*/
create unique index R156_SDE_ROWID_UK on SP_TABLE_META_LV (
OBJECTID ASC
)
go

/*==============================================================*/
/* Table: SYMBOL_LV                                             */
/*==============================================================*/
create table SYMBOL_LV (
   ID                   numeric(10)          null,
   OWNERID              numeric(6)           null,
   CLASS                varchar(1)           null,
   ITEM                 varchar(20)          null,
   S_COLOR              varchar(10)          null,
   E_COLOR              varchar(10)          null
)
go

/*==============================================================*/
/* Table: USERINFO_LV                                           */
/*==============================================================*/
create table USERINFO_LV (
   ID                   numeric(6)           null,
   NAME                 varchar(30)          null,
   ROLE                 numeric(10)          null,
   PASSWORD             varchar(20)          null,
   GROUPID              numeric(5)           null
)
go

/*==============================================================*/
/* Table: area                                                  */
/*==============================================================*/
create table area (
   areaCode             varchar(255)         not null,
   areaLevel            numeric(11)          not null,
   areaName             varchar(255)         null,
   subAreaNum           numeric(11)          not null
)
go


