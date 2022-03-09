select id,nombre,tipo_sangre,fecha_creacion, numeroIdentificacion, tipoIdentificacion, fechaNacimiento
from usuario
where tipoIdentificacion = :tipoDocumento
and numeroIdentificacion = :documento