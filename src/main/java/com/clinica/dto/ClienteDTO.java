package com.clinica.dto;

import com.clinica.modelo.Animal;
import com.clinica.modelo.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nome;
    private String fone;
    private String email;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private List<Animal> animal = new ArrayList<>();

    public ClienteDTO(Cliente cadastrar) {
        this.id = cadastrar.getId();
        this.nome = cadastrar.getNome();
        this.fone = cadastrar.getFone();
        this.rua = cadastrar.getRua();
        this.numero = cadastrar.getNumero();
        this.email = cadastrar.getEmail();
        this.bairro = cadastrar.getBairro();
        this.cidade = cadastrar.getCidade();
        this.estado = cadastrar.getEstado();
        this.animal = cadastrar.getAnimal();

    }
}