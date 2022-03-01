select sum(v.valor)
from vacuna v
 where v.id_usuario = :idUsuario
 and v.estado = 'pendiente'
 and v.fecha_aplicacion = (select MIN(c.fecha_aplicacion) from vacuna c
                        where v.id_usuario = c.id_usuario and c.estado = 'pendiente' )
