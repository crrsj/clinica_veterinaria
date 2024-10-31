package com.clinica.controle;

import com.clinica.dto.AnimalDTO;
import com.clinica.dto.ClienteDTO;
import com.clinica.dto.ConsultaDTO;
import com.clinica.dto.VeterinarioDTO;
import com.clinica.modelo.Animal;
import com.clinica.modelo.Cliente;
import com.clinica.modelo.Consulta;
import com.clinica.modelo.Veterinario;
import com.clinica.servico.ClinicaServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clinica")
public class ClinicaControle {


    private ClinicaServico clinicaServico;


    public ClinicaControle(ClinicaServico clinicaServico) {
        this.clinicaServico = clinicaServico;
    }

    @PostMapping
    public ResponseEntity<Cliente>cadastrarCliente(@RequestBody ClienteDTO clienteDTO){
      var cadastro =  clinicaServico.cadastrarCliente(clienteDTO);
        return new ResponseEntity<>(cadastro,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>>buscarTodos(){
        var buscar = clinicaServico.buscarTodos();
        return new ResponseEntity<List<ClienteDTO>>(buscar,HttpStatus.OK);
    }
    @PostMapping("animal/{clienteId}")
    public ResponseEntity<Animal>cadastrarAnimal(@RequestBody AnimalDTO animalDTO
            ,@PathVariable ("clienteId")Long clienteId){
        var cadastroAnimal = clinicaServico.cadastrarAnimal(animalDTO,clienteId);
        return new ResponseEntity<>(cadastroAnimal,HttpStatus.CREATED);
    }

    @PostMapping("consulta/{animalId}")
    public ResponseEntity<Consulta>cadastrarConsulta(@RequestBody ConsultaDTO consultaDTO,
           @PathVariable("animalId")Long animalId){
        var cadastrarConsulta = clinicaServico.cadastrarConsulta(consultaDTO,animalId);
        return new ResponseEntity<>(cadastrarConsulta,HttpStatus.CREATED);
    }

    @PostMapping("veterinario/{animalId}")
    public ResponseEntity<Veterinario>cadastrarVeterinario(@RequestBody VeterinarioDTO vaterVeterinarioDTO,
       @PathVariable("animalId")Long animalId){
       var veterinario = clinicaServico.cadastrarVeterinario(vaterVeterinarioDTO,animalId);
       return new ResponseEntity<>(veterinario,HttpStatus.CREATED);

    }
}
