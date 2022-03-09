select v.id,v.nombre,v.estado,v.fecha_aplicacion, v.subsidiada, v.valor, v.dosis, v.id_usuario, v.dosis_pendiente,v.tiempo_entre_dosis
from usuario u join vacuna v
on u.id = v.id_usuario
where u.tipoIdentificacion = :tipoDocumento
and u.numeroIdentificacion = :documento
and v.estado = 'aplicada'