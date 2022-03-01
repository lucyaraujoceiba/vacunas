create table vacuna(
	id int(11) not null auto_increment,
	nombre varchar(100) not null,
	estado varchar(20) not null,
	fecha_aplicacion datetime not null,
	subsidiada varchar(10) not null,
	valor int(10) not null, 
	dosis int(2) not null,
	id_usuario int(11) not null,
	dosis_pendiente varchar(2) not null,
	tiempo_entre_dosis int(3) not null,
	primary key (id)
);