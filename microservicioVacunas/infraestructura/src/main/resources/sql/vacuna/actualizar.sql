update vacuna
set nombre = :nombre,
	estado = :estado,
	fecha_aplicacion = :fechaAplicacion,
	subsidiada = :subsidiada,
    valor = :valor,
    dosis = :dosis,
    id_usuario = :idUsuario,
    dosis_pendiente = :dosisPendiente,
    tiempo_entre_dosis = :tiempoEntreDosis,
where id = :id