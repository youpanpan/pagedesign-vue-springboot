/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/10/24 10:16:31                          */
/*==============================================================*/


drop table if exists componentattr;

drop table if exists page;

drop table if exists pagecomponent;

drop table if exists pagehtml;

/*==============================================================*/
/* Table: componentattr                                         */
/*==============================================================*/
create table componentattr
(
   id                   VARCHAR(50) not null comment '主键',
   componentid          VARCHAR(50) comment '组件ID',
   attrname             VARCHAR(100) comment '属性名称',
   attrvalue            VARCHAR(1000) comment '属性值',
   attrtype             CHAR(1) comment '属性类型,1:字符串,2:数值,3:布尔值,4:数组,5:对象,6:其它',
   createdate           DATETIME comment '创建时间',
   createuser           VARCHAR(50) comment '创建人',
   updatedate           DATETIME comment '更新时间',
   updateuser           VARCHAR(50) comment '更新人',
   ordernum             INT comment '排序号',
   state                CHAR(1) comment '状态，1：有效，0：无效',
   primary key (id)
);

alter table componentattr comment '组件属性';

/*==============================================================*/
/* Table: page                                                  */
/*==============================================================*/
create table page
(
   id                   VARCHAR(50) not null comment '主键',
   pagename             VARCHAR(200) comment '页面名称',
   createdate           DATETIME comment '创建时间',
   createuser           VARCHAR(50) comment '创建人',
   updatedate           DATETIME comment '更新时间',
   updateuser           VARCHAR(50) comment '更新人',
   ordernum             INT comment '排序号',
   state                CHAR(1) comment '状态，1：有效，0：无效',
   primary key (id)
);

alter table page comment '页面（也是一个组件）';

/*==============================================================*/
/* Table: pagecomponent                                         */
/*==============================================================*/
create table pagecomponent
(
   id                   VARCHAR(50) not null comment '主键',
   pageid               VARCHAR(50) comment '页面ID',
   componentname        VARCHAR(200) comment '组件名称',
   componentid          VARCHAR(200) comment '组件页面标识',
   createdate           DATETIME comment '创建时间',
   createuser           VARCHAR(50) comment '创建人',
   updatedate           DATETIME comment '更新时间',
   updateuser           VARCHAR(50) comment '更新人',
   ordernum             INT comment '排序号',
   state                CHAR(1) comment '状态，1：有效，0：无效',
   primary key (id)
);

alter table pagecomponent comment '页面组件';

/*==============================================================*/
/* Table: pagehtml                                              */
/*==============================================================*/
create table pagehtml
(
   id                   VARCHAR(50) not null comment '主键',
   pageid               VARCHAR(50) comment '页面ID',
   html                 mediumtext comment '页面HTML代码',
   createdate           DATETIME comment '创建时间',
   createuser           VARCHAR(50) comment '创建人',
   updatedate           DATETIME comment '修改时间',
   updateuser           VARCHAR(50) comment '修改人',
   ordernum             INT comment '排序号',
   state                CHAR(1) comment '状态,1：有效，0：无效',
   primary key (id)
);

alter table pagehtml comment '页面HTML';

alter table componentattr add constraint FK_Reference_2 foreign key (componentid)
      references page (id) on delete restrict on update restrict;

alter table componentattr add constraint FK_Reference_3 foreign key (componentid)
      references pagecomponent (id) on delete restrict on update restrict;

alter table pagecomponent add constraint FK_Reference_1 foreign key (pageid)
      references page (id) on delete restrict on update restrict;

alter table pagehtml add constraint FK_Reference_4 foreign key (pageid)
      references page (id) on delete restrict on update restrict;

