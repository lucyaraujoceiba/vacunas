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

create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 tipo_sangre varchar(5) not null,
 fecha_creacion datetime null,
 tipoIdentificacion varchar(4) not null,
 numeroIdentificacion varchar(45) not null,
 fechaNacimiento varchar(20) not null,
 primary key (id)
);