DROP DATABASE IF EXISTS CinePlus2;
CREATE DATABASE CinePlus2;
USE CinePlus2;

create table tipouser(
	idtipo int primary key auto_increment,
    desctipo varchar(100) not null
);

create table usercine(
    idusuario varchar(500) primary key,
    nombre varchar(100) not null,
    apellidos varchar(100) not null,
    tipouser int not null,
    email varchar(50) not null unique,
    password varchar(20) not null,
    estado char(1) not null,
    foreign key (tipouser) references tipouser(idtipo)
);

create table cliente(
	idcliente varchar(500) primary key,
    nombre varchar(100) not null,
    apellidos varchar(100) not null,
    telefono char(12) not null,
    email varchar(50) not null unique,
	password varchar(50) not null,
    fecharegistro datetime
);

create table tipopeli(
	idtipo int primary key AUTO_INCREMENT,
    desctipo varchar(100) not null
);

create table pelicula(
	idpeli varchar(500) primary key,
    titulo varchar(100) not null,
    tipopeli int not null,
    fechaestreno datetime not null,
    fechafinal datetime null,
    fecharegistro datetime,
    estado char(1) check(estado in ('A','I')),
	foreign key (tipopeli) references tipopeli(idtipo)
);

create table tipocomest(
	idtipocomestible int primary key AUTO_INCREMENT,
    descrip varchar(50) not null
);

create table comestible(
	idcomestible varchar(500) primary key,
    descrip varchar(50) not null,
    precio float not null,
    stockactual int not null,
	idtipocomestible int not null,
    fecharegistro datetime,
    estado char(1) check(estado in ('A','I')),
	foreign key (idtipocomestible) references tipocomest(idtipocomestible)
    );

create table venta(
	idventa int primary key not null,
    idtrasac varchar(500),
    idcliente varchar(500) not null,
    fechaventa datetime not null,
    descripcionventa varchar(500),
    preciototal float not null,
    foreign key (idcliente) references cliente(idcliente)
);

create table detalleventa(
	iddetaventa int primary key AUTO_INCREMENT,
	idventa int not null,
    idpeli varchar(500) not null,
    idcomestible varchar(500) null,
    cantidadtickets int not null,
    cantidadcomest int,
    total float not null,
    foreign key (idventa) references venta(idventa),
    foreign key (idpeli) references pelicula(idpeli),
    foreign key (idcomestible) references comestible(idcomestible)
);

create table carrito(
idcarrito int primary key auto_increment,
idcliente varchar(500) not null,
idpelicula varchar(500) not null,
idcomestible varchar(500) not null,
cantidadticket  int not null,
cantidadcomestible int not null,
fecharegistro datetime
);
-------------------------------------------------------------------------------------------------------------------------------
create table sala
(
idsala int primary key auto_increment,
nombre varchar(100),
nrobutacas varchar(100)
);

create table tiporeservacion
(
idreserva int primary key auto_increment,
tiporeservacion varchar(50)
);

create table butaca
(
idbutaca varchar(500) primary key,
fila int,
numero int,
idsala int,
foreign key (idsala) references sala(idsala)
);

create table reservacion
(
idreservacion varchar(500) primary key,
idpeli varchar(500),
idcliente varchar(500),
idreserva int,
contactoreserva varchar(200),
reserva bool,
pago bool,
estado char(1) check(estado in ('A','I')),
foreign key (idpeli) references pelicula(idpeli),
foreign key (idcliente) references cliente(idcliente),
foreign key (idreserva) references tiporeservacion(idreserva)
);

create table butacareserva
(
idresbutaca varchar(500) primary key,
idbutaca varchar(500),
idreservacion varchar(500),
foreign key (idbutaca) references butaca(idbutaca),
foreign key (idreservacion) references reservacion(idreservacion)
);

==============================================================================================================================
//TRIGGERS\\

delimiter $
create trigger autocod_user before insert on usercine for each row
begin
	declare sig_cod int;
    set sig_cod = (select ifnull(max(convert(substring(idusuario, 5 ), signed integer)), 0) from usercine) + 1;
    set new.idusuario = concat('U', LPAD(sig_cod, 5, '0'));
end $

delimiter $
create trigger autocod_cliente before insert on cliente for each row
begin
	declare sig_cod int;
    set sig_cod = (select ifnull(max(convert(substring(idcliente, 5 ), signed integer)), 0) from cliente) + 1;
    set new.idcliente = concat('C', LPAD(sig_cod, 5, '0'));
end $

delimiter $
create trigger autocod_pelicula before insert on pelicula for each row
begin
	declare sig_cod int;
    set sig_cod = (select ifnull(max(convert(substring(idpeli, 5 ), signed integer)), 0) from pelicula) + 1;
    set new.idpeli = concat('P', LPAD(sig_cod, 5, '0'));
end $

delimiter $
create trigger autocod_comestible before insert on comestible for each row
begin
	declare sig_cod int;
    set sig_cod = (select ifnull(max(convert(substring(idcomestible, 5 ), signed integer)), 0) from comestible) + 1;
    set new.idcomestible = concat('C', LPAD(sig_cod, 5, '0'));
end $

delimiter $
create trigger autocod_transac before insert on venta for each row
begin
	declare sig_cod int;
    set sig_cod = (select ifnull(max(convert(substring(idtrasac, 5 ), signed integer)), 0) from venta) + 1;
    set new.idtrasac = concat('T', LPAD(sig_cod, 5, '0'));
end $

delimiter $
create trigger autocod_butacareserv before insert on butacareserva for each row
begin
	declare sig_cod int;
    set sig_cod = (select ifnull(max(convert(substring(idresbutaca, 5 ), signed integer)), 0) from butacareserva) + 1;
    set new.idresbutaca = concat('BR', LPAD(sig_cod, 5, '0'));
end $

delimiter $
create trigger autocod_butaca before insert on butaca for each row
begin
	declare sig_cod int;
    set sig_cod = (select ifnull(max(convert(substring(idbutaca, 5 ), signed integer)), 0) from butaca) + 1;
    set new.idbutaca = concat('B', LPAD(sig_cod, 5, '0'));
end $

delimiter $
create trigger autocod_reserva before insert on reservacion for each row
begin
	declare sig_cod int;
    set sig_cod = (select ifnull(max(convert(substring(idreservacion, 5 ), signed integer)), 0) from reservacion) + 1;
    set new.idreservacion = concat('T', LPAD(sig_cod, 5, '0'));
end $

----------------------------------------------------------------------------------------------------------------------------
insert into tipouser values(null,'Administrador'), (null,'Supervisor');

insert into usercine values(null, 'Sam', 'Sapiel', 1, 'samsapiel@ecorp.com', 'admin12345', 'A')

insert into cliente values(null, 'Juan', 'Quispe Rodriguez', '976894567', 'juanqrod@gmail.com', 'juan24', current_timestamp());

insert into tipopeli values
(null, 'Anime'), (null, 'Terror'), (null, 'Ciencia Ficción'), (null, 'Accion'), (null, 'Drama'), (null, 'Comedia'), (null, 'Romance'),
(null, 'Biografica'), (null, 'Documental'), (null, 'Suspenso'), (null, 'Independiente'), (null, 'Musical')

insert into pelicula values
(null, 'Interstellar', 3 , '2022-07-06', '2022-09-06', current_timestamp, 'A'),
(null, 'Jhon Wick 4', 4 , '2022-03-12', '2022-05-10', current_timestamp, 'A'),
(null, 'Evangelion',  1, '2022-09-06', '2022-12-06', current_timestamp, 'A'),
(null, 'Jobs', 8, '2022-01-02', '2022-03-04', current_timestamp, 'A'),
(null, 'Jhonny English 7', 6, '2022-04-25', '2022-07-20', current_timestamp, 'A')

insert into tipocomest values 
(null, 'Bebidas'), (null, 'Caramelos'), (null, 'Chocolates'), (null, 'Popcorn'), (null, 'Gomitas'), (null, 'Snack') 

insert into comestible values
(null, 'Coca-Cola 700ml', 3.50, 1000, 1, current_timestamp(), 'A'),
(null, 'Pepsi 750ml', 3.00, 1000, 1, current_timestamp(), 'A'), 
(null, 'InkaCola 750ml', 3.50, 1000, 1, current_timestamp(), 'A'), 
(null, 'M&M 250gr', 5.50, 9000, 3, current_timestamp(), 'A'), 
(null, 'Popcorn personal', 6.50, 10000, 4, current_timestamp(), 'A'), 
(null, 'Popcorn familiar', 6.50, 10000, 4, current_timestamp(), 'A'), 
(null, 'Sublime 250gr', 2.50, 10000, 3, current_timestamp(), 'A'), 
(null, 'Mentos', 2.50, 10000, 2, current_timestamp(), 'A'), 
(null, 'Fruggeles 250gr', 6.50, 10000, 6, current_timestamp(), 'A'), 
(null, 'Ositos 250gr', 6.50, 10000, 5, current_timestamp(), 'A')

insert into sala values
(null, 'Primera', '30'), (null, 'Segunda', '30'), (null, 'Tercera', '30'), 
(null, 'Cuarta', '30'),  (null, 'Quinta', '30'),  (null, 'Sexta', '30'),  (null, 'Septima', '30')       

insert into tiporeservacion values
(null, 'Pagada'), (null, 'Pendiente de Pago'), (null, 'Anulada')

insert into butaca values
(null, 1,1, 1), (null, 1,2, 1), (null, 1,3, 1), (null, 1,4, 1), (null, 1,5, 1), (null, 1,6, 1), (null, 1,7, 1), (null, 1,8, 1), (null, 1,9, 1), (null, 1,10, 1),
(null, 2,1, 1), (null, 2,2, 1), (null, 2,3, 1), (null, 2,4, 1), (null, 2,5, 1), (null, 2,6, 1), (null, 2,7, 1), (null, 2,8, 1), (null, 2,9, 1), (null, 2,10, 1),
(null, 3,1, 1), (null, 3,2, 1), (null, 3,3, 1), (null, 3,4, 1), (null, 3,5, 1), (null, 3,6, 1), (null, 3,7, 1), (null, 3,8, 1), (null, 3,9, 1), (null, 3,10, 1)

insert into reservacion values
(null, 'P00001','C00001', 1, '999666354', true, true, 'A')

insert into butacareserva values
(null, 'B00007', 'T00001')

==================================================================================================================================
select * from butaca;
select * from pelicula;
select * from cliente;
select * from butacareserva;
select * from tiporeservacion;
select * from comestible;
select * from usercine;
select * from pelicula;
select * from cliente;
select * from tipocomest;
select * from comestible;
select * from sala;
select * from butaca;
select * from reservacion;
------------------------------------------------------------------------------------------------------------------------------------------


