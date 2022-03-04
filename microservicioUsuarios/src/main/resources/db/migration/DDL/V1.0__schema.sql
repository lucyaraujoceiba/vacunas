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