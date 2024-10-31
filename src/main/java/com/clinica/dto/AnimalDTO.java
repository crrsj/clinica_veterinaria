package com.clinica.dto;

import com.clinica.enums.Especie;
import com.clinica.enums.Sexo;
import com.clinica.modelo.Cliente;
import com.clinica.modelo.Consulta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimalDTO {
    private Long id;
    private Especie especie;
    private String nome;
    private String raca;
    private String cor;
    private Integer idade;
    private Sexo sexo;
    private Cliente cliente;
    private Consulta consulta;
}
