package org.example.apibarbeariamanodi.app.dtos;

public class AgendaBarbeiroDTO {
    private Integer id;
    private Integer idBarbeiro;
    private String diaSemana;
    private String horarioInicio;
    private String horarioFim;
    private Boolean ativo;

    public AgendaBarbeiroDTO() {
    }

    public AgendaBarbeiroDTO(Integer id, Integer idBarbeiro, String diaSemana, String horarioInicio, String horarioFim, Boolean ativo) {
        this.id = id;
        this.idBarbeiro = idBarbeiro;
        this.diaSemana = diaSemana;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.ativo = ativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdBarbeiro() {
        return idBarbeiro;
    }

    public void setIdBarbeiro(Integer idBarbeiro) {
        this.idBarbeiro = idBarbeiro;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(String horarioFim) {
        this.horarioFim = horarioFim;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "AgendaBarbeiroDTO{" +
                "id=" + id +
                ", idBarbeiro=" + idBarbeiro +
                ", diaSemana='" + diaSemana + '\'' +
                ", horarioInicio='" + horarioInicio + '\'' +
                ", horarioFim='" + horarioFim + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
