package com.clinica.modelo;

import com.clinica.dto.AnimalDTO;
import com.clinica.enums.Especie;
import com.clinica.enums.Sexo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "animais")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Enumerated(EnumType.STRING)
	private Especie especie;
	private String nome;
	private String raca;
	private String cor;
	private Integer idade;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@OneToOne(mappedBy = "animal",cascade = CascadeType.ALL)
    private Consulta consulta;

	public Animal(AnimalDTO animalDTO) {
		this.especie = animalDTO.getEspecie();
		this.id = animalDTO.getId();
		this.nome = animalDTO.getNome();
		this.raca = animalDTO.getRaca();
		this.cor = animalDTO.getCor();
		this.idade = animalDTO.getIdade();
		this.sexo = animalDTO.getSexo();
		this.consulta = animalDTO.getConsulta();
	}
}
