select id,nombre,estado,fecha_aplicacion, subsidiada, valor, dosis, id_usuario, dosis_pendiente,tiempo_entre_dosis
from vacuna
where id_usuario = :idUsuario
and estado = 'aplicada'
