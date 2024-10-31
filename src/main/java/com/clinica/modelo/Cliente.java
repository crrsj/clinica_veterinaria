package com.clinica.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.clinica.dto.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String fone;
	private String email;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	@JsonIgnore
	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
	private List<Animal> animal = new ArrayList<>();


	public Cliente(ClienteDTO clienteDTO) {
		this.id = clienteDTO.getId();
		this.nome = clienteDTO.getNome();
		this.fone = clienteDTO.getFone();
		this.email = clienteDTO.getEmail();
		this.rua = clienteDTO.getRua();
		this.numero = clienteDTO.getNumero();
		this.bairro = clienteDTO.getBairro();
		this.cidade = clienteDTO.getCidade();
		this.estado = clienteDTO.getEstado();
		this.animal = clienteDTO.getAnimal();

	}
}
