package com.martins.helina.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class CronogramaDTO {
    private String diaSemana;
    private String horaAbertura;
    private String horaFechamento;
}
