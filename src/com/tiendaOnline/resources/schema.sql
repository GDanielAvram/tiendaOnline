drop database if exists tiendaOnline;
create database tiendaOnline;
use tiendaOnline;
    
drop table if exists cliente
drop table if exists lineasdecompra    
drop table if exists producto    
drop table if exists venta   
drop table if exists Cliente_Rol    
drop table if exists hibernate_sequence    
drop table if exists Rol
drop table if exists categoria
    
    create table cliente (
        idCliente bigint NOT NULL AUTO_INCREMENT,
        apellidos varchar(255) NOT NULL,
        banco varchar(255) NOT NULL,
        codigoSeguridad varchar(255) NOT NULL,
        direccionEnvio varchar(255) NOT NULL,
        direccionFacturacion varchar(255) NOT NULL,
        email varchar(255) NOT NULL,
        fechaNacimiento varchar(255) NOT NULL,
        nombre varchar(255) NOT NULL,
        nombreUsuario varchar(255) NOT NULL,
        numeroTarjeta varchar(255) NOT NULL,
        password varchar(255) NOT NULL,
        titular varchar(255) NOT NULL,
        primary key (idCliente)
    ) engine=MyISAM

    create table lineasdecompra (
       idLineaCompra bigint not null AUTO_INCREMENT,
        idProducto bigint NOT NULL,
        idVenta bigint NOT NULL,
        precioProducto double precision NOT NULL,
        primary key (idLineaCompra)
    ) engine=MyISAM
    
    create table producto (
        idProducto bigint not null auto_increment,
	idCategoria bigint default null,
        nombreProducto varchar(45) NOT NULL,
        Precio double precision NOT NULL,
        Stock bigint NOT NULL,
        primary key (idProducto),
	constraint 'FK_P_IDCATEGORIA' foreign key ('idCategoria') references 'categoria' ('idCategoria')
    ) engine=MyISAM
    
    create table venta (
        idVenta bigint not null auto_increment,
	
        descuento double precision ,
        fechaVenta datetime NOT NULL,
        idCliente bigint NOT NULL,
        primary key (idVenta),
    ) engine=MyISAM
    
    create table Cliente_Rol (
       idRol integer not null,
        idCliente bigint not null,
        primary key (idCliente, idRol)
    ) engine=MyISAM
    
    create table hibernate_sequence (
       next_val bigint
    ) engine=MyISAM
    
    insert into hibernate_sequence values ( 1 )
    
    create table Rol (
       idRol integer not null auto_increment,
        nombreRol varchar(255),
        primary key (idRol)
    ) engine=MyISAM
    
    alter table Cliente_Rol 
       add constraint FKokgjhk8xvf9swwhnduowpc3wf 
       foreign key (idCliente) 
       references cliente (idCliente)
    
    alter table Cliente_Rol 
       add constraint FKgl3eikbcqnapamih88g7v51ln 
       foreign key (idRol) 
       references Rol (idRol)

    create table categoria (
	idCategoria bigint not null auto_increment,
	nombreCategoria varchar(255),
	primary key (idCategoria)
    )
	
	