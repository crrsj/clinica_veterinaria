package com.clinica.dto;

import com.clinica.modelo.Consulta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class VeterinarioDTO {
    private Long id;
    private String nome;
    private String crmv;
    private String especialidade;
    private Consulta consulta;


}
