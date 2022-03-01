select v.id,v.nombre,v.estado,v.fecha_aplicacion, v.subsidiada, v.valor, v.dosis,
v.id_usuario, v.dosis_pendiente, v.tiempo_entre_dosis
from vacuna v
where v.id_usuario = :idUsuario
and v.estado = 'pendiente'
and v.fecha_aplicacion = (select MIN(c.fecha_aplicacion) from vacuna c
                        where v.id_usuario = c.id_usuario and c.estado = 'pendiente' )
