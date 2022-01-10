/*==============================================================*/
/* Nom de SGBD :  PostgreSQL 8                                  */
/* Date de création :  10/08/2021 17:45:11                      */
/*==============================================================*/


/*==============================================================*/
/* Table : contrat                                              */
/*==============================================================*/
create table contrat (
   local_id             int4                 not null,
   user_id              int4                 not null,
   contrat_id                   serial                 not null,
   date_ent             date                 null,
   montant_mensuel      numeric              null,
   constraint pk_contrat primary key (local_id, user_id, contrat_id)
);

/*==============================================================*/
/* Index : contrat_pk                                           */
/*==============================================================*/
create unique index contrat_pk on contrat (
local_id,
user_id,
contrat_id
);

/*==============================================================*/
/* Index : association_4_fk                                     */
/*==============================================================*/
create  index association_4_fk on contrat (
local_id
);

/*==============================================================*/
/* Index : association_4_fk2                                    */
/*==============================================================*/
create  index association_4_fk2 on contrat (
user_id
);

/*==============================================================*/
/* Table : facture                                              */
/*==============================================================*/
create table facture (
   facture_id                   serial                 not null,
   local_id             int4                 not null,
   user_id              int4                 not null,
   contrat_id           int4                 not null,
   date                 date                 null,
   statut               int2                 null,
   constraint pk_facture primary key (facture_id)
);

/*==============================================================*/
/* Index : facture_pk                                           */
/*==============================================================*/
create unique index facture_pk on facture (
facture_id
);

/*==============================================================*/
/* Index : association_5_fk                                     */
/*==============================================================*/
create  index association_5_fk on facture (
local_id,
user_id,
contrat_id
);

/*==============================================================*/
/* Table : local                                                */
/*==============================================================*/
create table local (
   local_id             serial               not null,
   designation          varchar(254)         null,
   lieu                 varchar(254)         null,
   constraint pk_local primary key (local_id)
);

/*==============================================================*/
/* Index : local_pk                                             */
/*==============================================================*/
create unique index local_pk on local (
local_id
);

/*==============================================================*/
/* Table : messagerie                                           */
/*==============================================================*/
create table messagerie (
   message_id                   serial                 not null,
   content              varchar(254)         null,
   demande_string       varchar(254)         null,
   constraint pk_messagerie primary key (message_id)
);

/*==============================================================*/
/* Index : messagerie_pk                                        */
/*==============================================================*/
create unique index messagerie_pk on messagerie (
message_id
);

/*==============================================================*/
/* Table : role                                                 */
/*==============================================================*/
create table roles (
   id                   serial                 not null,
   name                 varchar(254)         null,
   constraint pk_role primary key (id)
);

/*==============================================================*/
/* Index : role_pk                                              */
/*==============================================================*/
create unique index role_pk on role (
id
);

/*==============================================================*/
/* Table : "user"                                               */
/*==============================================================*/
create table "users" (
   id                   serial                 not null,
   username             varchar(254)         null,
   email                varchar(254)         null,
   password             varchar(254)         null,
   name                 varchar(254)         null,
   date_naiss           date                 null,
   lieu_naiss           varchar(254)         null,
   numcni               int4                 null,
   tel                  varchar(254)         null,
   constraint pk_user primary key (id)
);

/*==============================================================*/
/* Index : user_pk                                              */
/*==============================================================*/
create unique index user_pk on "user" (
id
);

/*==============================================================*/
/* Table : user_mess                                            */
/*==============================================================*/
create table user_mess (
   user_id              int4                 not null,
   message_id           int4                 not null,
   constraint pk_user_mess primary key (user_id, message_id)
);

/*==============================================================*/
/* Index : association_3_pk                                     */
/*==============================================================*/
create unique index association_3_pk on user_mess (
user_id,
message_id
);

/*==============================================================*/
/* Index : association_3_fk                                     */
/*==============================================================*/
create  index association_3_fk on user_mess (
user_id
);

/*==============================================================*/
/* Index : association_3_fk2                                    */
/*==============================================================*/
create  index association_3_fk2 on user_mess (
message_id
);

/*==============================================================*/
/* Table : user_roles                                           */
/*==============================================================*/
create table user_roles (
   user_id              int4                 not null,
   role_id              int4                 not null,
   constraint pk_user_roles primary key (user_id, role_id)
);

/*==============================================================*/
/* Index : association_1_pk                                     */
/*==============================================================*/
create unique index association_1_pk on user_roles (
user_id,
role_id
);

/*==============================================================*/
/* Index : association_1_fk                                     */
/*==============================================================*/
create  index association_1_fk on user_roles (
user_id
);

/*==============================================================*/
/* Index : association_1_fk2                                    */
/*==============================================================*/
create  index association_1_fk2 on user_roles (
role_id
);

alter table contrat
   add constraint fk_contrat_associati_local foreign key (local_id)
      references local (local_id)
      on delete restrict on update restrict;

alter table contrat
   add constraint fk_contrat_associati_user foreign key (user_id)
      references "user" (id)
      on delete restrict on update restrict;

alter table facture
   add constraint fk_facture_associati_contrat foreign key (local_id, user_id, contrat_id)
      references contrat (local_id, user_id, id)
      on delete restrict on update restrict;

alter table user_mess
   add constraint fk_user_mes_associati_messager foreign key (message_id)
      references messagerie (message_id)
      on delete restrict on update restrict;

alter table user_mess
   add constraint fk_user_mes_associati_user foreign key (user_id)
      references "user" (id)
      on delete restrict on update restrict;

alter table user_roles
   add constraint fk_user_rol_associati_role foreign key (role_id)
      references role (id)
      on delete restrict on update restrict;

alter table user_roles
   add constraint fk_user_rol_associati_user foreign key (user_id)
      references "user" (id)
      on delete restrict on update restrict;

