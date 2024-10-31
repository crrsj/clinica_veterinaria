package com.clinica.repositorio;

import com.clinica.modelo.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepositorio extends JpaRepository<Veterinario,Long> {

}
