package com.ceiba.vacuna.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DtoListaVacunas {
    List<DtoVacuna> listaVacunas;
    Long valorTotal;
}
