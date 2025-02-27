package org.example.apibarbeariamanodi.domain.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "agendamento")
@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataAgendamento;

    private LocalTime horario;

    private String status;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_barbeiro")
    private Barbeiro barbeiro;

    public Agendamento() {}

    public Agendamento(Integer id, LocalDate dataAgendamento, LocalTime horario, String status, Cliente cliente, Barbeiro barbeiro) {
        this.id = id;
        this.dataAgendamento = dataAgendamento;
        this.horario = horario;
        this.status = status;
        this.cliente = cliente;
        this.barbeiro = barbeiro;
    }

    
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }
}