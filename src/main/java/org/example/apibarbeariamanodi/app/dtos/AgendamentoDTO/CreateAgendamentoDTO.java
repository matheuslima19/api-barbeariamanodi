package org.example.apibarbeariamanodi.app.dtos.AgendamentoDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateAgendamentoDTO {
    private LocalDate dataAgendamento;
    private LocalTime horario;
    private Integer idCliente;
    private Integer idBarbeiro;


    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdBarbeiro() {
        return idBarbeiro;
    }

    public void setIdBarbeiro(Integer idBarbeiro) {
        this.idBarbeiro = idBarbeiro;
    }
}