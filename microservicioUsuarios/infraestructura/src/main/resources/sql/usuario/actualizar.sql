update usuario
set nombre = :nombre,
	clave = :clave,
	fecha_creacion = :fechaCreacion,
	numeroIdentificacion = :numeroIdentificacion,
    tipoIdentificacion = :tipoIdentificacion,
    fechaNacimiento = :fechaNacimiento
where id = :id