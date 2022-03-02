package com.ceiba.vacuna.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Setter
@Getter
public class Vacuna {
    private static final String SE_DEBE_INGRESAR_LA_FECHA_APLICACION = "Se debe ingresar la fecha de aplicacion";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO = "Se debe ingresar el estado";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_VACUNA = "Se debe ingresar el nombre de la vacuna";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_DE_VACUNA = "Se debe ingresar el valor de la vacuna";
    private static final String SE_DEBE_INGRESAR_EL_ID_USUARIO = "Se debe ingresar el identificador del usuario";
    private static final String SE_DEBE_INGRESAR_EL_TIEMPO_ENTRE_DOSIS = "Se debe ingresar el tiempo entre dosis";


    private Long id;
    private String nombre;
    private String estado;
    private LocalDateTime fechaAplicacion;
    private String subsidiada;
    private Long valor;
    private Long idUsuario;
    private Long dosis;
    private String dosisPendiente;
    private Long tiempoEntreDosis;

    public Vacuna(Long id, String nombre, String estado, LocalDateTime fechaAplicacion,
                  String subsidiada, Long valor, Long dosis, Long idUsuario,String dosisPendiente,Long tiempoEntreDosis) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_VACUNA);
        validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO);
        validarObligatorio(fechaAplicacion, SE_DEBE_INGRESAR_LA_FECHA_APLICACION);
        validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR_DE_VACUNA);
        validarObligatorio(idUsuario,SE_DEBE_INGRESAR_EL_ID_USUARIO);
        validarObligatorio(tiempoEntreDosis,SE_DEBE_INGRESAR_EL_TIEMPO_ENTRE_DOSIS);

        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaAplicacion = fechaAplicacion;
        this.subsidiada = subsidiada;
        this.valor = valor;
        this.dosis = dosis;
        this.idUsuario = idUsuario;
        this.dosisPendiente =dosisPendiente;
        this.tiempoEntreDosis =tiempoEntreDosis;
    }

}
