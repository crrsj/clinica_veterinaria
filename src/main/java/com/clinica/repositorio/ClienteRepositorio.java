package com.clinica.repositorio;

import com.clinica.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio  extends JpaRepository<Cliente,Long> {
}
