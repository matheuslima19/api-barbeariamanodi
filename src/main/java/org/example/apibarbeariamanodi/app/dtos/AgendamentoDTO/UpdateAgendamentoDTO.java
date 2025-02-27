package org.example.apibarbeariamanodi.app.dtos.AgendamentoDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class UpdateAgendamentoDTO {
    private Integer id;
    private LocalDate dataAgendamento;
    private LocalTime horario;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}