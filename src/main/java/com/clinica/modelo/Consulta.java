package com.clinica.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.clinica.dto.ConsultaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "consultas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dataDoRegistro = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private String obs;
    @OneToOne(mappedBy = "consulta",cascade = CascadeType.ALL)
    private Veterinario veterinario;
    @OneToOne
    @JsonIgnore
    private Animal animal;

    public Consulta(ConsultaDTO consultaDTO) {
        this.id = consultaDTO.getId();
        this.dataDoRegistro = consultaDTO.getDataDoRegistro();
        this.dataConsulta = consultaDTO.getDataConsulta();
        this.horaConsulta = consultaDTO.getHoraConsulta();
        this.obs = consultaDTO.getObs();
        this.animal = consultaDTO.getAnimal();
    }
}
