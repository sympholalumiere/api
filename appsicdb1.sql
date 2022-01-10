/*==============================================================*/
/* Nom de SGBD :  PostgreSQL 8                                  */
/* Date de cr�ation :  18/08/2021 12:31:58                      */
/*==============================================================*/


/*==============================================================*/
/* Table : Association_2                                        */
/*==============================================================*/
create table Association_2 (
   id                   INT4                 not null,
   message_id           INT4                 not null,
   constraint PK_ASSOCIATION_2 primary key (id, message_id)
);

/*==============================================================*/
/* Table : Contrat                                              */
/*==============================================================*/
create table Contrat (
   contrat_id           SERIAL                 not null,
   id                   INT4                 not null,
   Local_id             INT4                 not null,
   date_deb             DATE                 null,
   date_fin             DATE                 null,
   type_contrat         VARCHAR(254)         null,
   montant_mensuel      VARCHAR(254)         null,
   cit�                 VARCHAR(254)         null,
   lieu_enregistrement  VARCHAR(254)         null,
   taux_de_facturation  VARCHAR(254)         null,
   mode_de_paie         VARCHAR(254)         null,
   type_appartement     VARCHAR(254)         null,
   numero_de_compte     VARCHAR(254)         null,
   constraint PK_CONTRAT primary key (contrat_id)
);

/*==============================================================*/
/* Table : Facture                                              */
/*==============================================================*/
create table Facture (
   facture_id           SERIAL                 not null,
   contrat_id           INT4                 not null,
   date                 DATE                 null,
   delais_reglement     INT4                 null,
   constraint PK_FACTURE primary key (facture_id)
);

/*==============================================================*/
/* Table : Local                                                */
/*==============================================================*/
create table Local (
   Local_id             SERIAL                 not null,
   add_local            VARCHAR(254)         null,
   designation          VARCHAR(254)         null,
   lieu                 VARCHAR(254)         null,
   type_local           VARCHAR(254)         null,
   constraint PK_LOCAL primary key (Local_id)
);

/*==============================================================*/
/* Table : Messagerie                                           */
/*==============================================================*/
create table Messagerie (
   message_id           SERIAL                 not null,
   contenu              VARCHAR(254)         null,
   constraint PK_MESSAGERIE primary key (message_id)
);

/*==============================================================*/
/* Table : Roles                                                */
/*==============================================================*/
create table Roles (
   id                   SERIAL                 not null,
   name                 VARCHAR(254)         null,
   constraint PK_ROLES primary key (id)
);

/*==============================================================*/
/* Table : "User"                                               */
/*==============================================================*/
create table "User" (
   id                   SERIAL                 not null,
   name                 VARCHAR(254)         null,
   username             VARCHAR(254)         null,
   email                VARCHAR(254)         null,
   password             VARCHAR(254)         null,
   constraint PK_USER primary key (id)
);

/*==============================================================*/
/* Table : user_roles                                           */
/*==============================================================*/
create table user_roles (
   user_id              INT4                 not null,
   role_id              INT4                 not null,
   constraint PK_USER_ROLES primary key (user_id, role_id)
);

alter table Association_2
   add constraint FK_ASSOCIAT_ASSOCIATI_MESSAGER foreign key (message_id)
      references Messagerie (message_id)
      on delete restrict on update restrict;

alter table Association_2
   add constraint FK_ASSOCIAT_ASSOCIATI_USER foreign key (id)
      references "User" (id)
      on delete restrict on update restrict;

alter table Contrat
   add constraint FK_CONTRAT_ASSOCIATI_LOCAL foreign key (Local_id)
      references Local (Local_id)
      on delete restrict on update restrict;

alter table Contrat
   add constraint FK_CONTRAT_ASSOCIATI_USER foreign key (id)
      references "User" (id)
      on delete restrict on update restrict;

alter table Facture
   add constraint FK_FACTURE_ASSOCIATI_CONTRAT foreign key (contrat_id)
      references Contrat (contrat_id)
      on delete restrict on update restrict;

alter table user_roles
   add constraint FK_USER_ROL_ASSOCIATI_ROLES foreign key (role_id)
      references Roles (id)
      on delete restrict on update restrict;

alter table user_roles
   add constraint FK_USER_ROL_ASSOCIATI_USER foreign key (user_id)
      references "User" (id)
      on delete restrict on update restrict;

