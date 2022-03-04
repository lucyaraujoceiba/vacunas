update usuario
set nombre = :nombre,
	tipo_sangre = :tipoSangre,
	fecha_creacion = :fechaCreacion,
	numeroIdentificacion = :numeroIdentificacion,
    tipoIdentificacion = :tipoIdentificacion,
    fechaNacimiento = :fechaNacimiento
where id = :id