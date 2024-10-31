package com.clinica.dto;

import com.clinica.modelo.Animal;
import com.clinica.modelo.Veterinario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Data
@NoArgsConstructor
public class ConsultaDTO {

    private Long id;
    private String dataDoRegistro = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private String obs;
    private Veterinario veterinario;
    private Animal animal;
}
