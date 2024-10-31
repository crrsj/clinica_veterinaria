package com.clinica.repositorio;

import com.clinica.modelo.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepositorio extends JpaRepository<Consulta,Long> {
}
