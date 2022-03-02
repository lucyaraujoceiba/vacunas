select count(1) from vacuna
where nombre = :nombre
and id_usuario = :id_usuario
and dosis = :dosis