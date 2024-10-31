package com.clinica.modelo;

import java.util.ArrayList;
import java.util.List;

import com.clinica.dto.VeterinarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "veterinarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veterinario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String crmv;
	private String especialidade;
	@OneToOne
	@JoinColumn(name ="veterinario_id")
	@JsonIgnore
	private Consulta consulta;


	public Veterinario(VeterinarioDTO veterinarioDTO) {
		this.id = veterinarioDTO.getId();
		this.nome = veterinarioDTO.getNome();
		this.crmv =veterinarioDTO.getCrmv();
		this.especialidade = veterinarioDTO.getEspecialidade();
		this.consulta = veterinarioDTO.getConsulta();

	}


}
