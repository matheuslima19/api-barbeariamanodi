package org.example.apibarbeariamanodi.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.apibarbeariamanodi.domain.enums.DiaSemana;
import java.time.LocalTime;

@Table(name = "agenda_barbeiro")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AgendaBarbeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_barbeiro")
    private Barbeiro barbeiro;
}
