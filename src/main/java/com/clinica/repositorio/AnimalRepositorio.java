package com.clinica.repositorio;

import com.clinica.modelo.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepositorio extends JpaRepository<Animal,Long> {
}
