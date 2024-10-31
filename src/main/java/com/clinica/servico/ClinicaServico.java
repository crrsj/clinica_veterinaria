package com.clinica.servico;

import com.clinica.dto.AnimalDTO;
import com.clinica.dto.ClienteDTO;
import com.clinica.dto.ConsultaDTO;
import com.clinica.dto.VeterinarioDTO;
import com.clinica.modelo.Animal;
import com.clinica.modelo.Cliente;
import com.clinica.modelo.Consulta;
import com.clinica.modelo.Veterinario;
import com.clinica.repositorio.AnimalRepositorio;
import com.clinica.repositorio.ClienteRepositorio;
import com.clinica.repositorio.ConsultaRepositorio;
import com.clinica.repositorio.VeterinarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicaServico {

    private ClienteRepositorio clienteRepositorio;
    private AnimalRepositorio animalRepositorio;
    private ConsultaRepositorio consultaRepositorio;
    private VeterinarioRepositorio veterinarioRepositorio;

    public ClinicaServico(ClienteRepositorio clienteRepositorio, AnimalRepositorio animalRepositorio, ConsultaRepositorio consultaRepositorio, VeterinarioRepositorio veterinarioRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
        this.animalRepositorio = animalRepositorio;
        this.consultaRepositorio = consultaRepositorio;
        this.veterinarioRepositorio = veterinarioRepositorio;
    }

    public Cliente cadastrarCliente(ClienteDTO clienteDTO){
        var cadastrar = new Cliente(clienteDTO);
        return clienteRepositorio.save(cadastrar);
    }

    public Animal cadastrarAnimal(AnimalDTO animalDTO,Long clienteId ){
     var novoAnimal = new Animal(animalDTO);
     var cliente = clienteRepositorio.findById(clienteId).get();
     novoAnimal.setCliente(cliente);
     return animalRepositorio.save(novoAnimal);
    }
    public List<ClienteDTO>buscarTodos() {
        return clienteRepositorio.findAll().stream().map(ClienteDTO::new).toList();
    }

    public Consulta cadastrarConsulta(ConsultaDTO consultaDTO,Long animalId){
        var novaConsulta = new Consulta(consultaDTO);
        var animal = animalRepositorio.findById(animalId).get();
        novaConsulta.setAnimal(animal);
        return consultaRepositorio.save(novaConsulta);
    }

    public Veterinario cadastrarVeterinario(VeterinarioDTO veterinarioDTO,Long consultaId){
        var novoVeterinario = new Veterinario(veterinarioDTO);
        var consulta = consultaRepositorio.findById(consultaId).get();
        novoVeterinario.setConsulta(consulta);
        return veterinarioRepositorio.save(novoVeterinario);
    }
}
